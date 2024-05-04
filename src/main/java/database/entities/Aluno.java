package database.entities;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class Aluno {
    private String nome;
    private final String cpf;
    private Date dataNascimento;
    private String turma;

    public Aluno(String nome, String cpf, Date dataNascimento, String turma) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.turma = turma;
    }

    public Aluno(ResultSet resultSet){
        try {
            this.nome = resultSet.getString("nome");
            this.cpf = resultSet.getString("cpf");
            this.dataNascimento = resultSet.getDate("data_nasc");
            this.turma = resultSet.getString("turma");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String toString() {
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        return  "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataNascimento='" + date.format(dataNascimento) + '\'' +
                ", turma='" + turma + '\'';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }
}
