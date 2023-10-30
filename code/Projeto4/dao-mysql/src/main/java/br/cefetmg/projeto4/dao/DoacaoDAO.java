package br.cefetmg.projeto4.dao;

import br.cefetmg.projeto4.dao.mysql.MySqlConnection;
import br.cefetmg.projeto4.dto.Doacao;
import java.sql.Connection;
import java.sql.SQLException;
import br.cefetmg.projeto4.idao.IDoacaoDAO;
import java.sql.PreparedStatement;
import java.util.List;
public class DoacaoDAO implements IDoacaoDAO {
    MySqlConnection bancoDeDados;
    Connection conexao;

    public DoacaoDAO() throws SQLException {
        bancoDeDados = new MySqlConnection();
        conexao = bancoDeDados.getConexao(); // Abre a conexão com o banco de dados
    }

    @Override
    public boolean inserir(Doacao doacao) throws SQLException, ClassNotFoundException {
        try {

        PreparedStatement statement = conexao.prepareStatement("INSERT INTO doacao (quantidade, computador) VALUES (?, ?)");
        statement.setInt(1, doacao.getQuantidade());
        statement.setString(2, doacao.getComputador().getMarca());
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
    public boolean alterar(Doacao doacao) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean remover(Doacao doacao) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Doacao> listar() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    

}
