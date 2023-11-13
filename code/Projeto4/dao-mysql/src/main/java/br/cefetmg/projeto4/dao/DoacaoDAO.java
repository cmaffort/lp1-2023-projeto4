package br.cefetmg.projeto4.dao;

import br.cefetmg.projeto4.dao.mysql.MySqlConnection;
import br.cefetmg.projeto4.dto.ComputadorDTO;
import br.cefetmg.projeto4.dto.DoacaoDTO;
import java.sql.Connection;
import java.sql.SQLException;
import br.cefetmg.projeto4.idao.IDoacaoDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class DoacaoDAO implements IDoacaoDAO {
    MySqlConnection bancoDeDados;
    Connection conexao;

    public DoacaoDAO() throws SQLException {
        bancoDeDados = new MySqlConnection();
        conexao = bancoDeDados.getConexao(); // Abre a conexão com o banco de dados
    }

    @Override
    public boolean inserir(DoacaoDTO doacao) throws SQLException, ClassNotFoundException {
        try {

        PreparedStatement statement = conexao.prepareStatement("INSERT INTO doacao (quantidade, computador) VALUES (?, ?)");
        statement.setInt(1, doacao.getQuantidade());
        statement.setString(2, doacao.getMarcaComputador());
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
        PreparedStatement statement = conexao.prepareStatement("SELECT * FROM doacao");
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            String nome = resultSet.getString("computador");
            int quantidade = resultSet.getInt("quantidade");
            String doador = resultSet.getString("doador");
            String data = resultSet.getString("data");
            int ram = resultSet.getInt("quantidade_ram");
            ComputadorDTO computador = new ComputadorDTO(doador,data,"", nome,"", ram);
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
    

}
