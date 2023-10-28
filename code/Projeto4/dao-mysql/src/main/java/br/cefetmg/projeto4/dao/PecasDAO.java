package br.cefetmg.projeto4.dao;
import br.cefetmg.projeto4.dao.mysql.MySqlConnection;
import br.cefetmg.projeto4.idao.IPecasDAO;
import java.sql.SQLException;
import br.cefetmg.projeto4.dto.Pecas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PecasDAO implements IPecasDAO {
        MySqlConnection bancoDeDados;
    Connection conexao;

    public PecasDAO() throws SQLException {
        bancoDeDados = new MySqlConnection();
        conexao = bancoDeDados.getConexao(); // Abre a conexão com o banco de dados
    }

    @Override
    public boolean inserir(Pecas pecas) throws SQLException, ClassNotFoundException {
        try {
            PreparedStatement statement = conexao.prepareStatement("INSERT INTO estagiarios (quantidade, codigo, modelo, descricao, dataChegada) VALUES (?, ?, ?, ?, ?)");
            statement.setInt(1, pecas.getQuantidade());
            statement.setString(2, pecas.getCodigo());
            statement.setString(3, pecas.getModelo());
            statement.setString(4, pecas.getDescricao());
            statement.setString(5, pecas.getDataChegada());
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
    public boolean remover(Pecas pecas) throws SQLException, ClassNotFoundException{
        try {

        PreparedStatement statement = conexao.prepareStatement("DELETE FROM pecas WHERE codigo = ?");
        statement.setString(1, pecas.getCodigo());
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
    public boolean alterar(Pecas pecas) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public List<Pecas> listar() throws SQLException, ClassNotFoundException {
        List<Pecas> computadores = new ArrayList<>();

      /*  try {
            PreparedStatement statement = conexao.prepareStatement("SELECT * FROM computadores");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String codigo = resultSet.getString("codigo");
                String doador = resultSet.getString("doador");
                String dataDeChegada = resultSet.getString("dataDeChegada");
                String donatario = resultSet.getString("donatario");
                String marca = resultSet.getString("marca");
                String modeloProcessador = resultSet.getString("modeloProcessador");
                int quantidadeDeRAM = resultSet.getInt("quantidadeDeRAM");

                Computador computador = new Computador(codigo, doador, dataDeChegada, donatario, marca, modeloProcessador, quantidadeDeRAM);
                computadores.add(computador);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }*/

        return computadores;    }

}

