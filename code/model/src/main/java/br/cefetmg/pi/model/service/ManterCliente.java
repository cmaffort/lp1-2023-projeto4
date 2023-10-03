package br.cefetmg.pi.model.service;

import br.cefetmg.pi.model.dao.IClienteDAO;
import br.cefetmg.pi.model.dao.ClienteDAO;
import br.cefetmg.pi.model.dto.Cliente;
import br.cefetmg.pi.model.service.IManterCliente;
import br.cefetmg.pi.model.exception.NegocioException;
import br.cefetmg.pi.model.dao.exception.PersistenciaException;
import java.util.List;

public class ManterCliente implements IManterCliente {

    private IClienteDAO clienteDAO;
    
    public ManterCliente() {
        clienteDAO = new ClienteDAO();
    }
    
    @Override
    public Long cadastrar(Cliente cliente) throws PersistenciaException, NegocioException {
        
        if((cliente.getNome() == null) || (cliente.getNome().isEmpty()))
            throw new NegocioException("Obrigatório informar o nome.");
        
        if((cliente.getCpf() == null) || (cliente.getCpf().isEmpty()))
            throw new NegocioException("Obrigatório informar o CPF.");
                  
        if(cliente.getDataNasc() == null)
            throw new NegocioException("Obrigatório informar a data de nascimento.");
        
        if((cliente.getEndereco() == null) || (cliente.getEndereco().isEmpty()))
            throw new NegocioException("Obrigatório informar o endereço.");
        
        //TODO: DEMAIS TRATAMENTOS...
        
        Long result = clienteDAO.inserir(cliente);
        return result;
    }

    @Override
    public boolean alterar(Cliente cliente) throws PersistenciaException, NegocioException {
        
        if((cliente.getNome() == null) || (cliente.getNome().isEmpty()))
            throw new NegocioException("Obrigatório informar o nome.");
        
        if((cliente.getCpf() == null) || (cliente.getCpf().isEmpty()))
            throw new NegocioException("Obrigatório informar o CPF.");
                  
        if(cliente.getDataNasc() == null)
            throw new NegocioException("Obrigatório informar a data de nascimento.");
        
        if((cliente.getEndereco() == null) || (cliente.getEndereco().isEmpty()))
            throw new NegocioException("Obrigatório informar o endereço.");
                  
        boolean result = clienteDAO.atualizar(cliente);
        return result;
    }

    @Override
    public boolean excluir(Cliente cliente) throws PersistenciaException, NegocioException {
        
        boolean result = clienteDAO.delete(cliente);
        return result;       
    }

    @Override
    public List<Cliente> pesquisarTodos() throws PersistenciaException {
        List<Cliente> result = clienteDAO.listarTodos();
        return result;
    }

    @Override
    public Cliente pesquisarPorId(Long id) throws PersistenciaException {
        Cliente result = clienteDAO.consultarPorId(id);
        return result;       
    }    
}
