package tad.entities;


// Classe que representa um aluno
public class Aluno {
    private String nome;
    private String cpf;
    private String dataNascimento;
    private String turma;
    private Aluno proximo; // Referência para o próximo aluno na lista encadeada

    // Construtor
    public Aluno(String nome, String cpf, String dataNascimento, String turma) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.turma = turma;
        this.proximo = null;
    }

    // Método toString para imprimir informações do aluno
    public String toString() {
        return  "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", turma='" + turma;
    }

    // Getters e setters omitidos



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public Aluno getProximo() {
        return proximo;
    }

    public void setProximo(Aluno proximo) {
        this.proximo = proximo;
    }
}
