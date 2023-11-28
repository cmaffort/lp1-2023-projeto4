package br.cefetmg.projeto4.idao;
import br.cefetmg.projeto4.dto.ComprasDTO;
import java.sql.SQLException;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author lucas
 */
public interface IComprasDAO extends AutoCloseable {
    boolean inserir(ComprasDTO compra) throws SQLException, ClassNotFoundException;
    boolean alterar(ComprasDTO compra) throws SQLException, ClassNotFoundException;
    boolean remover(ComprasDTO compra) throws SQLException, ClassNotFoundException;
    List<ComprasDTO> listar() throws SQLException, ClassNotFoundException;
    void close() throws SQLException;
}