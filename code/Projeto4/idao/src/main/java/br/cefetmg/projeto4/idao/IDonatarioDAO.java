package br.cefetmg.projeto4.idao;

import br.cefetmg.projeto4.dto.Donatario;
import java.sql.SQLException;
import java.util.List;

public interface IDonatarioDAO  {
    boolean inserir(Donatario donatario) throws SQLException, ClassNotFoundException;
    boolean alterar(Donatario donatario) throws SQLException, ClassNotFoundException;
    boolean remover(Donatario donatario) throws SQLException, ClassNotFoundException;
    List<Donatario> listar() throws SQLException, ClassNotFoundException;    
}
