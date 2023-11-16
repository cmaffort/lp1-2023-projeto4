package br.cefetmg.projeto4.idao;

import java.sql.SQLException;
import java.util.List;

import br.cefetmg.projeto4.dto.MantecaoDTO;

public interface IMantecaoDAO {
    boolean inserir(MantecaoDTO computador) throws SQLException, ClassNotFoundException;
    boolean alterar(MantecaoDTO computador) throws SQLException, ClassNotFoundException;
    boolean remover(MantecaoDTO computador) throws SQLException, ClassNotFoundException;
    List<MantecaoDTO> listar() throws SQLException, ClassNotFoundException;    
}