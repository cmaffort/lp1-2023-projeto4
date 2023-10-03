package br.cefetmg.pi.model.service;

import br.cefetmg.pi.model.dao.IVeiculoClienteDAO;
import br.cefetmg.pi.model.dao.VeiculoClienteDAO;
import br.cefetmg.pi.model.dto.VeiculoCliente;
import br.cefetmg.pi.model.service.IManterVeiculoCliente;
import br.cefetmg.pi.model.exception.NegocioException;
import br.cefetmg.pi.model.dao.exception.PersistenciaException;
import java.util.List;

public class ManterVeiculoCliente implements IManterVeiculoCliente {

    private IVeiculoClienteDAO veiculoClienteDAO;
    
    public ManterVeiculoCliente() {
        veiculoClienteDAO = new VeiculoClienteDAO();
    }
    
    @Override
    public Long cadastrar(VeiculoCliente veiculoCliente) throws PersistenciaException, NegocioException {
                
        if(veiculoCliente.getCliente().getId() == null)
            throw new NegocioException("Obrigatório informar o cliente.");

        if(veiculoCliente.getVeiculo().getId() == null)
            throw new NegocioException("Obrigatório informar o veículo.");
        
        Long result = veiculoClienteDAO.inserir(veiculoCliente);
        return result;
    }

    @Override
    public boolean alterar(VeiculoCliente veiculoCliente) throws PersistenciaException, NegocioException {
        
        if(veiculoCliente.getCliente().getId() == null)
            throw new NegocioException("Obrigatório informar o cliente.");

        if(veiculoCliente.getVeiculo().getId() == null)
            throw new NegocioException("Obrigatório informar o veículo.");
                  
        boolean result = veiculoClienteDAO.atualizar(veiculoCliente);
        return result;
    }

    @Override
    public boolean excluir(VeiculoCliente veiculoCliente) throws PersistenciaException, NegocioException {
        
        boolean result = veiculoClienteDAO.delete(veiculoCliente);
        return result;       
    }

    @Override
    public List<VeiculoCliente> pesquisarTodos() throws PersistenciaException {
        List<VeiculoCliente> result = veiculoClienteDAO.listarTodos();
        return result;
    }

    @Override
    public VeiculoCliente pesquisarPorId(Long id) throws PersistenciaException {
        VeiculoCliente result = veiculoClienteDAO.consultarPorId(id);
        return result;       
    }    
}
