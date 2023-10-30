package br.cefetmg.projeto4.dao;
import br.cefetmg.projeto4.dao.mysql.MySqlConnection;
import br.cefetmg.projeto4.idao.IComputadorDAO;
import java.sql.SQLException;
import br.cefetmg.projeto4.dto.Computador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ComputadorDAO implements IComputadorDAO {
    MySqlConnection bancoDeDados;
    Connection conexao;

    public ComputadorDAO() throws SQLException {
        bancoDeDados = new MySqlConnection();
        conexao = bancoDeDados.getConexao(); // Abre a conexão com o banco de dados
    }

    @Override
    public boolean inserir(Computador computador) throws SQLException, ClassNotFoundException {
        try {
            PreparedStatement statement = conexao.prepareStatement("INSERT INTO computadores (codigo, doador, dataDeChegada, donatario, marca, modeloProcessador, quantidadeDeRAM) VALUES (?, ?, ?, ?, ?, ?, ?)");       
            String doador = computador.getDoador();
            String dataDeChegada = computador.getDataDeChegada();
            String donatario = computador.getDonatario();
            String marca = computador.getMarca();
            String modeloProcessador = computador.getModeloProcessador();
            int quantidadeDeRAM = computador.getQuantidadeDeRAM();

            statement.setString(1, doador);
            statement.setString(2, dataDeChegada);
            statement.setString(3, donatario);
            statement.setString(4, marca);
            statement.setString(5, modeloProcessador);
            statement.setString(6, String.valueOf(quantidadeDeRAM));

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
    public boolean alterar(Computador computador) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean remover(Computador computador) throws SQLException, ClassNotFoundException {
    try {
            PreparedStatement statement = conexao.prepareStatement("DELETE FROM computadores WHERE codigo = ?");

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
    public List<Computador> listar() throws SQLException, ClassNotFoundException {
        List<Computador> computadores = new ArrayList<>();

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
