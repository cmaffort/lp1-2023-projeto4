package br.cefetmg.projeto4.idao;

import br.cefetmg.projeto4.dto.DoadorComputadorPessoaFisica;
import java.sql.SQLException;
import java.util.List;

public interface IDoadorComputadorPessoaFisicaDAO {
        boolean inserir(DoadorComputadorPessoaFisica doadorComputadorPessoaFisica) throws SQLException, ClassNotFoundException;
    boolean alterar(DoadorComputadorPessoaFisica doadorComputadorPessoaFisica) throws SQLException, ClassNotFoundException;
    boolean remover(DoadorComputadorPessoaFisica doadorComputadorPessoaFisica) throws SQLException, ClassNotFoundException;
    List<DoadorComputadorPessoaFisica> listar() throws SQLException, ClassNotFoundException;    

}
