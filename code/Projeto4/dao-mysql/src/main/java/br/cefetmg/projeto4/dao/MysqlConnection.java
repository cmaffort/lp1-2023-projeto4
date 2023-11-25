package br.cefetmg.projeto4.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class MysqlConnection {
    private static final String DB_SERVER = "localhost";
    private static final String DB_NAME = "db_projeto4";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "";

    private static final Logger LOGGER = Logger.getLogger(MysqlConnection.class.getName());
    private static final HikariDataSource DATA_SOURCE;

    static {
        try (InputStream stream = MysqlConnection.class.getClassLoader().getResourceAsStream("cred.json")) {
            Class.forName("com.mysql.cj.jdbc.Driver");

            HikariConfig config = new HikariConfig();
            config.setJdbcUrl(String.format("jdbc:mysql://%s/%s", DB_SERVER, DB_NAME));
            config.setUsername(DB_USER);
            config.setPassword(DB_PASS);
            config.setMaximumPoolSize(200);
            config.setMinimumIdle(5);
            config.setIdleTimeout(30000);
            config.setMaxLifetime(1800000);

            DATA_SOURCE = new HikariDataSource(config);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error loading MySQL JDBC driver", e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static Connection getConexao() throws SQLException {
        return DATA_SOURCE.getConnection();
    }
}
