package br.cefetmg.projeto4.idao;
import br.cefetmg.projeto4.dto.DoadorFisica;
import java.sql.SQLException;
import java.util.List;

public interface IDoadorFisicaDAO {
    boolean inserir(DoadorFisica doadorFisica) throws SQLException, ClassNotFoundException;
    boolean alterar(DoadorFisica doadorFisica) throws SQLException, ClassNotFoundException;
    boolean remover(DoadorFisica doadorFisica) throws SQLException, ClassNotFoundException;
    List<DoadorFisica> listar() throws SQLException, ClassNotFoundException;        
}
