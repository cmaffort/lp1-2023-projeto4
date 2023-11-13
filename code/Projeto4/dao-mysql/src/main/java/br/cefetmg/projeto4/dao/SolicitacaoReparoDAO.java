package br.cefetmg.projeto4.dao;
import br.cefetmg.projeto4.dao.mysql.MySqlConnection;
import br.cefetmg.projeto4.dto.SolicitacaoReparoDTO;
import java.sql.Connection;
import java.sql.SQLException;
import br.cefetmg.projeto4.idao.ISolicitacaoReparoDAO;
import java.sql.PreparedStatement;
import java.util.List;

public class SolicitacaoReparoDAO implements ISolicitacaoReparoDAO {
    
    MySqlConnection bancoDeDados;
    Connection conexao;
    
    public SolicitacaoReparoDAO() throws SQLException {
        bancoDeDados = new MySqlConnection();
        conexao = bancoDeDados.getConexao(); // Abre a conexão com o banco de dados
    }
    
    @Override
    public boolean inserir(SolicitacaoReparoDTO reparo) throws SQLException, ClassNotFoundException {
        try {

        PreparedStatement statement = conexao.prepareStatement("INSERT INTO reparo (dataDeDoacao, especificacoes, donatario, marca, modeloProcessador, quantidadeDeRAM) VALUES (?, ?, ?, ?, ?, ?)");
        statement.setString(1, reparo.getDataDeDoacao());
        statement.setString(2, reparo.getEspecificacoes());
        statement.setString(2, reparo.getComputador().getDonatario());
        statement.setString(2, reparo.getComputador().getMarca());
        statement.setString(2, reparo.getComputador().getModeloProcessador());
        statement.setInt(2, reparo.getComputador().getQuantidadeDeRAM());
        
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
    public boolean alterar(SolicitacaoReparoDTO reparo) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean remover(SolicitacaoReparoDTO reparo) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<SolicitacaoReparoDTO> listar() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    

    
}
