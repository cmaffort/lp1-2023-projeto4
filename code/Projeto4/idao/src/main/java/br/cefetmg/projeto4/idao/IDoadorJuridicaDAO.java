/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.cefetmg.projeto4.idao;
import br.cefetmg.projeto4.dto.DoadorJuridica;
import java.sql.SQLException;
import java.util.List;
        /**
 *
 * @author lucas
 */
public interface IDoadorJuridicaDAO {
    boolean inserir(DoadorJuridica doadorJuridica) throws SQLException, ClassNotFoundException;
    boolean alterar(DoadorJuridica doadorJuridica) throws SQLException, ClassNotFoundException;
    boolean remover(DoadorJuridica doadorJuridica) throws SQLException, ClassNotFoundException;
    List<DoadorJuridica> listar() throws SQLException, ClassNotFoundException;        

}
