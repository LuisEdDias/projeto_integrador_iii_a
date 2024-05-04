package database.controllers;

import database.entities.Aluno;
import database.services.AtualizarAlunoService;
import database.services.CadastrarAlunoService;
import database.services.DeletarAlunoService;
import database.services.ListarAlunosService;
import database.util.ConverterData;

import java.sql.Date;
import java.util.Scanner;

public final class AlunoController {
    Scanner scanner = new Scanner(System.in);

    private String nome;
    private String cpf;
    private Date dataNasc;
    private String turma;

    public void buscarAluno() {
        System.out.println("Digite o CPF do aluno:");
        String cpfIn = scanner.nextLine().replaceAll("\\D", "");

        if (cpfIn.length() == 11) {
            cpf = cpfIn;
            System.out.println(ListarAlunosService.aluno(cpf));
        } else {
            System.out.println("CPF inválido!");
        }
    }

    public void listarAlunos(){
        ListarAlunosService.listarAlunos().forEach(System.out::println);
    }

    public void cadastrar(){
        System.out.println("Digite o nome do aluno:");
        nome = scanner.nextLine();

        if(nome.isEmpty()){
            System.out.println("Nome não pode estar em branco.");
            return;
        }

        System.out.println("Digite o CPF do aluno:");
        String cpfIn = scanner.nextLine().replaceAll("\\D","");

        if (cpfIn.length() == 11) {
            cpf = cpfIn;
        } else {
            System.out.println("CPF inválido!");
            return;
        }

        System.out.println("Digite a data de nascimento do aluno (DD/MM/AAAA):");
        String dataNascIn = scanner.nextLine();

        try{
            dataNasc = ConverterData.converterData(dataNascIn);
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("O aluno será matriculado em qual turma? (A ou B):");
        String turmaIn = scanner.nextLine().toUpperCase().substring(0, 1);

        if(turmaIn.equals("A") || turmaIn.equals("B")){
            turma = turmaIn;
        } else {
            System.out.println("Turma inválida!");
            return;
        }

        CadastrarAlunoService.cadastrarAluno(new Aluno(nome, cpf, dataNasc, turma));
    }

    public void atualizar(){
        Aluno aluno;

        System.out.println("Digite o CPF do aluno:");
        String cpfIn = scanner.nextLine().replaceAll("\\D","");

        if (cpfIn.length() == 11) {
            int resposta;
            cpf = cpfIn;
            aluno = ListarAlunosService.aluno(cpf);

            nome = aluno.getNome();
            dataNasc = aluno.getDataNascimento();
            turma = aluno.getTurma();

            do{
                System.out.println("Os dados do aluno são:");
                System.out.println(aluno);
                System.out.println("1 - Atualizar nome");
                System.out.println("2 - Atualizar data de nascimento");
                System.out.println("3 - Atualizar turma");
                System.out.println("0 - Sair");

                resposta = scanner.nextInt();
                scanner.nextLine();

                switch(resposta){
                    case 1:
                        System.out.println("Digite o nome do aluno:");
                        nome = scanner.nextLine();

                        if(nome.isEmpty()){
                            System.out.println("Nome não pode estar em branco.");
                            break;
                        }

                        aluno.setNome(nome);
                        break;
                    case 2:
                        System.out.println("Digite a data de nascimento do aluno (DD/MM/AAAA):");

                        try{
                            dataNasc = ConverterData.converterData(scanner.nextLine());
                        } catch (RuntimeException e){
                            System.out.println(e.getMessage());
                        }

                        aluno.setDataNascimento(dataNasc);
                        break;
                    case 3:
                        System.out.println("Digite a turma (A ou B):");
                        String turmaIn = scanner.nextLine().toUpperCase().substring(0, 1);

                        if(turmaIn.equals("A") || turmaIn.equals("B")){
                            turma = turmaIn;
                        } else {
                            System.out.println("Turma inválida!");
                        }

                        aluno.setTurma(turma);
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
            } while(resposta != 0);

            AtualizarAlunoService.atualizar(aluno);

        } else {
            System.out.println("CPF inválido!");
        }
    }

    public void delete(){
        System.out.println("Digite o CPF do aluno:");
        String cpfIn = scanner.nextLine().replaceAll("\\D","");

        if (cpfIn.length() == 11) {
            cpf = cpfIn;
            Aluno aluno = ListarAlunosService.aluno(cpf);

            System.out.println("Tem certeza que deseja deletar esses dados do banco?");
            System.out.println(aluno);
            System.out.println("Digite 1 para SIM ou qualquer outra tecla para CANCELAR.");

            int resposta = scanner.nextInt();
            scanner.nextLine();

            if (resposta == 1){
                DeletarAlunoService.deletar(cpf);
            } else {
                System.out.println("CPF inválido!");
            }
        }
    }
}
