package br.cefetmg.projeto4.idao;
import br.cefetmg.projeto4.dto.CompraDTO;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;

public interface ICompraDAO extends IPecasDAO {
    boolean registrarCompra(int id, int quantidade, double valorUnitario) throws SQLException, ClassNotFoundException, NoSuchElementException;
    double getTotalCompras() throws SQLException, ClassNotFoundException;
    List<CompraDTO> listar() throws SQLException, ClassNotFoundException;
    void close() throws SQLException;
}