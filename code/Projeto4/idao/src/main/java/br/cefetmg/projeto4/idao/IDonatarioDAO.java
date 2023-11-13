package br.cefetmg.projeto4.idao;

import br.cefetmg.projeto4.dto.DonatarioDTO;
import java.sql.SQLException;
import java.util.List;

public interface IDonatarioDAO  {
    boolean inserir(DonatarioDTO donatario) throws SQLException, ClassNotFoundException;
    boolean alterar(DonatarioDTO donatario) throws SQLException, ClassNotFoundException;
    boolean remover(DonatarioDTO donatario) throws SQLException, ClassNotFoundException;
    List<DonatarioDTO> listar() throws SQLException, ClassNotFoundException;    
}
