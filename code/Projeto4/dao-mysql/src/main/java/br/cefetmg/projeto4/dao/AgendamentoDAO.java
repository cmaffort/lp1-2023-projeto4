/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.projeto4.dao;

import br.cefetmg.projeto4.dao.mysql.MySqlConnection;
import br.cefetmg.projeto4.idao.IAgendamentoDAO;
import br.cefetmg.projeto4.dto.Agendamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author lucas
 */
public class AgendamentoDAO implements IAgendamentoDAO {
        MySqlConnection bancoDeDados;
    Connection conexao;

    public AgendamentoDAO() throws SQLException {
        bancoDeDados = new MySqlConnection();
        conexao = bancoDeDados.getConexao(); // Abre a conexão com o banco de dados
    }

    @Override
    public boolean inserir(Agendamento agendamento) throws SQLException, ClassNotFoundException {
       try {
        PreparedStatement statement = conexao.prepareStatement("INSERT INTO agendamento (computador, data, nome) VALUES (?, ?, ?)");       
            statement.setString(1, agendamento.getComputador());
            statement.setString(2, agendamento.getData());
            statement.setString(3, agendamento.getNome());
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
    public boolean alterar(Agendamento agendamento) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean remover(Agendamento agendamento) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Agendamento> listar() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
