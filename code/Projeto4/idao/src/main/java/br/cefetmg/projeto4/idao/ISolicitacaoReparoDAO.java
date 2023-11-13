package br.cefetmg.projeto4.idao;

import br.cefetmg.projeto4.dto.SolicitacaoReparoDTO;
import java.sql.SQLException;
import java.util.List;

public interface ISolicitacaoReparoDAO {
    boolean inserir(SolicitacaoReparoDTO estagiario) throws SQLException, ClassNotFoundException;
    boolean alterar(SolicitacaoReparoDTO estagiario) throws SQLException, ClassNotFoundException;
    boolean remover(SolicitacaoReparoDTO estagiario) throws SQLException, ClassNotFoundException;
    List<SolicitacaoReparoDTO> listar() throws SQLException, ClassNotFoundException;    

}

