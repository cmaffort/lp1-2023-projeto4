package br.cefetmg.projeto4.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

class MysqlConnection {
    private static final String INSTANCE_CONNECTION_NAME = "projeto-4-406800:us-central1:projeto4server";
    private static final String DB_NAME = "db_projeto4";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "";

    private static final Logger LOGGER = Logger.getLogger(MysqlConnection.class.getName());
    private static final HikariDataSource DATA_SOURCE;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            HikariConfig config = new HikariConfig();
            config.setJdbcUrl(String.format("jdbc:mysql:///%s", DB_NAME));
            config.setUsername(DB_USER);
            config.setPassword(DB_PASS);
            config.addDataSourceProperty("socketFactory", "com.google.cloud.sql.mysql.SocketFactory");
            config.addDataSourceProperty("cloudSqlInstance", INSTANCE_CONNECTION_NAME);
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