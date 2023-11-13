/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.projeto4.dao;
import br.cefetmg.projeto4.dao.mysql.MySqlConnection;
import br.cefetmg.projeto4.idao.IDoadorJuridicoDAO;
import br.cefetmg.projeto4.dto.DoadorJuridicoDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoadorJuridicoDAO implements IDoadorJuridicoDAO {
    MySqlConnection bancoDeDados;
    Connection conexao;

    public DoadorJuridicoDAO() throws SQLException {
        bancoDeDados = new MySqlConnection();
        conexao = bancoDeDados.getConexao(); // Abre a conexão com o banco de dados
    }

    @Override
    public boolean inserir(DoadorJuridicoDTO doadorJuridico) throws SQLException, ClassNotFoundException {
        try {
            conexao.setAutoCommit(false);
    
            String cadastroSQL = "INSERT INTO usuarios (nome, codigo, tipo_codigo, email, senha, tipo) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt1 = conexao.prepareStatement(cadastroSQL, Statement.RETURN_GENERATED_KEYS);
    
            stmt1.setString(1, doadorJuridico.getNome());
            stmt1.setString(2, doadorJuridico.getCodigo());
            stmt1.setString(3, doadorJuridico.getTipoCodigo());
            stmt1.setString(4, doadorJuridico.getEmail());
            stmt1.setString(5, doadorJuridico.getSenha());
            stmt1.setString(6, doadorJuridico.getTipo());
    
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
    
            PreparedStatement stmt2 = conexao.prepareStatement("INSERT INTO doadores (id_cadastro, computadores_doados, tipo) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            
            stmt2.setInt(1, lastId);
            stmt2.setInt(2, doadorJuridico.getComputadoresDoados());
            stmt2.setString(3, doadorJuridico.getTipoDoador());
            rowsAffected = stmt2.executeUpdate();

            if (rowsAffected <= 0) 
                throw new SQLException("Insertion into doadores failed");

            try (ResultSet resultSet = stmt2.getGeneratedKeys()) {
                if (resultSet.next()) 
                    lastId = resultSet.getInt(1);
                else 
                    throw new SQLException("Failed to get the last inserted ID from doadores.");
            }

            PreparedStatement stmt3 = conexao.prepareStatement("INSERT INTO doadoresJuridicos (id_doador, endereco) VALUES (?, ?)");
            
            stmt3.setInt(1, lastId);
            stmt3.setString(2, doadorJuridico.getEndereco());
            rowsAffected = stmt3.executeUpdate();

            if (rowsAffected <= 0) 
                throw new SQLException("Insertion into doadoresJuridicos failed");

            conexao.commit();

            stmt1.close();
            stmt2.close();
            stmt3.close();
    
            System.out.println("Inserção realizada com sucesso");
            return true;
        } catch (SQLException e) {
            conexao.rollback();
    
            System.out.println("Erro: " + e.getMessage());
            return false;
        } 
    }

    @Override
    public boolean alterar(DoadorJuridicoDTO doadorJuridico) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean remover(DoadorJuridicoDTO doadorJuridico) throws SQLException, ClassNotFoundException {
        try {
            conexao.setAutoCommit(false);
    
            PreparedStatement stmt1 = conexao.prepareStatement("SELECT id FROM usuarios WHERE codigo = ?");
            stmt1.setString(1, doadorJuridico.getCodigo());
            ResultSet resultSet1 = stmt1.executeQuery();
    
            int idCadastro;

            if (resultSet1.next()) 
                idCadastro = resultSet1.getInt("id");
            else 
                throw new SQLException("usuarios.id selection failed");

            PreparedStatement stmt2 = conexao.prepareStatement("SELECT id FROM doadores WHERE id_cadastro = ?");
            stmt2.setInt(1, idCadastro);
            ResultSet resultSet2 = stmt2.executeQuery();

            int idDoador;

            if (resultSet2.next()) 
                idDoador = resultSet2.getInt("id");
            else 
                throw new SQLException("doadores.id selection failed");

            PreparedStatement stmt3 = conexao.prepareStatement("DELETE FROM doadoresJuridicos WHERE id_doador = ?");
            stmt3.setInt(1, idDoador);

            int rowsAffectedDoador = stmt3.executeUpdate();
    
            if (rowsAffectedDoador <= 0) 
                throw new SQLException("Deletion from doadoresJuridicos failed");

            PreparedStatement stmt4 = conexao.prepareStatement("DELETE FROM doadores WHERE id_cadastro = ?");
            stmt4.setInt(1, idCadastro);
    
            rowsAffectedDoador = stmt4.executeUpdate();
    
            if (rowsAffectedDoador <= 0) 
                throw new SQLException("Deletion from doadores failed");
    
            PreparedStatement stmt5 = conexao.prepareStatement("DELETE FROM usuarios WHERE id = ?");
            stmt5.setInt(1, idCadastro);
    
            rowsAffectedDoador = stmt5.executeUpdate();
    
            if (rowsAffectedDoador <= 0) 
                throw new SQLException("Deletion from usuarios failed");

            conexao.commit();

            stmt1.close();
            stmt2.close();
            stmt3.close();
            stmt4.close();
            stmt5.close();
    
            return true;
        } catch (SQLException e) {
            conexao.rollback();
    
            System.out.println("Erro: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<DoadorJuridicoDTO> listar() throws SQLException, ClassNotFoundException {
   List<DoadorJuridicoDTO> doadoresJuridicos = new ArrayList<>();

    try {
        PreparedStatement statement = conexao.prepareStatement("SELECT doadoresJuridicos.*, doadores.*, usuarios.* FROM doadoresJuridicos JOIN doadores ON doadoresJuridicos.id_doadores = doadores.id JOIN usuarios ON doadores.id_cadastro = usuarios.id;");
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            String nome = resultSet.getString("nome");
            String CNPJ = resultSet.getString("codigo");
            String email = resultSet.getString("email");
            String senha = resultSet.getString("senha");
            int computadoresDoados = resultSet.getInt("computadores_doados");
            String endereco = resultSet.getString("endereco");
            DoadorJuridicoDTO doadorJuridico = new DoadorJuridicoDTO(nome, CNPJ, email, senha, computadoresDoados, endereco);
            
            doadoresJuridicos.add(doadorJuridico);
        }

        resultSet.close();
        statement.close();
    } catch (SQLException e) {
        System.out.println("Erro: " + e.getMessage());
    }

    return doadoresJuridicos;
    }
    
}
