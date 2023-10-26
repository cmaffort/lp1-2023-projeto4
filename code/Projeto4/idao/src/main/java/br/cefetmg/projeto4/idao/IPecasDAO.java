package br.cefetmg.projeto4.idao;

import br.cefetmg.projeto4.dto.Pecas;
import java.sql.SQLException;
import java.util.List;

public interface IPecasDAO {
    boolean inserir(Pecas pecas) throws SQLException, ClassNotFoundException;
    boolean alterar(Pecas pecas) throws SQLException, ClassNotFoundException;
    boolean remover(Pecas pecas) throws SQLException, ClassNotFoundException;
    List<Pecas> listar() throws SQLException, ClassNotFoundException;    

}
