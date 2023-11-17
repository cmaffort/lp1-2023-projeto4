package br.cefetmg.projeto4.idao;
import br.cefetmg.projeto4.dto.AgendamentoDTO;

import java.sql.SQLException;
import java.util.List;

public interface IAgendamentoDAO {
    boolean inserir(AgendamentoDTO agendamento) throws SQLException, ClassNotFoundException;
    boolean alterar(AgendamentoDTO agendamento) throws SQLException, ClassNotFoundException;
    boolean remover(AgendamentoDTO agendamento) throws SQLException, ClassNotFoundException;
    List<AgendamentoDTO> listar() throws SQLException, ClassNotFoundException;
}