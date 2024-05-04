package database;

import database.controllers.AlunoController;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		AlunoController alunoController = new AlunoController();

		int continuar;

		do {
			System.out.println("Selecione uma opção:");
			System.out.println("1 - Cadastrar Aluno");
			System.out.println("2 - Atualizar Aluno");
			System.out.println("3 - Deletar Aluno");
			System.out.println("4 - Buscar Aluno");
			System.out.println("5 - Listar Alunos");
			System.out.println("0 - Sair");

			continuar = scanner.nextInt();
			scanner.nextLine();

			switch (continuar) {
				case 1:
					alunoController.cadastrar();
					break;
				case 2:
					alunoController.atualizar();
					break;
				case 3:
					alunoController.delete();
					break;
				case 4:
					alunoController.buscarAluno();
					break;
				case 5:
					alunoController.listarAlunos();
					break;
				case 0:
					System.out.println("Saindo...");
					break;
				default:
					System.out.println("Opção inválida!");
					break;
			}
		} while (continuar != 0);

		scanner.close();
	}
}
