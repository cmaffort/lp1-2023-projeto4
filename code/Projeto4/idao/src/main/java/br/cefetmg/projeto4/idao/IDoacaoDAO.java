package br.cefetmg.projeto4.idao;

import br.cefetmg.projeto4.dto.DoacaoDTO;
import java.sql.SQLException;
import java.util.List;

public interface IDoacaoDAO {
    boolean inserir(DoacaoDTO doacao) throws SQLException, ClassNotFoundException;
    boolean alterar(DoacaoDTO doacao) throws SQLException, ClassNotFoundException;
    boolean remover(DoacaoDTO doacao) throws SQLException, ClassNotFoundException;
    List<DoacaoDTO> listar() throws SQLException, ClassNotFoundException;    

}
