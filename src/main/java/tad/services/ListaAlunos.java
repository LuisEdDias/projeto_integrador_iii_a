package tad.services;

import tad.entities.Aluno;
import tad.interfaces.Lista;

// Implementação da lista de alunos
public class ListaAlunos implements Lista<Aluno> {
    private Aluno primeiro; // Referência para o primeiro aluno na lista

    // Construtor
    public ListaAlunos() {
        this.primeiro = null;
    }

    // Método para adicionar um aluno ao final da lista
    public void adicionarFim(Aluno aluno) {
        if (primeiro == null) {
            primeiro = aluno;
        } else {
            Aluno atual = primeiro;
            while (atual.getProximo() != null) {
                atual = atual.getProximo();
            }
            atual.setProximo(aluno);
        }
    }

    // Método para adicionar um aluno no início da lista
    public void adicionarInicio(Aluno aluno) {
        aluno.setProximo(primeiro);
        primeiro = aluno;
    }

    // Método para remover um aluno da lista
    public void remover(Aluno aluno) {
        if (primeiro == null) {
            return;
        }
        if (primeiro == aluno) {
            primeiro = primeiro.getProximo();
            return;
        }
        Aluno atual = primeiro;
        while (atual.getProximo() != null && atual.getProximo() != aluno) {
            atual = atual.getProximo();
        }
        if (atual.getProximo() == aluno) {
            atual.setProximo(aluno.getProximo());
        }
    }

    // Método para imprimir a lista de alunos
    public void imprimir() {
        Aluno atual = primeiro;
        while (atual != null) {
            System.out.println(atual);
            atual = atual.getProximo();
        }
    }
}


