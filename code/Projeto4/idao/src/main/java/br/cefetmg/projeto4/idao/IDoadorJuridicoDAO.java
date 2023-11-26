
package br.cefetmg.projeto4.idao;
import br.cefetmg.projeto4.dto.DoadorJuridicoDTO;
import java.sql.SQLException;
import java.util.List;        /**
 *
 * @author lucas
 */

public interface IDoadorJuridicoDAO extends IUsuarioDAO {
    boolean inserir(DoadorJuridicoDTO doadorJuridico) throws SQLException, ClassNotFoundException;
    boolean alterar(DoadorJuridicoDTO doadorJuridico) throws SQLException, ClassNotFoundException;  
    List<DoadorJuridicoDTO> listar() throws SQLException, ClassNotFoundException;
}