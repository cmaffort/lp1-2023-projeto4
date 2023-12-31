package br.cefetmg.projeto4.dao;
import br.cefetmg.projeto4.dto.ProfessorDTO;
import br.cefetmg.projeto4.dto.UsuarioDTO;
import br.cefetmg.projeto4.idao.IProfessorDAO;

import java.sql.*;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

public class ProfessorDAO extends UsuarioDAO implements IProfessorDAO {
    public ProfessorDAO() throws SQLException {}

    @Override
    public boolean inserir(ProfessorDTO professor) throws SQLException, ClassNotFoundException {
        try {
            conexao.setAutoCommit(false);

            if (!super.inserir(professor))
                throw new SQLException("Failed to insert");

            String sql = "INSERT IGNORE INTO professores (id_cadastro, departamento) VALUES ((SELECT id FROM usuarios WHERE email = ?), ?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            
            stmt.setString(1, professor.getEmail());
            stmt.setString(2, professor.getDepartamento());

            int rowsAffected = stmt.executeUpdate();
    
            if (rowsAffected <= 0) 
                throw new SQLException("Insertion into professores failed");

            stmt.close();
    
            System.out.println("Inserção realizada com sucesso");
            conexao.commit();
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
        public List<ProfessorDTO> listar() throws SQLException, ClassNotFoundException {
        List<ProfessorDTO> professores = new ArrayList<>();

    try {
        PreparedStatement statement = conexao.prepareStatement("SELECT professores.*, usuarios.* FROM professores JOIN usuarios ON professores.id_cadastro = usuarios.id;");
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            String nome = resultSet.getString("nome");
            String CPF = resultSet.getString("codigo");
            String email = resultSet.getString("email");
            String senha = resultSet.getString("senha");
            String foto = resultSet.getString("foto");
            String departamento = resultSet.getString("departamento");

            ProfessorDTO professor = new ProfessorDTO(nome, CPF, email, senha, foto, departamento);
            professores.add(professor);
        }


        resultSet.close();
        statement.close();
    }  catch (SQLException e) {
        System.out.println("Erro: " + e.getMessage());
    }
        return professores;
        }

    @Override
    public Optional<UsuarioDTO> selecionar(String email) throws SQLException {
        try {
            String sql = "SELECT professores.*, usuarios.* FROM professores JOIN usuarios ON professores.id_cadastro = usuarios.id WHERE email = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            
            stmt.setString(1, email);

            ResultSet resultSet = stmt.executeQuery();
            ProfessorDTO professor = null;

            if (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String CPF = resultSet.getString("codigo");
                String senha = resultSet.getString("senha");
                String foto = resultSet.getString("foto");
                String departamento = resultSet.getString("departamento");

                professor = new ProfessorDTO(nome, CPF, email, senha, foto, departamento);
            } 
            else 
                throw new SQLException("Selection failed");

            stmt.close();
            resultSet.close();
    
            System.out.println("Seleção realizada com sucesso");
            return Optional.ofNullable(professor);
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return Optional.empty();
        } 
    }
}
