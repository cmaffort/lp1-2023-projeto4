package br.cefetmg.projeto4.idao;

import br.cefetmg.projeto4.dto.PecasDTO;
import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;

public interface IPecasDAO extends AutoCloseable  {
    boolean inserir(PecasDTO pecas) throws SQLException, ClassNotFoundException;
    boolean remover(PecasDTO pecas) throws SQLException, ClassNotFoundException;
    boolean registrarCompra(int id, int quantidade) throws SQLException, ClassNotFoundException, NoSuchElementException;
    PecasDTO selecionarFaltoso(int id) throws SQLException, ClassNotFoundException, NoSuchElementException;
    List<PecasDTO> listarFaltosos() throws SQLException, ClassNotFoundException;   
    List<PecasDTO> listarPedidos() throws SQLException, ClassNotFoundException;
    void close() throws SQLException;  
}