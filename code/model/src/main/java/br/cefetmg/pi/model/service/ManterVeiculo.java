package br.cefetmg.pi.model.service;

import br.cefetmg.pi.model.dao.IVeiculoDAO;
import br.cefetmg.pi.model.dao.VeiculoDAO;
import br.cefetmg.pi.model.dto.Veiculo;
import br.cefetmg.pi.model.service.IManterVeiculo;
import br.cefetmg.pi.model.exception.NegocioException;
import br.cefetmg.pi.model.dao.exception.PersistenciaException;
import java.util.List;

public class ManterVeiculo implements IManterVeiculo {

    private IVeiculoDAO veiculoDAO;
    
    public ManterVeiculo() {
        veiculoDAO = new VeiculoDAO();
    }
    
    @Override
    public Long cadastrar(Veiculo veiculo) throws PersistenciaException, NegocioException {
        
        if((veiculo.getPlaca() == null) || (veiculo.getPlaca().isEmpty()))
            throw new NegocioException("Obrigatório informar o nome.");
        
        //TODO: demais validações
        
        Long result = veiculoDAO.inserir(veiculo);
        return result;
    }

    @Override
    public boolean alterar(Veiculo veiculo) throws PersistenciaException, NegocioException {
        
        if((veiculo.getPlaca() == null) || (veiculo.getPlaca().isEmpty()))
            throw new NegocioException("Obrigatório informar o nome.");
        
        //TODO: demais validações
                  
        boolean result = veiculoDAO.atualizar(veiculo);
        return result;
    }

    @Override
    public boolean excluir(Veiculo veiculo) throws PersistenciaException, NegocioException {
        
        boolean result = veiculoDAO.delete(veiculo);
        return result;       
    }

    @Override
    public List<Veiculo> pesquisarTodos() throws PersistenciaException {
        List<Veiculo> result = veiculoDAO.listarTodos();
        return result;
    }

    @Override
    public Veiculo pesquisarPorId(Long id) throws PersistenciaException {
        Veiculo result = veiculoDAO.consultarPorId(id);
        return result;       
    }    

    @Override
    public Veiculo pesquisarPorPlaca(String placa) throws PersistenciaException {
        Veiculo result = veiculoDAO.consultarPorPlaca(placa);
        return  result;
    }
}
