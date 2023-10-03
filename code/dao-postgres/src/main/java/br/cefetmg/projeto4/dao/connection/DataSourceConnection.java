package br.cefetmg.projeto4.dao.connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DataSourceConnection implements ConnectionFactory {

    private final static String dsName = "jdbc/sislocds";

    private DataSource ds;
    
    public DataSourceConnection() {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("");
            this.ds = (DataSource) envContext.lookup(dsName);
        } catch (NamingException ex) {
            Logger.getLogger(DataSourceConnection.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        return ds.getConnection();
    }   
}
