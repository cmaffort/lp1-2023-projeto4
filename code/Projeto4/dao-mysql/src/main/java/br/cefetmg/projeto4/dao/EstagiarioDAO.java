package br.cefetmg.projeto4.dao;
import br.cefetmg.projeto4.idao.IEstagiarioDAO;
import java.sql.*;

import br.cefetmg.projeto4.dto.EstagiarioDTO;
import br.cefetmg.projeto4.dto.UsuarioDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EstagiarioDAO extends UsuarioDAO implements IEstagiarioDAO {
    public EstagiarioDAO() throws SQLException {}

    @Override
    public boolean inserir(EstagiarioDTO estagiario) throws SQLException, ClassNotFoundException {
        try {
            if (!super.inserir(estagiario))
                return false;

            String sql = "INSERT IGNORE INTO estagiarios (id_cadastro, dataDeEntrada, dataDeSaida) VALUES ((SELECT id FROM usuarios WHERE email = ?), ?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            
            stmt.setString(1, estagiario.getEmail());
            stmt.setString(2, estagiario.getDataEntrada());
            stmt.setString(3, estagiario.getDataSaida());

            int rowsAffected = stmt.executeUpdate();
    
            if (rowsAffected <= 0) 
                throw new SQLException("Insertion into estagiarios failed");

            stmt.close();
    
            System.out.println("Inserção realizada com sucesso");
            return true;
        } catch (SQLException e) {
            remover(estagiario);

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

    @Override
    public Optional<UsuarioDTO> selecionar(String email) throws SQLException {
        try {
            String sql = "SELECT estagiarios.*, usuarios.* FROM estagiarios JOIN usuarios ON estagiarios.id_cadastro = usuarios.id WHERE email = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            
            stmt.setString(1, email);

            ResultSet resultSet = stmt.executeQuery();
            EstagiarioDTO estagiario = null;

            if (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String CPF = resultSet.getString("codigo");
                String senha = resultSet.getString("senha");
                String dataEntrada = resultSet.getString("dataDeEntrada");
                String dataSaida = resultSet.getString("dataDeSaida");
                
                estagiario = new EstagiarioDTO(nome, CPF, email, senha, dataEntrada, dataSaida);
            } 
            else 
                throw new SQLException("Selection failed");

            stmt.close();
            resultSet.close();
    
            System.out.println("Seleção realizada com sucesso");
            return Optional.ofNullable(estagiario);
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return Optional.empty();
        } 
    }
}