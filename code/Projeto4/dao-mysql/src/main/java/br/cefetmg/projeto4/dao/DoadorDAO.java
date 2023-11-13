package br.cefetmg.projeto4.dao;
import br.cefetmg.projeto4.dao.mysql.MySqlConnection;
import br.cefetmg.projeto4.dto.DoadorDTO;
import br.cefetmg.projeto4.idao.IDoadorDAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoadorDAO implements IDoadorDAO {
    MySqlConnection bancoDeDados;
    Connection conexao;

    public DoadorDAO() throws SQLException {
        bancoDeDados = new MySqlConnection();
        conexao = bancoDeDados.getConexao(); // Abre a conexão com o banco de dados
    }

    @Override
    public boolean inserir(DoadorDTO doador) throws SQLException, ClassNotFoundException {
        try {
            conexao.setAutoCommit(false);
    
            String cadastroSQL = "INSERT INTO usuarios (nome, codigo, email, senha, tipo) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt1 = conexao.prepareStatement(cadastroSQL, Statement.RETURN_GENERATED_KEYS);
    
            stmt1.setString(1, doador.getNome());
            stmt1.setString(2, doador.getCodigo());
            stmt1.setString(3, doador.getEmail());
            stmt1.setString(4, doador.getSenha());
            stmt1.setString(5, doador.getTipo());
    
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
    
            PreparedStatement stmt2 = conexao.prepareStatement("INSERT INTO doadores (id_cadastro, computadores_doados) VALUES (?, ?)");
            
            stmt2.setInt(1, lastId);
            stmt2.setInt(2, doador.getComputadoresDoados());
            rowsAffected = stmt2.executeUpdate();
    
            if (rowsAffected <= 0) 
                throw new SQLException("Insertion into doadores failed");
    
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
    public boolean alterar(DoadorDTO doador) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean remover(DoadorDTO doador) throws SQLException, ClassNotFoundException {
        try {
            conexao.setAutoCommit(false);
    
            PreparedStatement stmt1 = conexao.prepareStatement("SELECT id FROM usuarios WHERE codigo = ?");
            stmt1.setString(1, doador.getCodigo());
            ResultSet resultSet = stmt1.executeQuery();
    
            int id;

            if (resultSet.next()) 
                id = resultSet.getInt("id");
            else 
                throw new SQLException("Id selection failed");

            PreparedStatement stmt2 = conexao.prepareStatement("DELETE FROM doadores WHERE id_cadastro = ?");
            stmt2.setInt(1, id);
    
            int rowsAffectedDoador = stmt2.executeUpdate();
    
            if (rowsAffectedDoador <= 0) 
                throw new SQLException("Deletion from doadores failed");
    
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
    public List<DoadorDTO> listar() throws SQLException, ClassNotFoundException {
    List<DoadorDTO> doadores = new ArrayList<>();

    try {
        PreparedStatement statement = conexao.prepareStatement("SELECT doadores.*, usuarios.* FROM doadores JOIN usuarios ON doadores.id_cadastro = usuarios.id;");
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            String nome = resultSet.getString("nome");
            String CPF = resultSet.getString("codigo");
            String email = resultSet.getString("email");
            String senha = resultSet.getString("senha");
            int computadoresDoados = resultSet.getInt("computadores_doados");
            DoadorDTO doador = new DoadorDTO(nome, CPF, email, senha, computadoresDoados);
            doadores.add(doador);
        }

        resultSet.close();
        statement.close();
    } catch (SQLException e) {
        System.out.println("Erro: " + e.getMessage());
    }

    return doadores;

    }
   
}