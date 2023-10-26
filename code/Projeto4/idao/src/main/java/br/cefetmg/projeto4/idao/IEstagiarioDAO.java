package br.cefetmg.projeto4.idao;

import br.cefetmg.projeto4.dto.Estagiario;
import java.sql.SQLException;
import java.util.List;

public interface IEstagiarioDAO {
    boolean inserir(Estagiario estagiario) throws SQLException, ClassNotFoundException;
    boolean alterar(Estagiario estagiario) throws SQLException, ClassNotFoundException;
    boolean remover(Estagiario estagiario) throws SQLException, ClassNotFoundException;
    List<Estagiario> listar() throws SQLException, ClassNotFoundException;    

}
