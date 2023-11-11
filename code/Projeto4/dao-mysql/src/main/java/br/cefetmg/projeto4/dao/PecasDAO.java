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
    public boolean inserirPecaFaltante(Pecas pecas) throws SQLException, ClassNotFoundException {
        try {
            PreparedStatement statement = conexao.prepareStatement("INSERT INTO pecas_faltantes (nome, marca, quantidade_em_falta) VALUES (?, ?, ?);");
            statement.setString(1, pecas.getNome());
            statement.setString(2, pecas.getMarca());
            statement.setInt(3, pecas.getQuantidade());

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
    public boolean inserir(Pecas pecas) throws SQLException, ClassNotFoundException {
        try {
            PreparedStatement statement = conexao.prepareStatement("INSERT INTO pecas (nome, marca, quantidade_em_falta) VALUES (?, ?, ?);");
            statement.setString(1, pecas.getNome());
            statement.setString(2, pecas.getMarca());
            statement.setInt(3, pecas.getQuantidade());

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

        PreparedStatement statement = conexao.prepareStatement("DELETE FROM pecas WHERE nome = ?");
        statement.setString(1, pecas.getNome());
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
        List<Pecas> pecas = new ArrayList<>();

       try {
            PreparedStatement statement = conexao.prepareStatement("SELECT * FROM pecas_faltantes");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String codigo = resultSet.getString("id");
                String nome = resultSet.getString("nome");
                String marca = resultSet.getString("marca");
                int quantidade = resultSet.getInt("quantidade_em_falta");
                Pecas peca = new Pecas(quantidade, codigo, nome, marca);
                pecas.add(peca);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        return pecas;    }

    public List<Pecas> listarEstoque() throws SQLException, ClassNotFoundException {
        List<Pecas> pecas = new ArrayList<>();

       try {
            PreparedStatement statement = conexao.prepareStatement("SELECT * FROM pecas_estoque");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String codigo = resultSet.getString("id");
                String nome = resultSet.getString("nome");
                String marca = resultSet.getString("marca");
                int quantidade = resultSet.getInt("quantidade_em_falta");
                Pecas peca = new Pecas(quantidade, codigo, nome, marca);
                pecas.add(peca);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        return pecas;    }

}

