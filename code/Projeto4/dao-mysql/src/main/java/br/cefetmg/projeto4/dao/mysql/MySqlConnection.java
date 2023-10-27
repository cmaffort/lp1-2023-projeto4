package br.cefetmg.projeto4.dao.mysql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySqlConnection {
   Connection conexao;
    public  Connection getConexao() throws SQLException {
                try {
            Class.forName("com.mysql.jdbc.Driver");
             conexao = DriverManager.getConnection("jdbc:mysql://localhost/db_projeto4", "root", "");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch(SQLException ex)
        {
            System.out.println("SQLExemption:" + ex.getMessage());
            throw new SQLException();
        }
       return conexao;
    }
}
