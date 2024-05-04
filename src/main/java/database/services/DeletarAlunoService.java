package database.services;

import database.util.ConectarDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public final class DeletarAlunoService {
    public static void deletar(String cpf){
        Connection dbConnection = ConectarDB.dbConnection();
        String sql = "DELETE FROM alunos WHERE cpf = ?";

        try {
            PreparedStatement statement = dbConnection.prepareStatement(sql);
            statement.setString(1, cpf);
            statement.execute();

            System.out.println("Registro apagado com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
