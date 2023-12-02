/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.projeto4.dao;
import br.cefetmg.projeto4.dto.CompraDTO;
import br.cefetmg.projeto4.dto.PecasDTO;

import br.cefetmg.projeto4.idao.ICompraDAO;

import java.math.BigDecimal;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/**
 *
 * @author lucas
 */
public class CompraDAO extends PecasDAO  implements ICompraDAO {
    public CompraDAO() throws SQLException {}

    private boolean inserir(CompraDTO compra, boolean novaPeca) throws SQLException, ClassNotFoundException {
        try {
            int id;

            if (novaPeca) {
                if (!inserir(compra))
                    throw new SQLException("Insertion into compras failed");

                String sql = "SELECT LAST_INSERT_ID() AS id";
                Statement stmt0 = conexao.createStatement();

                ResultSet resultSet = stmt0.executeQuery(sql);

                if (resultSet.next())
                    id = resultSet.getInt("id");
                else
                    throw new SQLException("Failed to select id");
            } 
            else
                id = compra.getId();

            String sql = "INSERT IGNORE INTO compras(id_peca, valor_unitario) VALUES (?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setInt(1, id);
            stmt.setBigDecimal(2, new BigDecimal(compra.getValorUnitario()));

            int rowsAffected = stmt.executeUpdate();
    
            if (rowsAffected <= 0) 
                throw new SQLException("Insertion into compras failed");

            stmt.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean registrarCompra(int id, int quantidade, double valorUnitario) throws SQLException, ClassNotFoundException, NoSuchElementException {
        try {
            conexao.setAutoCommit(false);

            PecasDTO peca = selecionarFaltoso(id);

            int novaQtd = peca.getQuantidade() - quantidade;

            if (novaQtd > 0) {
                String sql = "UPDATE pecas SET quantidade = ? WHERE id = ?";
                PreparedStatement stmt = conexao.prepareStatement(sql);

                stmt.setInt(1, novaQtd);
                stmt.setInt(2, id);

                int rowsAffected = stmt.executeUpdate();
    
                if (rowsAffected <= 0) 
                    throw new SQLException("Update pecas failed");

                CompraDTO compra = new CompraDTO(peca.getNome(), peca.getMarca(), quantidade, valorUnitario);

                if (!inserir(compra, true))
                    throw new SQLException("Insertion into compras failed");
            } else {
                alterarStatus(id, "COMPRADO");

                CompraDTO compra = new CompraDTO(id, peca.getNome(), peca.getMarca(), quantidade, valorUnitario);

                if (!inserir(compra, false))
                    throw new SQLException("Insertion into compras failed");
            }

            System.out.println("Update realizado com sucesso");
            conexao.commit();
            return true;
        } catch (SQLException e) {
            conexao.rollback();
            System.out.println("Erro: " + e.getMessage());

            return false;
        }
    }

    @Override
    public double getTotalCompras() throws SQLException, ClassNotFoundException {
        try {
            double total = 0;

            List<CompraDTO> compras = listar();

            for (CompraDTO compra : compras)
                total += compra.getValorTotal();

            return total;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return 0;
        }
    }

    @Override
    public List<CompraDTO> listar() throws SQLException, ClassNotFoundException {
        try {
            List<CompraDTO> compras = new ArrayList<>();

            PreparedStatement statement = conexao.prepareStatement("SELECT * FROM compras JOIN pecas ON compras.id_peca = pecas.id");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String marca = resultSet.getString("marca");
                int quantidade = resultSet.getInt("quantidade");
                BigDecimal valorUnitario = resultSet.getBigDecimal("valor_unitario");

                CompraDTO compra = new CompraDTO(id, nome, marca, quantidade, valorUnitario.doubleValue());
                compras.add(compra);
            }

            return compras;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return Collections.emptyList();
        }
    }
}