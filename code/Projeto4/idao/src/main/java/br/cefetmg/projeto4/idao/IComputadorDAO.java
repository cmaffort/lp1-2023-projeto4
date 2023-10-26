package br.cefetmg.projeto4.idao;
import br.cefetmg.projeto4.dto.Computador;
import java.sql.SQLException;
import java.util.List;
public interface IComputadorDAO {
    boolean inserir(Computador computador) throws SQLException, ClassNotFoundException;
    boolean alterar(Computador Computador) throws SQLException, ClassNotFoundException;
    boolean remover(Computador Computador) throws SQLException, ClassNotFoundException;
    List<Computador> listar() throws SQLException, ClassNotFoundException;    
}
