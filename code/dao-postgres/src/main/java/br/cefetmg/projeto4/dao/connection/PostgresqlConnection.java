package br.cefetmg.projeto4.dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class PostgresqlConnection implements ConnectionFactory {

    private final static String dbDriver = "org.postgresql.Driver";
    private final static String dbURL = "jdbc:postgresql://localhost:5432/sislocdb";
    private final static String user = "postgres";
    private final static String pass = "postgres";

    public PostgresqlConnection() {
    }

    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(dbDriver);
        return DriverManager.getConnection(dbURL, user, pass);
    }

}
