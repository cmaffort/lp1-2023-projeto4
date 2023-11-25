package br.cefetmg.projeto4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.cefetmg.projeto4.dto.ItemEstoqueDTO;
import br.cefetmg.projeto4.idao.IEstoqueDAO;

public class EstoqueDAO implements IEstoqueDAO {
    private final Connection conexao;

    public EstoqueDAO() throws SQLException {
        conexao = MysqlConnection.getConexao(); // Abre a conexão com o banco de dados
    }

    @Override
    public boolean inserir(ItemEstoqueDTO item) throws SQLException, ClassNotFoundException {
        try {
            PreparedStatement stmt = conexao.prepareStatement("INSERT INTO `estoque`(`tipo`, `quantidade`, `status`) VALUES (?, ?, ?)");

            stmt.setString(1, item.getTipo());
            stmt.setInt(2, item.getQuantidade());
            stmt.setString(3, item.getStatus());

            int rowsAffected = stmt.executeUpdate();

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
    public boolean alterar(ItemEstoqueDTO item) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Unimplemented method 'alterar'");
    }

    @Override
    public boolean remover(ItemEstoqueDTO item) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Unimplemented method 'remover'");
    }

    @Override
    public List<ItemEstoqueDTO> listar() throws SQLException, ClassNotFoundException {
        try {
            List<ItemEstoqueDTO> itens = new ArrayList<>();
            String sql = "SELECT * FROM `estoque`";
            Statement stmt = conexao.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);

            while (resultSet.next()) {
                String tipo = resultSet.getString("tipo");
                int quantidade = resultSet.getInt("quantidade");
                String status = resultSet.getString("status");

                ItemEstoqueDTO item = new ItemEstoqueDTO(tipo, quantidade, status);

                itens.add(item);
            }

            resultSet.close();
            stmt.close();

            return itens;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public void close() throws SQLException {
        conexao.close();
    }
}