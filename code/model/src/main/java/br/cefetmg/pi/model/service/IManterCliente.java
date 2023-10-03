package br.cefetmg.pi.model.service;

import br.cefetmg.pi.model.dto.Cliente;
import br.cefetmg.pi.model.exception.NegocioException;
import br.cefetmg.pi.model.dao.exception.PersistenciaException;
import java.util.List;

public interface IManterCliente {
    public Long cadastrar(Cliente cliente) throws PersistenciaException, NegocioException;
    public boolean alterar(Cliente cliente) throws PersistenciaException, NegocioException;
    public boolean excluir(Cliente cliente) throws PersistenciaException, NegocioException;
    public List<Cliente> pesquisarTodos() throws PersistenciaException;
    public Cliente pesquisarPorId(Long id) throws PersistenciaException;    
}
