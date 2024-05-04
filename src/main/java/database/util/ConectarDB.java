package database.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConectarDB {
    private static final String dbHost = System.getenv("DB_HOST");
    private static final String dbUser = System.getenv("DB_USERNAME");
    private static final String dbPassword = System.getenv("DB_PASSWORD");
    private ConectarDB(){}
    public static Connection dbConnection() {
        try {
            return DriverManager
                    .getConnection("jdbc:mysql://" + dbHost +
                            "/projeto_integrador?user=" + dbUser +
                            "&password=" + dbPassword);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
