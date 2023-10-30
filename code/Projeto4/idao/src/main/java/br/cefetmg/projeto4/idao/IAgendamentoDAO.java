package br.cefetmg.projeto4.idao;
import br.cefetmg.projeto4.dto.Agendamento;
import java.sql.SQLException;
import java.util.List;

public interface IAgendamentoDAO {
    boolean inserir(Agendamento agendamento) throws SQLException, ClassNotFoundException;
    boolean alterar(Agendamento agendamento) throws SQLException, ClassNotFoundException;
    boolean remover(Agendamento agendamento) throws SQLException, ClassNotFoundException;
    List<Agendamento> listar() throws SQLException, ClassNotFoundException;
}
