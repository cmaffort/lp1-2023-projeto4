package br.cefetmg.projeto4.idao;

import br.cefetmg.projeto4.dto.DoadorComputadorPessoaJuridica;
import java.sql.SQLException;
import java.util.List;

public interface IDoadorComputadorPessoaJuridicaDAO {
        boolean inserir(DoadorComputadorPessoaJuridica doadorComputadorPessoaJuridica) throws SQLException, ClassNotFoundException;
    boolean alterar(DoadorComputadorPessoaJuridica doadorComputadorPessoaJuridica) throws SQLException, ClassNotFoundException;
    boolean remover(DoadorComputadorPessoaJuridica doadorComputadorPessoaJuridica) throws SQLException, ClassNotFoundException;
    List<DoadorComputadorPessoaJuridica> listar() throws SQLException, ClassNotFoundException;    

}
