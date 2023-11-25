package br.cefetmg.projeto4.idao;

import java.sql.SQLException;
import java.util.List;

import br.cefetmg.projeto4.dto.FeedbackDTO;

public interface IFeedbackDAO extends AutoCloseable {
    boolean inserir(FeedbackDTO feedback) throws SQLException, ClassNotFoundException;
    boolean remover(FeedbackDTO feedback) throws SQLException, ClassNotFoundException;
    List<FeedbackDTO> listar() throws SQLException, ClassNotFoundException;
    void close() throws SQLException;
}