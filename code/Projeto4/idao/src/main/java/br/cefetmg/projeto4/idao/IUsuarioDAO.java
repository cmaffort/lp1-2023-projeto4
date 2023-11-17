package br.cefetmg.projeto4.idao;

import java.sql.SQLException;
import java.util.Optional;

import br.cefetmg.projeto4.dto.UsuarioDTO;

public interface IUsuarioDAO {
    boolean inserir(UsuarioDTO usuario) throws SQLException;
    boolean autenticar(UsuarioDTO usuario, String senha) throws SQLException;
    boolean remover(UsuarioDTO usuario) throws SQLException;
    Optional<UsuarioDTO> selecionar(String email) throws SQLException;
}