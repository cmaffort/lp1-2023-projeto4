
package br.cefetmg.projeto4.idao;
import br.cefetmg.projeto4.dto.DoadorJuridicoDTO;
import java.sql.SQLException;   
/**
 *
 * @author lucas
 */

public interface IDoadorJuridicoDAO extends IDoadorDAO {
    boolean inserir(DoadorJuridicoDTO doadorJuridico) throws SQLException, ClassNotFoundException;
    boolean alterar(DoadorJuridicoDTO doadorJuridico) throws SQLException, ClassNotFoundException; 
}