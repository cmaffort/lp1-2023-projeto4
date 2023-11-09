/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.projeto4.dao;
import br.cefetmg.projeto4.dao.mysql.MySqlConnection;
import br.cefetmg.projeto4.idao.IDoadorJuridicaDAO;
import br.cefetmg.projeto4.dto.DoadorJuridica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DoadorJuridicoDAO implements IDoadorJuridicaDAO {
    MySqlConnection bancoDeDados;
    Connection conexao;

    public DoadorJuridicoDAO() throws SQLException {
        bancoDeDados = new MySqlConnection();
        conexao = bancoDeDados.getConexao(); // Abre a conexão com o banco de dados
    }

    @Override
    public boolean inserir(DoadorJuridica doadorJuridica) throws SQLException, ClassNotFoundException {
        try {    
        PreparedStatement statement = conexao.prepareStatement("INSERT INTO doadorJuridica (nome, endereco, CNPJ, email, senha, computadores_doados) VALUES (?, ?, ?, ?, ?, ?);");
            statement.setString(1, doadorJuridica.getNome());
            statement.setString(2, doadorJuridica.getEndereco());
            statement.setString(3, doadorJuridica.getCNPJ());
            statement.setString(4, doadorJuridica.getEmail());
            statement.setString(5, doadorJuridica.getSenha());
            statement.setInt(6, 0);
                        int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Inserção realizada com sucesso");
                return true;
            } else {
                System.out.println("Erro na inserção");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return false;
        }


            

    }

    @Override
    public boolean alterar(DoadorJuridica doadorJuridica) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean remover(DoadorJuridica doadorJuridica) throws SQLException, ClassNotFoundException {
        try {
            PreparedStatement statement = conexao.prepareStatement("DELETE FROM donatarios WHERE CNPJ = ?");
            statement.setString(1, doadorJuridica.getCNPJ());
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Remoção realizada com sucesso");
                return true;
            } else {
                System.out.println("Erro na remoção");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<DoadorJuridica> listar() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
