package database.services;

import database.entities.Aluno;
import database.util.ConectarDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public final class CadastrarAlunoService {
    public static void cadastrarAluno(Aluno aluno){
        Connection dbConnection = ConectarDB.dbConnection();
        String sql = "INSERT INTO alunos (nome, cpf, data_nasc, turma) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement statement = dbConnection.prepareStatement(sql);
            statement.setString(1, aluno.getNome());
            statement.setString(2, aluno.getCpf());
            statement.setDate(3, aluno.getDataNascimento());
            statement.setString(4, aluno.getTurma());
            statement.execute();
            dbConnection.close();

            System.out.println("Aluno cadastrado com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
