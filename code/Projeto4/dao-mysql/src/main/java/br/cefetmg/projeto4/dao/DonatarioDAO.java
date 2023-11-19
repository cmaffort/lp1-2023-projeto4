package br.cefetmg.projeto4.dao;
import br.cefetmg.projeto4.idao.IDonatarioDAO;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

import br.cefetmg.projeto4.dto.DonatarioDTO;
import br.cefetmg.projeto4.dto.UsuarioDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author lucas
 */
public class DonatarioDAO extends UsuarioDAO implements IDonatarioDAO {
    public DonatarioDAO() throws SQLException {
        super();
    }

    @Override
    public boolean inserir(DonatarioDTO donatario) throws SQLException, ClassNotFoundException {
        try {
            if (!super.inserir(donatario))
                return false;

            Statement stmt = conexao.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT COALESCE(MAX(posicao) + 1, 1) AS posicao FROM donatarios");


            if (!resultSet.next())
                throw new SQLException("Selection failed");

            int posicao = resultSet.getInt("posicao");
            String sql = "INSERT IGNORE INTO donatarios (id_cadastro, escola, posicao, serie) VALUES ((SELECT id FROM usuarios WHERE email = ?), ?, ?, ?)";
            PreparedStatement stmt2 = conexao.prepareStatement(sql);
            
            stmt2.setString(1, donatario.getEmail());
            stmt2.setString(2, donatario.getEscola());
            stmt2.setInt(3, posicao);
            stmt2.setInt(4, donatario.getSerie());

            int rowsAffected = stmt2.executeUpdate();
    
            if (rowsAffected <= 0) 
                throw new SQLException("Insertion into donatarios failed");

            stmt2.close();
    
            System.out.println("Inserção realizada com sucesso");
            return true;
        } catch (SQLException e) {
            remover(donatario);

            System.out.println("Erro: " + e.getMessage());
            return false;
        } 
    } 

    @Override
    public boolean alterar(DonatarioDTO donatario) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<DonatarioDTO> listar() throws SQLException, ClassNotFoundException {
    List<DonatarioDTO> donatarios = new ArrayList<>();

    try {
        PreparedStatement statement = conexao.prepareStatement("SELECT donatarios.*, usuarios.* FROM donatarios JOIN usuarios ON donatarios.id_cadastro = usuarios.id WHERE posicao > 0 ORDER BY posicao");
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            String nome = resultSet.getString("nome");
            String CPF = resultSet.getString("codigo");
            String email = resultSet.getString("email");
            String senha = resultSet.getString("senha");
            byte[] foto = resultSet.getBytes("foto");
            String escola = resultSet.getString("escola");
            int posicao = resultSet.getInt("posicao");
            int serie = resultSet.getInt("serie");

            DonatarioDTO donatario = new DonatarioDTO(nome, CPF, email, senha, foto, escola, posicao, serie);
            donatarios.add(donatario);
        }

        resultSet.close();
        statement.close();
    } catch (SQLException e) {
        System.out.println("Erro: " + e.getMessage());
    }

    return donatarios;

    }

    @Override
    public Optional<UsuarioDTO> selecionar(String email) throws SQLException {
        try {
            String sql = "SELECT donatarios.*, usuarios.* FROM donatarios JOIN usuarios ON donatarios.id_cadastro = usuarios.id WHERE email = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            
            stmt.setString(1, email);

            ResultSet resultSet = stmt.executeQuery();
            DonatarioDTO donatario = null;

            if (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String CPF = resultSet.getString("codigo");
                String senha = resultSet.getString("senha");
                byte[] foto = resultSet.getBytes("foto");
                String escola = resultSet.getString("escola");
                int posicao = resultSet.getInt("posicao");
                int serie = resultSet.getInt("serie");
                
                donatario = new DonatarioDTO(nome, CPF, email, senha, foto, escola, posicao, serie);
            }
            else 
                throw new SQLException("Selection failed");

            stmt.close();
            resultSet.close();
    
            System.out.println("Seleção realizada com sucesso");
            return Optional.ofNullable(donatario);
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return Optional.empty();
        } 
    }
}
