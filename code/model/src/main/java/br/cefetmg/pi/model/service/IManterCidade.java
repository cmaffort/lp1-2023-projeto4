package br.cefetmg.pi.model.service;

import br.cefetmg.pi.model.dto.Cidade;
import br.cefetmg.pi.model.exception.NegocioException;
import br.cefetmg.pi.model.dao.exception.PersistenciaException;
import java.util.List;

public interface IManterCidade {
    public Long cadastrar(Cidade cidade) throws PersistenciaException, NegocioException;
    public boolean alterar(Cidade cidade) throws PersistenciaException, NegocioException;
    public boolean excluir(Cidade cidade) throws PersistenciaException, NegocioException;
    public List<Cidade> pesquisarTodos() throws PersistenciaException;
    public Cidade pesquisarPorId(Long id) throws PersistenciaException;    
}
