package br.cefetmg.pi.model.service;

import br.cefetmg.pi.model.dto.Marca;
import br.cefetmg.pi.model.exception.NegocioException;
import br.cefetmg.pi.model.dao.exception.PersistenciaException;
import java.util.List;

public interface IManterMarca {
    public Long cadastrar(Marca marca) throws PersistenciaException, NegocioException;
    public boolean alterar(Marca marca) throws PersistenciaException, NegocioException;
    public boolean excluir(Marca marca) throws PersistenciaException, NegocioException;
    public List<Marca> pesquisarTodos() throws PersistenciaException;
    public Marca pesquisarPorId(Long id) throws PersistenciaException;    
}
