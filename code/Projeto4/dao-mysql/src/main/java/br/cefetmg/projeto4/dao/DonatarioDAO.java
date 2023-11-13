package br.cefetmg.projeto4.dao;
import br.cefetmg.projeto4.dao.mysql.MySqlConnection;
import br.cefetmg.projeto4.idao.IDonatarioDAO;
import java.sql.*;

import br.cefetmg.projeto4.dto.DonatarioDTO;
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
    public boolean inserir(DonatarioDTO donatario) throws SQLException, ClassNotFoundException {
        try {
            conexao.setAutoCommit(false);
    
            String cadastroSQL = "INSERT INTO usuarios (nome, codigo, email, senha) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt1 = conexao.prepareStatement(cadastroSQL, Statement.RETURN_GENERATED_KEYS);
    
            stmt1.setString(1, donatario.getNome());
            stmt1.setString(2, donatario.getCodigo());
            stmt1.setString(3, donatario.getEmail());
            stmt1.setString(4, donatario.getSenha());
    
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
    
            PreparedStatement stmt2 = conexao.prepareStatement("INSERT INTO donatarios (id_cadastro, escola, posicao, serie) VALUES (?, ?, ?, ?)");
            
            stmt2.setInt(1, lastId);
            stmt2.setString(2, donatario.getEscola());
            stmt2.setInt(3, donatario.getPosicao());
            stmt2.setInt(4, donatario.getSerie());
            rowsAffected = stmt2.executeUpdate();
    
            if (rowsAffected <= 0) 
                throw new SQLException("Insertion into donatarios failed");
    
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
    public boolean alterar(DonatarioDTO donatario) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean remover(DonatarioDTO donatario) throws SQLException, ClassNotFoundException {
        try {
            conexao.setAutoCommit(false);
    
            PreparedStatement stmt1 = conexao.prepareStatement("SELECT id FROM usuarios WHERE codigo = ?");
            stmt1.setString(1, donatario.getCodigo());
            ResultSet resultSet = stmt1.executeQuery();
    
            int id;

            if (resultSet.next()) 
                id = resultSet.getInt("id");
            else 
                throw new SQLException("Id selection failed");

            PreparedStatement stmt2 = conexao.prepareStatement("DELETE FROM donatarios WHERE id_cadastro = ?");
            stmt2.setInt(1, id);
    
            int rowsAffectedDoador = stmt2.executeUpdate();
    
            if (rowsAffectedDoador <= 0) 
                throw new SQLException("Deletion from donatarios failed");
    
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
    public List<DonatarioDTO> listar() throws SQLException, ClassNotFoundException {
    List<DonatarioDTO> donatarios = new ArrayList<>();

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
            int serie = 0;

            DonatarioDTO donatario = new DonatarioDTO(nome, CPF, email, senha, escola, posicao, serie);
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
