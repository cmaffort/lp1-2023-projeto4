package br.cefetmg.projeto4.idao;
import br.cefetmg.projeto4.dto.ComputadorDTO;
import java.sql.SQLException;
import java.util.List;
public interface IComputadorDAO {
    boolean inserir(ComputadorDTO computador) throws SQLException, ClassNotFoundException;
    boolean alterar(ComputadorDTO computador) throws SQLException, ClassNotFoundException;
    boolean remover(ComputadorDTO computador) throws SQLException, ClassNotFoundException;
    List<ComputadorDTO> listar() throws SQLException, ClassNotFoundException;    
}
