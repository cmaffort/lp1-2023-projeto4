package br.cefetmg.projeto4.dao;
import br.cefetmg.projeto4.idao.IPecasDAO;
import java.sql.SQLException;
import java.sql.Statement;

import br.cefetmg.projeto4.dto.PecasDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class PecasDAO implements IPecasDAO {
    protected final Connection conexao;

    public PecasDAO() throws SQLException {
        conexao = MysqlConnection.getConexao();
    }
    
    @Override
    public boolean inserir(PecasDTO peca) throws SQLException, ClassNotFoundException {
        try {
            String sql = "INSERT INTO pecas(nome, marca, status, quantidade) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, peca.getNome());
            stmt.setString(2, peca.getMarca());
            stmt.setString(3, peca.getStatus());
            stmt.setInt(4, peca.getQuantidade());

            int rowsAffected = stmt.executeUpdate();
    
            if (rowsAffected <= 0) 
                throw new SQLException("Insertion into pecas failed");

            stmt.close();
    
            System.out.println("Inserção realizada com sucesso");
            return true;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return false; 
        }
    }

    @Override
    public boolean remover(PecasDTO peca) throws SQLException, ClassNotFoundException {
        try {
            String sql = "DELETE FROM pecas WHERE id = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
    
            stmt.setInt(1, peca.getId());
    
            int rowsAffected = stmt.executeUpdate();
    
            if (rowsAffected <= 0) 
                throw new SQLException("Deletion from pecas failed");

            stmt.close();
    
            System.out.println("Deleção realizada com sucesso");
            return true;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return false; 
        }
    }
    
    protected boolean alterarStatus(int id, String status) throws SQLException, ClassNotFoundException, NoSuchElementException {
            try {
                String sql = "UPDATE pecas SET status = ? WHERE id = ?";
                PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, status);

            stmt.setInt(2, id);
            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas == 0)
                throw new NoSuchElementException("Não há peça faltosa com esse código");
            else 
                return true;

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());

            throw new NoSuchElementException("Failed to select");
        }

    }

    @Override
    public PecasDTO selecionarFaltoso(int id) throws SQLException, ClassNotFoundException, NoSuchElementException {
        try {
            String sql = "SELECT * FROM pecas WHERE id = ? AND status = 'EM_FALTA'";
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setInt(1, id);

            ResultSet resultSet = stmt.executeQuery();

            if (!resultSet.next())
                throw new NoSuchElementException("Não há peça faltosa com esse código");

            String nome = resultSet.getString("nome");
            String marca = resultSet.getString("marca");
            int quantidade = resultSet.getInt("quantidade");

            PecasDTO peca = new PecasDTO(id, nome, marca, quantidade);

            System.out.println("Seleção realizada com sucesso");
            return peca;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());

            throw new NoSuchElementException("Failed to select");
        }
    }

    @Override
    public List<PecasDTO> listarFaltosos() throws SQLException, ClassNotFoundException {
        try {
            List<PecasDTO> pecas = new ArrayList<>();

            String sql = "SELECT * FROM pecas WHERE status = 'EM_FALTA'";
            Statement stmt = conexao.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String marca = resultSet.getString("marca");
                int quantidade = resultSet.getInt("quantidade");

                PecasDTO peca = new PecasDTO(id, nome, marca, quantidade);

                pecas.add(peca);
            }

            resultSet.close();
            stmt.close();

            return pecas;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return Collections.emptyList();
        }
    }
        public List<PecasDTO> listarCompradas() throws SQLException, ClassNotFoundException {
        try {
            List<PecasDTO> pecas = new ArrayList<>();

            String sql = "SELECT * FROM pecas WHERE status = 'COMPRADO'";
            Statement stmt = conexao.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String marca = resultSet.getString("marca");
                int quantidade = resultSet.getInt("quantidade");

                PecasDTO peca = new PecasDTO(id, nome, marca, quantidade);

                pecas.add(peca);
            }

            resultSet.close();
            stmt.close();

            return pecas;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    public List<PecasDTO> listarDoados() throws SQLException, ClassNotFoundException {
        try {
            List<PecasDTO> pecas = new ArrayList<>();

            String sql = "SELECT * FROM pecas WHERE status = 'COMPRADO'";
            Statement stmt = conexao.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String marca = resultSet.getString("marca");
                int quantidade = resultSet.getInt("quantidade");

                PecasDTO peca = new PecasDTO(id, nome, marca, quantidade);

                pecas.add(peca);
            }

            resultSet.close();
            stmt.close();

            return pecas;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public final void close() throws SQLException {
        conexao.close();
    }
}