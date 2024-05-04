package tad;

import tad.entities.Aluno;
import tad.services.ListaAlunos;

// Classe principal para testar a lista de alunos
public class App {
    public static void main(String[] args) {
        // Criando instância da lista
        ListaAlunos listaDeAlunos = new ListaAlunos();

        // Criando alguns alunos
        Aluno aluno1 = new Aluno("Aluno 1", "111.456.789-00", "01/01/2005", "A");
        Aluno aluno2 = new Aluno("Aluno 2", "222.654.321-00", "25/05/2006", "B");
        Aluno aluno3 = new Aluno("Aluno 3", "333.456.789-00", "09/11/2007", "A");
        Aluno aluno4 = new Aluno("Aluno 4", "444.654.321-00", "13/07/2008", "B");
        Aluno aluno5 = new Aluno("Aluno 5", "555.456.789-00", "22/03/2009", "A");

        // Adicionando os alunos à lista
        listaDeAlunos.adicionarFim(aluno1);
        listaDeAlunos.adicionarFim(aluno2);
        listaDeAlunos.adicionarFim(aluno3);
        listaDeAlunos.adicionarFim(aluno4);

//        // Imprimindo a lista de alunos
//        listaDeAlunos.imprimir();

        // Adicionando o Aluno 5 ao início da lista
        listaDeAlunos.adicionarInicio(aluno5);
//
//        // Imprimindo a lista de alunos
//        listaDeAlunos.imprimir();

        // Removendo o Aluno 3 da lista
        listaDeAlunos.remover(aluno3);

        // Imprimindo a lista de alunos
        listaDeAlunos.imprimir();
    }
}


