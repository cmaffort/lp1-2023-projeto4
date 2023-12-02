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

        PreparedStatement statement = conexao.prepareStatement("INSERT INTO doacoes (id_doador, quantidade, computador) VALUES (?, ?, ?)");
        statement.setInt(1, numero);
        statement.setInt(2, doacao.getQuantidade());
        statement.setString(3, doacao.getMarcaComputador());
        
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
public List<DoacaoDTO> listarComputadoresDoados() throws SQLException, ClassNotFoundException {
    List<DoacaoDTO> computadoresDoados = new ArrayList<>();

    try {
        // Step 1: Fetch data from the first table
        PreparedStatement statement = conexao.prepareStatement("SELECT * FROM donatarios");
        ResultSet resultSet = statement.executeQuery();

        List<Integer> idDoacoes = new ArrayList<>();
        List<Integer> idDoadores = new ArrayList<>();

        while (resultSet.next()) {
            Integer idDoacao = resultSet.getInt("id_doacao");
            idDoacoes.add(idDoacao);
        }

        // Step 2: Fetch additional information from the second table (usuarios)
        for (Integer idDoador : idDoadores) {
            statement = conexao.prepareStatement("SELECT * FROM usuarios WHERE id = ?");
            statement.setInt(1, idDoador);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String doador = resultSet.getString("nome");

                // Step 3: Fetch additional information from the third table (doacoes)
                statement = conexao.prepareStatement("SELECT * FROM doacoes WHERE id = ?");
                statement.setInt(1, idDoacoes.remove(0));
                resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    String nome = resultSet.getString("computador");
                    int quantidade = resultSet.getInt("quantidade");
                    ComputadorDTO computadorDTO = new ComputadorDTO(doador, "", "", nome, "", 8);
                    DoacaoDTO doacao = new DoacaoDTO(quantidade, computadorDTO);
                    computadoresDoados.add(doacao);
                }
            }
        }

    } catch (SQLException e) {
        System.out.println("Erro: " + e.getMessage());
    }

    return computadoresDoados;
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
            
           // int ram = resultSet.getInt("quantidade_ram");
            ComputadorDTO computador = new ComputadorDTO("Doador","","", nome,"", 4);
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