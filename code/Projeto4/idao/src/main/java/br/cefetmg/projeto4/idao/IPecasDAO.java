package br.cefetmg.projeto4.idao;

import br.cefetmg.projeto4.dto.PecasDTO;
import java.sql.SQLException;
import java.util.List;

public interface IPecasDAO {
    boolean inserir(PecasDTO pecas) throws SQLException, ClassNotFoundException;
    boolean alterar(PecasDTO pecas) throws SQLException, ClassNotFoundException;
    boolean remover(PecasDTO pecas) throws SQLException, ClassNotFoundException;
    List<PecasDTO> listar() throws SQLException, ClassNotFoundException;    

}
