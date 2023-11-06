package br.cefetmg.projeto4.idao;

import br.cefetmg.projeto4.dto.SolicitacaoReparo;
import java.sql.SQLException;
import java.util.List;

public interface ISolicitacaoReparoDAO {
    boolean inserir(SolicitacaoReparo estagiario) throws SQLException, ClassNotFoundException;
    boolean alterar(SolicitacaoReparo estagiario) throws SQLException, ClassNotFoundException;
    boolean remover(SolicitacaoReparo estagiario) throws SQLException, ClassNotFoundException;
    List<SolicitacaoReparo> listar() throws SQLException, ClassNotFoundException;    

}

