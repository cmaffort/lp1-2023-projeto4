package br.cefetmg.projeto4.idao;

import br.cefetmg.projeto4.dto.ProfessorDTO;
import java.sql.SQLException;
import java.util.List;

public interface IProfessorDAO {
    boolean inserir(ProfessorDTO professor) throws SQLException, ClassNotFoundException;
    boolean alterar(ProfessorDTO professor) throws SQLException, ClassNotFoundException;
    boolean remover(ProfessorDTO professor) throws SQLException, ClassNotFoundException;
    List<ProfessorDTO> listar() throws SQLException, ClassNotFoundException;    

}
