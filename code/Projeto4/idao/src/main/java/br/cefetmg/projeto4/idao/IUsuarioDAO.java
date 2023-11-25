package br.cefetmg.projeto4.idao;

import java.sql.SQLException;
import java.util.Optional;

import br.cefetmg.projeto4.dto.UsuarioDTO;

public interface IUsuarioDAO extends AutoCloseable {
    boolean inserir(UsuarioDTO usuario) throws SQLException;
    boolean autenticar(UsuarioDTO usuario, String senha) throws SQLException;
    boolean remover(UsuarioDTO usuario) throws SQLException;
    boolean setFoto(String email, String foto) throws SQLException;
    boolean resetFoto(String email) throws SQLException;
    Optional<UsuarioDTO> selecionar(String email) throws SQLException;
    void close() throws SQLException;
}