package br.cefetmg.pi.model.service;

import br.cefetmg.pi.model.dto.Modelo;
import br.cefetmg.pi.model.exception.NegocioException;
import br.cefetmg.pi.model.dao.exception.PersistenciaException;
import java.util.List;

public interface IManterModelo {
    public Long cadastrar(Modelo modelo) throws PersistenciaException, NegocioException;
    public boolean alterar(Modelo modelo) throws PersistenciaException, NegocioException;
    public boolean excluir(Modelo modelo) throws PersistenciaException, NegocioException;
    public List<Modelo> pesquisarTodos() throws PersistenciaException;
    public Modelo pesquisarPorId(Long id) throws PersistenciaException;    
}
