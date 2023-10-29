package br.cefetmg.projeto4.dao;
import br.cefetmg.projeto4.dao.mysql.MySqlConnection;
import br.cefetmg.projeto4.dto.DoadorFisica;
import br.cefetmg.projeto4.idao.IDoadorFisicaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
public class DoadorFisicaDAO implements IDoadorFisicaDAO {
    MySqlConnection bancoDeDados;
    Connection conexao;

    public DoadorFisicaDAO() throws SQLException {
        bancoDeDados = new MySqlConnection();
        conexao = bancoDeDados.getConexao(); // Abre a conexão com o banco de dados
    }

    @Override
    public boolean inserir(DoadorFisica doadorFisica) throws SQLException, ClassNotFoundException {
        try {
            PreparedStatement statement = conexao.prepareStatement("INSERT INTO doadorFisica (nome, cpf, email, senha, computadores_doados) VALUES (?, ?, ?, ?, ?);");
            statement.setString(1, doadorFisica.getNome());
            statement.setString(2, doadorFisica.getCPF());
            statement.setString(3, doadorFisica.getEmail());
            statement.setString(4, doadorFisica.getSenha());
            statement.setInt(5, doadorFisica.getComputadoresDoados());

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
    public boolean alterar(DoadorFisica doadorFisica) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean remover(DoadorFisica doadorFisica) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<DoadorFisica> listar() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
