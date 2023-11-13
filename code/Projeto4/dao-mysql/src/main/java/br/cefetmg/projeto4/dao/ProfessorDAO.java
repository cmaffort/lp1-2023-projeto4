package br.cefetmg.projeto4.dao;
import br.cefetmg.projeto4.dao.mysql.MySqlConnection;
import br.cefetmg.projeto4.dto.ProfessorDTO;
import br.cefetmg.projeto4.idao.IProfessorDAO;
import java.sql.*;
import java.util.List;

public class ProfessorDAO implements IProfessorDAO {
    MySqlConnection bancoDeDados;
    Connection conexao;

    public ProfessorDAO() throws SQLException {
        bancoDeDados = new MySqlConnection();
        conexao = bancoDeDados.getConexao(); // Abre a conexão com o banco de dados
    }

    @Override
    public boolean inserir(ProfessorDTO professor) throws SQLException, ClassNotFoundException {
        try {
            conexao.setAutoCommit(false);
    
            String cadastroSQL = "INSERT INTO usuarios (nome, codigo, email, senha, tipo) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt1 = conexao.prepareStatement(cadastroSQL, Statement.RETURN_GENERATED_KEYS);
    
            stmt1.setString(1, professor.getNome());
            stmt1.setString(2, professor.getCodigo());
            stmt1.setString(3, professor.getEmail());
            stmt1.setString(4, professor.getSenha());
            stmt1.setString(5, professor.getTipo());
    
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
    
            PreparedStatement stmt2 = conexao.prepareStatement("INSERT INTO professores (id_cadastro, departamento) VALUES (?, ?)");
            
            stmt2.setInt(1, lastId);
            stmt2.setString(2, professor.getDepartamento());
            rowsAffected = stmt2.executeUpdate();
    
            if (rowsAffected <= 0) 
                throw new SQLException("Insertion into professores failed");
    
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
    public boolean alterar(ProfessorDTO professor) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean remover(ProfessorDTO professor) throws SQLException, ClassNotFoundException {
        try {
            conexao.setAutoCommit(false);
    
            PreparedStatement stmt1 = conexao.prepareStatement("SELECT id FROM usuarios WHERE codigo = ?");
            stmt1.setString(1, professor.getCodigo());
            ResultSet resultSet = stmt1.executeQuery();
    
            int id;

            if (resultSet.next()) 
                id = resultSet.getInt("id");
            else 
                throw new SQLException("Id selection failed");

            PreparedStatement stmt2 = conexao.prepareStatement("DELETE FROM professores WHERE id_cadastro = ?");
            stmt2.setInt(1, id);
    
            int rowsAffectedDoador = stmt2.executeUpdate();
    
            if (rowsAffectedDoador <= 0) 
                throw new SQLException("Deletion from professores failed");
    
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
    public List<ProfessorDTO> listar() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
