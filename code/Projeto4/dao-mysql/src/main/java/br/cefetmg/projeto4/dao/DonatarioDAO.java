package br.cefetmg.projeto4.dao;
import br.cefetmg.projeto4.dao.mysql.MySqlConnection;
import br.cefetmg.projeto4.dto.Computador;
import br.cefetmg.projeto4.idao.IDonatarioDAO;
import java.sql.SQLException;
import br.cefetmg.projeto4.dto.Donatario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lucas
 */
public class DonatarioDAO implements IDonatarioDAO {
    MySqlConnection bancoDeDados;
    Connection conexao;

    public DonatarioDAO() throws SQLException {
        bancoDeDados = new MySqlConnection();
        conexao = bancoDeDados.getConexao(); // Abre a conexão com o banco de dados
    }

    @Override
    public boolean inserir(Donatario donatario) throws SQLException, ClassNotFoundException {
        try {
            PreparedStatement statement = conexao.prepareStatement("INSERT INTO donatarios (nome, CPF, email, senha, escola, posicao, codigo, serie) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

            statement.setString(1, donatario.getNome());
            statement.setString(2, donatario.getCPF());
            statement.setString(3, donatario.getEmail());
            statement.setString(4, donatario.getSenha());

            statement.setString(5, donatario.getEscola());
            statement.setInt(6, donatario.getPosicao());
            statement.setString(7, "1");

            statement.setString(8, donatario.getSerie());

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
    public boolean alterar(Donatario donatario) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean remover(Donatario donatario) throws SQLException, ClassNotFoundException {
        try {
            PreparedStatement statement = conexao.prepareStatement("DELETE FROM donatarios WHERE CPF = ?");
            statement.setString(1, donatario.getCPF());
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Remoção realizada com sucesso");
                return true;
            } else {
                System.out.println("Erro na remoção");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Donatario> listar() throws SQLException, ClassNotFoundException {
    List<Donatario> donatarios = new ArrayList<>();

    try {
        PreparedStatement statement = conexao.prepareStatement("SELECT * FROM fila_espera");
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            String nome = resultSet.getString("nome_aluno");
             String CPF = "";
            String email = "";
            String senha = "";
            String escola = ""; 
            int posicao = resultSet.getInt("id");
             String serie = "";

            Donatario donatario = new Donatario(nome, CPF, email, senha, escola, posicao, serie, "rua");
            donatarios.add(donatario);
        }

        resultSet.close();
        statement.close();
    } catch (SQLException e) {
        System.out.println("Erro: " + e.getMessage());
    }

    return donatarios;

    }
     
}
