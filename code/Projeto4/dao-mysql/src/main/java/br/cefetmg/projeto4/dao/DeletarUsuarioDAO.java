/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.projeto4.dao;

import br.cefetmg.projeto4.dao.mysql.MySqlConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author lucas
 */
public class DeletarUsuarioDAO {
        MySqlConnection bancoDeDados;
    Connection conexao;

    public DeletarUsuarioDAO() throws SQLException {
        bancoDeDados = new MySqlConnection();
        conexao = bancoDeDados.getConexao(); // Abre a conexão com o banco de dados
    }
    public boolean deletarUsuario(String email, String senha) throws SQLException
    {
        String sql = "DELETE FROM usuarios WHERE email = ? AND senha = ?";
        PreparedStatement stmt1 = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt1.setString(1, email);
        stmt1.setString(2, senha);
        int rowsAffected = stmt1.executeUpdate();
        if (rowsAffected <= 0)  {
            throw new SQLException("Insertion into usuarios failed");
        }
        return true;
    }


}
