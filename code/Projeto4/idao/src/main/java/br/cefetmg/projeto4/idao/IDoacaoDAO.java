package br.cefetmg.projeto4.idao;

import br.cefetmg.projeto4.dto.Doacao;
import java.sql.SQLException;
import java.util.List;

public interface IDoacaoDAO {
    boolean inserir(Doacao doacao) throws SQLException, ClassNotFoundException;
    boolean alterar(Doacao doacao) throws SQLException, ClassNotFoundException;
    boolean remover(Doacao doacao) throws SQLException, ClassNotFoundException;
    List<Doacao> listar() throws SQLException, ClassNotFoundException;    

}
