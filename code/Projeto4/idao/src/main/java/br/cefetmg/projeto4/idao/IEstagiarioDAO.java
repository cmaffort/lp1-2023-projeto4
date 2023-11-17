package br.cefetmg.projeto4.idao;

import br.cefetmg.projeto4.dto.EstagiarioDTO;
import java.sql.SQLException;
import java.util.List;

public interface IEstagiarioDAO extends IUsuarioDAO {
    boolean inserir(EstagiarioDTO estagiario) throws SQLException, ClassNotFoundException;
    boolean alterar(EstagiarioDTO estagiario) throws SQLException, ClassNotFoundException;
    List<EstagiarioDTO> listar() throws SQLException, ClassNotFoundException;    
}