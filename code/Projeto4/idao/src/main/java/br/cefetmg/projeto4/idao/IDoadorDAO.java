package br.cefetmg.projeto4.idao;
import br.cefetmg.projeto4.dto.DoadorDTO;
import java.sql.SQLException;
import java.util.List;

public interface IDoadorDAO extends IUsuarioDAO {
    boolean inserir(DoadorDTO doador) throws SQLException, ClassNotFoundException;
    boolean alterar(DoadorDTO doador) throws SQLException, ClassNotFoundException;
    List<DoadorDTO> listar() throws SQLException, ClassNotFoundException;        
}