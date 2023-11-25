package br.cefetmg.projeto4.dao;

import br.cefetmg.projeto4.dto.ComputadorDTO;
import br.cefetmg.projeto4.dto.DoacaoDTO;
import java.sql.Connection;
import java.sql.SQLException;
import br.cefetmg.projeto4.idao.IDoacaoDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class DoacaoDAO implements IDoacaoDAO {
    private final Connection conexao;

    public DoacaoDAO() throws SQLException {
        conexao = MysqlConnection.getConexao();
    }

    @Override
    public boolean inserir(DoacaoDTO doacao) throws SQLException, ClassNotFoundException {
        try {
        Random rand = new Random();
        int numero = rand.nextInt(1000) + 1;

        PreparedStatement statement = conexao.prepareStatement("INSERT INTO doacoes (id_doador, quantidade, computador, data) VALUES (?, ?, ?, ?)");
        statement.setInt(1, numero);
        statement.setInt(2, doacao.getQuantidade());
        statement.setString(3, doacao.getMarcaComputador());
        statement.setString(4, doacao.getDataDeChegada());
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
    public boolean alterar(DoacaoDTO doacao) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean remover(DoacaoDTO doacao) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<DoacaoDTO> listar() throws SQLException, ClassNotFoundException {
    List<DoacaoDTO> doacoes = new ArrayList<>();

    try {
        PreparedStatement statement = conexao.prepareStatement("SELECT * FROM doacoes");
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            String nome = resultSet.getString("computador");
            int quantidade = resultSet.getInt("quantidade");
            String id_doador = resultSet.getString("id_doador");
            
            String data = resultSet.getString("data");
           // int ram = resultSet.getInt("quantidade_ram");
            ComputadorDTO computador = new ComputadorDTO("Doador",data,"", nome,"", 4);
            DoacaoDTO doacao = new DoacaoDTO(quantidade, computador);
            doacoes.add(doacao);
        }

        resultSet.close();
        statement.close();
    } catch (SQLException e) {
        System.out.println("Erro: " + e.getMessage());
    }

    return doacoes;
    }
    
    @Override
    public void close() throws SQLException {
        conexao.close();
    }
}