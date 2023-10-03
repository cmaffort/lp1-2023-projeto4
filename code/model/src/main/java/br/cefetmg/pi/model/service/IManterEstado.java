package br.cefetmg.pi.model.service;

import br.cefetmg.pi.model.dto.Estado;
import br.cefetmg.pi.model.exception.NegocioException;
import br.cefetmg.pi.model.dao.exception.PersistenciaException;
import java.util.List;

public interface IManterEstado {
    public Long cadastrar(Estado estado) throws PersistenciaException, NegocioException;
    public boolean alterar(Estado estado) throws PersistenciaException, NegocioException;
    public boolean excluir(Estado estado) throws PersistenciaException, NegocioException;
    public List<Estado> pesquisarTodos() throws PersistenciaException;
    public Estado pesquisarPorId(Long id) throws PersistenciaException;    
    public Estado pesquisarPorSigla(String sigla) throws PersistenciaException; 
}
