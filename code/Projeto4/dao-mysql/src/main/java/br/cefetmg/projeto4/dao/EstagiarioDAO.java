package br.cefetmg.projeto4.dao;
import br.cefetmg.projeto4.dao.mysql.MySqlConnection;
import br.cefetmg.projeto4.idao.IEstagiarioDAO;
import java.sql.*;

import br.cefetmg.projeto4.dto.EstagiarioDTO;
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
    public boolean inserir(EstagiarioDTO estagiario) throws SQLException, ClassNotFoundException {
        try {
            conexao.setAutoCommit(false);
    
            String cadastroSQL = "INSERT INTO usuarios (nome, codigo, email, senha, tipo) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt1 = conexao.prepareStatement(cadastroSQL, Statement.RETURN_GENERATED_KEYS);
    
            stmt1.setString(1, estagiario.getNome());
            stmt1.setString(2, estagiario.getCodigo());
            stmt1.setString(3, estagiario.getEmail());
            stmt1.setString(4, estagiario.getSenha());
            stmt1.setString(5, estagiario.getTipo());
    
            int rowsAffected = stmt1.executeUpdate();
    
            if (rowsAffected <= 0) 
                throw new SQLException("Insertion into usuarios failed");
    
            int lastId;
            try (ResultSet resultSet = stmt1.getGeneratedKeys()) {
                if (resultSet.next()) 
                    lastId = resultSet.getInt(1);
                else 
                    throw new SQLException("Failed to get the last inserted ID from usuarios.");
            }
    
            PreparedStatement stmt2 = conexao.prepareStatement("INSERT INTO estagiarios (id_cadastro, dataDeEntrada, dataDeSaida) VALUES (?, ?, ?)");
            
            stmt2.setInt(1, lastId);
            stmt2.setString(2, estagiario.getDataEntrada());
            stmt2.setString(3, estagiario.getDataSaida());
            rowsAffected = stmt2.executeUpdate();
    
            if (rowsAffected <= 0) 
                throw new SQLException("Insertion into estagiarios failed");
    
            conexao.commit();

            stmt1.close();
            stmt2.close();
    
            System.out.println("Inserção realizada com sucesso");
            return true;
        } catch (SQLException e) {
            conexao.rollback();
    
            System.out.println("Erro: " + e.getMessage());
            return false;
        } 
    }
    
    @Override
    public boolean remover(EstagiarioDTO estagiario) throws SQLException, ClassNotFoundException{
        try {
            conexao.setAutoCommit(false);
    
            PreparedStatement stmt1 = conexao.prepareStatement("SELECT id FROM usuarios WHERE codigo = ?");
            stmt1.setString(1, estagiario.getCodigo());
            ResultSet resultSet = stmt1.executeQuery();
    
            int id;

            if (resultSet.next()) 
                id = resultSet.getInt("id");
            else 
                throw new SQLException("Id selection failed");

            PreparedStatement stmt2 = conexao.prepareStatement("DELETE FROM estagiarios WHERE id_cadastro = ?");
            stmt2.setInt(1, id);
    
            int rowsAffectedDoador = stmt2.executeUpdate();
    
            if (rowsAffectedDoador <= 0) 
                throw new SQLException("Deletion from estagiarios failed");
    
            PreparedStatement stmt3 = conexao.prepareStatement("DELETE FROM usuarios WHERE id = ?");
            stmt3.setInt(1, id);
    
            rowsAffectedDoador = stmt3.executeUpdate();
    
            if (rowsAffectedDoador <= 0) 
                throw new SQLException("Deletion from usuarios failed");

            conexao.commit();

            stmt1.close();
            stmt2.close();
            stmt3.close();
    
            return true;
        } catch (SQLException e) {
            conexao.rollback();
    
            System.out.println("Erro: " + e.getMessage());
            return false;
        }
    }
    @Override
    public boolean alterar(EstagiarioDTO estagiario) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public List<EstagiarioDTO> listar() throws SQLException, ClassNotFoundException {
    List<EstagiarioDTO> estagiarios = new ArrayList<>();

    try {
        PreparedStatement statement = conexao.prepareStatement("SELECT estagiarios.*, usuarios.* FROM estagiarios JOIN usuarios ON estagiarios.id_cadastro = usuarios.id;");
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            String nome = resultSet.getString("nome");
            String CPF = resultSet.getString("codigo");
            String email = resultSet.getString("email");
            String senha = resultSet.getString("senha");
            String dataEntrada = resultSet.getString("dataDeEntrada");
            String dataSaida = resultSet.getString("dataDeSaida");
            EstagiarioDTO estagiario = new EstagiarioDTO(nome, CPF, email, senha, dataEntrada, dataSaida);
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