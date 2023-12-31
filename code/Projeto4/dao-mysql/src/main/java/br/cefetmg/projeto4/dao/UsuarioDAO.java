package br.cefetmg.projeto4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;

import br.cefetmg.projeto4.dto.UsuarioDTO;
import br.cefetmg.projeto4.idao.IUsuarioDAO;

public class UsuarioDAO implements IUsuarioDAO {
    protected final Connection conexao;

    public UsuarioDAO() throws SQLException {
        conexao = MysqlConnection.getConexao();
    }

    @Override
    public final boolean autenticar(UsuarioDTO usuario, String senha) throws SQLException {
        return BCrypt.checkpw(senha, usuario.getSenha());
    }

    @Override
    public boolean inserir(UsuarioDTO usuario) throws SQLException {
        try {
            String sql = "INSERT IGNORE INTO usuarios (nome, codigo, tipo_codigo, email, senha, tipo) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
    
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getCodigo());
            stmt.setString(3, usuario.getTipoCodigo());
            stmt.setString(4, usuario.getEmail());

            String senhaHash = BCrypt.hashpw(usuario.getSenha(), BCrypt.gensalt());

            stmt.setString(5, senhaHash);
            stmt.setString(6, usuario.getTipo());
    
            int rowsAffected = stmt.executeUpdate();
    
            if (rowsAffected <= 0) 
                throw new SQLException("Insertion into usuarios failed");

            stmt.close();
    
            System.out.println("Inserção realizada com sucesso");
            return true;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return false;
        }
    }

    @Override
    public final boolean remover(UsuarioDTO usuario) throws SQLException {
        try {
            String sql = "DELETE FROM usuarios WHERE email = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
    
            stmt.setString(1, usuario.getEmail());
    
            int rowsAffected = stmt.executeUpdate();
    
            if (rowsAffected <= 0) 
                throw new SQLException("Deletion from usuarios failed");

            stmt.close();
    
            System.out.println("Deleção realizada com sucesso");
            return true;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return false; 
        }
    }

    @Override
    public boolean setFoto(String email, String foto) throws SQLException {
        try {
            String sql = "UPDATE usuarios SET foto = ? WHERE email = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
    
            stmt.setString(1, foto);
            stmt.setString(2, email);
    
            int rowsAffected = stmt.executeUpdate();
    
            if (rowsAffected <= 0) 
                throw new SQLException("Update failed");

            stmt.close();
    
            System.out.println("Atualizacao realizada com sucesso");
            return true;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return false; 
        }
    }

    @Override
    public boolean resetFoto(String email) throws SQLException {
        try {
            String sql = "UPDATE usuarios SET foto = DEFAULT WHERE email = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
    
            stmt.setString(1, email);
    
            int rowsAffected = stmt.executeUpdate();
    
            if (rowsAffected <= 0) 
                throw new SQLException("Update failed");

            stmt.close();
    
            System.out.println("Atualizacao realizada com sucesso");
            return true;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return false; 
        }
    }

    @Override
    public Optional<UsuarioDTO> selecionar(String email) throws SQLException {
        try {
            String sql = "SELECT * FROM usuarios WHERE email = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            
            stmt.setString(1, email);

            ResultSet resultSet = stmt.executeQuery();
            UsuarioDTO usuario = null;

            if (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String codigo = resultSet.getString("codigo");
                String tipoCodigo = resultSet.getString("tipo_codigo");
                String senha = resultSet.getString("senha");
                String foto = resultSet.getString("foto");
                String tipo = resultSet.getString("tipo");

                usuario = new UsuarioDTO(nome, codigo, tipoCodigo, email, senha, tipo, foto);
            } 
            else 
                throw new SQLException("Selection failed");

            stmt.close();
            resultSet.close();
    
            System.out.println("Seleção realizada com sucesso");
            return Optional.ofNullable(usuario);
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public final void close() throws SQLException {
        conexao.close();
    }
}
