/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.projeto4.dao;
import br.cefetmg.projeto4.dto.ComprasDTO;
import br.cefetmg.projeto4.dto.PecasDTO;

import br.cefetmg.projeto4.idao.IComprasDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lucas
 */
public class ComprasDAO implements IComprasDAO {
    private final Connection conexao;

    public ComprasDAO() throws SQLException {
        conexao = MysqlConnection.getConexao();
    }
    
    @Override
    public boolean inserir(ComprasDTO compra) throws SQLException, ClassNotFoundException {
        
        try {

        PreparedStatement statement = conexao.prepareStatement("INSERT INTO compras (id_peca, valor_unitario) VALUES (?, ?)");
        statement.setInt(1, compra.getIdPeca());
        statement.setInt(2, compra.getValorUnitario());
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
    public boolean alterar(ComprasDTO compra) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean remover(ComprasDTO compra) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ComprasDTO> listar() throws SQLException, ClassNotFoundException {
        List<ComprasDTO> compras = new ArrayList<>();
        try {
            PreparedStatement statement = conexao.prepareStatement("SELECT * FROM compras");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int idPeca = resultSet.getInt("id_peca");
                int valorUnitario = resultSet.getInt("valor_unitario");
                ComprasDTO compra = new ComprasDTO(id, idPeca, valorUnitario);
                compras.add(compra);
            }

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return compras;
    }
    public int valorTotal()
    {
        int total = 0;
        try {
            PreparedStatement statement = conexao.prepareStatement("SELECT compras.*, pecas.quantidade FROM compras JOIN pecas ON compras.id_compra = pecas.id");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int valorUnitario = resultSet.getInt("valor_unitario");
                int quantidade = resultSet.getInt("quantidade");
                total += valorUnitario * quantidade;
            }

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return total; 
    }

    @Override
    public void close() throws SQLException {
        conexao.close();
    }
}