package database.services;

import database.entities.Aluno;
import database.util.ConectarDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ListarAlunosService {
    public static Aluno aluno(String cpf){
        Connection dbConnection = ConectarDB.dbConnection();
        String sql = "SELECT * FROM alunos WHERE cpf = ?";

        try {
            PreparedStatement statement = dbConnection.prepareStatement(sql);
            statement.setString(1, cpf);

            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            Aluno aluno = new Aluno(resultSet);
            dbConnection.close();

            return aluno;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Aluno> listarAlunos(){
        Connection dbConnection = ConectarDB.dbConnection();
        String sql = "SELECT * FROM alunos";
        List<Aluno> alunos = new ArrayList<>();

        try {
            ResultSet resultSet = dbConnection.prepareStatement(sql).executeQuery();

            while (resultSet.next()){
                alunos.add(new Aluno(resultSet));
            }

            dbConnection.close();

            return alunos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
