/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.projeto4.dao;
import br.cefetmg.projeto4.dao.mysql.MySqlConnection;
import br.cefetmg.projeto4.dto.Agendamento;
import br.cefetmg.projeto4.dto.Doacao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author lucas
 */
public class GestaoDoacaoDAO {
            MySqlConnection bancoDeDados;

    Connection conexao;

    public GestaoDoacaoDAO() throws SQLException {
        bancoDeDados = new MySqlConnection();
        conexao = bancoDeDados.getConexao(); // Abre a conexão com o banco de dados
    }


        public ArrayList<Doacao> listar() throws SQLException, ClassNotFoundException {
                        try {
            // Create a connection to the database

            // Create a statement to execute the SQL query
            Statement statement = conexao.createStatement();

            // Execute the SQL query and store the result set
            ResultSet resultSet = statement.executeQuery("SELECT * FROM doacao ORDER BY quantidade");
            ArrayList<Doacao> lista = new ArrayList<Doacao>();            // Iterate through the result set and display the data
            while (resultSet.next()) {
                // Replace "column_name" with the actual column names you want to retrieve
                String column1 = resultSet.getString("quantidade");
                int column2 = resultSet.getInt("computador");
                Doacao doacao = new Doacao(column1, column2);
                lista.add(doacao);
                
            }
            return lista;
           } catch (SQLException e) {
               return null;
        }
            
    }
}
