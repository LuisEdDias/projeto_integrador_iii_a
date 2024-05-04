package database.services;

import database.entities.Aluno;
import database.util.ConectarDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public final class AtualizarAlunoService {
    public static void atualizar(Aluno aluno){
        Connection dbConnection = ConectarDB.dbConnection();
        String sql = "UPDATE alunos SET nome = ?, data_nasc = ?, turma = ? WHERE cpf = ?";

        try {
            PreparedStatement statement = dbConnection.prepareStatement(sql);
            statement.setString(1, aluno.getNome());
            statement.setDate(2, aluno.getDataNascimento());
            statement.setString(3, aluno.getTurma());
            statement.setString(4, aluno.getCpf());
            statement.execute();

            dbConnection.close();

            System.out.println("Dados atualizados!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
