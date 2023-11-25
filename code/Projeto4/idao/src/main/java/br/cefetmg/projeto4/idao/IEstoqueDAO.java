package br.cefetmg.projeto4.idao;

import java.sql.SQLException;
import java.util.List;

import br.cefetmg.projeto4.dto.ItemEstoqueDTO;

public interface IEstoqueDAO extends AutoCloseable {
    boolean inserir(ItemEstoqueDTO item) throws SQLException, ClassNotFoundException;
    boolean alterar(ItemEstoqueDTO item) throws SQLException, ClassNotFoundException;
    boolean remover(ItemEstoqueDTO item) throws SQLException, ClassNotFoundException;
    List<ItemEstoqueDTO> listar() throws SQLException, ClassNotFoundException;
    void close() throws SQLException;
}