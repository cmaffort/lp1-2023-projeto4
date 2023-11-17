package br.cefetmg.projeto4.dao;
import br.cefetmg.projeto4.dto.DoadorDTO;
import br.cefetmg.projeto4.dto.UsuarioDTO;
import br.cefetmg.projeto4.idao.IDoadorDAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DoadorDAO extends UsuarioDAO implements IDoadorDAO {
    public DoadorDAO() throws SQLException {}

    @Override
    public boolean inserir(DoadorDTO doador) throws SQLException, ClassNotFoundException {
        try {
            super.inserir(doador);

            String sql = "INSERT IGNORE INTO doadores (id_cadastro, tipo) VALUES ((SELECT id FROM usuarios WHERE email = ?), ?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            
            stmt.setString(1, doador.getEmail());
            stmt.setString(2, doador.getTipoDoador());

            int rowsAffected = stmt.executeUpdate();
    
            if (rowsAffected <= 0) 
                throw new SQLException("Insertion into doadores failed");

            stmt.close();
    
            System.out.println("Inserção realizada com sucesso");
            return true;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return false;
        } 
    }    

    @Override
    public boolean alterar(DoadorDTO doador) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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

    @Override
    public Optional<UsuarioDTO> selecionar(String email) throws SQLException {
        try {
            String sql = "SELECT doadores.*, usuarios.* FROM doadores JOIN usuarios ON doadores.id_cadastro = usuarios.id WHERE email = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            
            stmt.setString(1, email);

            ResultSet resultSet = stmt.executeQuery();
            DoadorDTO doador = null;

            if (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String CPF = resultSet.getString("codigo");
                String senha = resultSet.getString("senha");
                int doacoes = resultSet.getInt("computadores_doados");

                doador = new DoadorDTO(nome, CPF, email, senha, doacoes);
            } 
            else 
                throw new SQLException("Selection failed");

            stmt.close();
            resultSet.close();
    
            System.out.println("Seleção realizada com sucesso");
            return Optional.ofNullable(doador);
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return Optional.empty();
        } 
    }
}