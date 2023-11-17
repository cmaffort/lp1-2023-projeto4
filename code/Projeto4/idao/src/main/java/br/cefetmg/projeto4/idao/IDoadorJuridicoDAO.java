/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
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