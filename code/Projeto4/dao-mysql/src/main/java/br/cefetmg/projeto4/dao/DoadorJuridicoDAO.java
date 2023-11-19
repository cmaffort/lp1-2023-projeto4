/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.projeto4.dao;
import br.cefetmg.projeto4.idao.IDoadorJuridicoDAO;
import br.cefetmg.projeto4.dto.DoadorDTO;
import br.cefetmg.projeto4.dto.DoadorJuridicoDTO;
import br.cefetmg.projeto4.dto.UsuarioDTO;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DoadorJuridicoDAO extends DoadorDAO implements IDoadorJuridicoDAO {
    public DoadorJuridicoDAO() throws SQLException {}

    @Override
    public boolean inserir(DoadorJuridicoDTO doador) throws SQLException, ClassNotFoundException {
        try {
            if (!super.inserir(doador))
                return false;

            String sql = "INSERT IGNORE INTO doadoresJuridicos (id_doador, endereco) VALUES ((SELECT id FROM doadores WHERE id_cadastro = (SELECT id FROM usuarios WHERE email = ?)), ?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            
            stmt.setString(1, doador.getEmail());
            stmt.setString(2, doador.getEndereco());

            int rowsAffected = stmt.executeUpdate();
    
            if (rowsAffected <= 0) 
                throw new SQLException("Insertion into doadoresJuridicos failed");

            stmt.close();
    
            System.out.println("Inserção realizada com sucesso");
            return true;
        } catch (SQLException e) {
            remover(doador);

            System.out.println("Erro: " + e.getMessage());
            return false;
        } 
    }

    @Override
    public boolean alterar(DoadorJuridicoDTO doador) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<DoadorDTO> listar() throws SQLException, ClassNotFoundException {
   List<DoadorDTO> doadoresJuridicos = new ArrayList<>();

    try {
        PreparedStatement statement = conexao.prepareStatement("SELECT doadoresJuridicos.*, doadores.*, usuarios.* FROM doadoresJuridicos JOIN doadores ON doadoresJuridicos.id_doador = doadores.id JOIN usuarios ON doadores.id_cadastro = usuarios.id;");
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            String nome = resultSet.getString("nome");
            String CNPJ = resultSet.getString("codigo");
            String email = resultSet.getString("email");
            String senha = resultSet.getString("senha");
            byte[] foto = resultSet.getBytes("foto");
            int computadoresDoados = resultSet.getInt("computadores_doados");
            String endereco = resultSet.getString("endereco");

            DoadorJuridicoDTO doadorJuridico = new DoadorJuridicoDTO(nome, CNPJ, email, senha, foto, computadoresDoados, endereco);
            doadoresJuridicos.add(doadorJuridico);
        }

        resultSet.close();
        statement.close();
    } catch (SQLException e) {
        System.out.println("Erro: " + e.getMessage());
    }

    return doadoresJuridicos;
    }

    @Override
    public Optional<UsuarioDTO> selecionar(String email) throws SQLException {
        try {
            String sql = "SELECT doadoresJuridicos.*, doadores.*, usuarios.* FROM doadoresJuridicos JOIN doadores ON doadoresJuridicos.id_doador = doadores.id JOIN usuarios ON doadores.id_cadastro = usuarios.id WHERE email = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            
            stmt.setString(1, email);

            ResultSet resultSet = stmt.executeQuery();
            DoadorJuridicoDTO doador = null;

            if (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String CPF = resultSet.getString("codigo");
                String senha = resultSet.getString("senha");
                byte[] foto = resultSet.getBytes("foto");
                int doacoes = resultSet.getInt("computadores_doados");
                String endereco = resultSet.getString("endereco");

                doador = new DoadorJuridicoDTO(nome, CPF, email, senha, foto, doacoes, endereco);
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