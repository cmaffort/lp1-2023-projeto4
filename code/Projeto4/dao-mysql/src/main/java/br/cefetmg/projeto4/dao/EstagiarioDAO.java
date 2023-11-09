package br.cefetmg.projeto4.dao;
import br.cefetmg.projeto4.dao.mysql.MySqlConnection;
import br.cefetmg.projeto4.idao.IEstagiarioDAO;
import java.sql.SQLException;
import br.cefetmg.projeto4.dto.Estagiario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EstagiarioDAO implements IEstagiarioDAO {
        MySqlConnection bancoDeDados;
    Connection conexao;

    public EstagiarioDAO() throws SQLException {
        bancoDeDados = new MySqlConnection();
        conexao = bancoDeDados.getConexao(); // Abre a conexão com o banco de dados
    }

    @Override
    public boolean inserir(Estagiario estagiario) throws SQLException, ClassNotFoundException {
        try {
            PreparedStatement statement = conexao.prepareStatement("INSERT INTO estagiarios (nome, CPF, email, dataDeEntrada, dataDeSaida, senha) VALUES (?, ?, ?, ?, ?, ?)");
            statement.setString(1, estagiario.getNome());
            statement.setString(2, estagiario.getCPF());
            statement.setString(3, estagiario.getEmail() );
            statement.setString(4, estagiario.getDataEntrada());
            statement.setString(5, estagiario.getDataSaida());
            statement.setString(6, estagiario.getSenha());
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
    public boolean remover(Estagiario estagiario) throws SQLException, ClassNotFoundException{
        try {

        PreparedStatement statement = conexao.prepareStatement("DELETE FROM estagiarios WHERE CPF = ?");
        statement.setString(1, estagiario.getCPF());
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
    public boolean alterar(Estagiario estagiario) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public List<Estagiario> listar() throws SQLException, ClassNotFoundException {
           List<Estagiario> estagiarios = new ArrayList<>();

    try {
        PreparedStatement statement = conexao.prepareStatement("SELECT * FROM estagiarios");
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            String nome = resultSet.getString("nome");
            String CPF = resultSet.getString("CPF");
            String email = resultSet.getString("email");
            String senha = resultSet.getString("senha");
            String dataEntrada = resultSet.getString("dataEntrada");
            String dataSaida = resultSet.getString("dataSaida");

            String endereco = resultSet.getString("endereco");
        Estagiario estagiario = new Estagiario(nome, CPF, email, dataEntrada, dataSaida, senha);
            estagiarios.add(estagiario);
        }

        resultSet.close();
        statement.close();
    } catch (SQLException e) {
        System.out.println("Erro: " + e.getMessage());
    }

    return estagiarios;

    }

}
