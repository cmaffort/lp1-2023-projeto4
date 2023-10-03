package br.cefetmg.pi.model.service;

import br.cefetmg.pi.model.dto.Categoria;
import br.cefetmg.pi.model.exception.NegocioException;
import br.cefetmg.pi.model.dao.exception.PersistenciaException;
import java.util.List;

public interface IManterCategoria {
    
    public Long cadastrar(Categoria categoria) throws PersistenciaException, NegocioException;
    public boolean alterar(Categoria categoria) throws PersistenciaException, NegocioException;
    public boolean excluir(Categoria categoria) throws PersistenciaException, NegocioException;
    public List<Categoria> pesquisarTodos() throws PersistenciaException;
    public Categoria pesquisarPorId(Long id) throws PersistenciaException;
    
}
