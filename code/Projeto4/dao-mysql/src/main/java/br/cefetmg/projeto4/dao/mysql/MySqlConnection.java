package br.cefetmg.projeto4.dao.mysql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
    private Connection connection;
    private final String host;
    private final String usuario;
    private final String senha;
    private final String database;

    public MySqlConnection(String host, String usuario, String senha, String database) {
        this.host = host;
        this.usuario = usuario;
        this.senha = senha;
        this.database = database;
    }

    public void connect() {
        String url = "jdbc:mysql://" + host + "/" + database;
        try {
            connection = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão estabelecida com o banco de dados");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
