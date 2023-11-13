package br.cefetmg.projeto4.idao;
import br.cefetmg.projeto4.dto.AgendamentoDTO;
import br.cefetmg.projeto4.dto.AgendamentoComUsuarioDTO;

import java.sql.SQLException;
import java.util.List;

public interface IAgendamentoDAO {
    boolean inserir(AgendamentoDTO agendamento) throws SQLException, ClassNotFoundException;
    boolean alterar(AgendamentoDTO agendamento) throws SQLException, ClassNotFoundException;
    boolean remover(AgendamentoDTO agendamento) throws SQLException, ClassNotFoundException;
    List<AgendamentoComUsuarioDTO> listar() throws SQLException, ClassNotFoundException;
}
