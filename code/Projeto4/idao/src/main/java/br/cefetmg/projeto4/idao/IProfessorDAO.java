package br.cefetmg.projeto4.idao;

import br.cefetmg.projeto4.dto.Professor;
import java.sql.SQLException;
import java.util.List;

public interface IProfessorDAO {
    boolean inserir(Professor professor) throws SQLException, ClassNotFoundException;
    boolean alterar(Professor professor) throws SQLException, ClassNotFoundException;
    boolean remover(Professor professor) throws SQLException, ClassNotFoundException;
    List<Professor> listar() throws SQLException, ClassNotFoundException;    

}
