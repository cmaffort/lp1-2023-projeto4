package br.cefetmg.pi.model.service;

import br.cefetmg.pi.model.dao.IModeloDAO;
import br.cefetmg.pi.model.dao.ModeloDAO;
import br.cefetmg.pi.model.dto.Modelo;
import br.cefetmg.pi.model.service.IManterModelo;
import br.cefetmg.pi.model.exception.NegocioException;
import br.cefetmg.pi.model.dao.exception.PersistenciaException;
import java.util.List;

public class ManterModelo implements IManterModelo {

    private IModeloDAO modeloDAO;
    
    public ManterModelo() {
        modeloDAO = new ModeloDAO();
    }
    
    @Override
    public Long cadastrar(Modelo modelo) throws PersistenciaException, NegocioException {
        
        if((modelo.getDescricao() == null) || (modelo.getDescricao().isEmpty()))
            throw new NegocioException("Obrigatório informar o nome.");

        Long result = modeloDAO.inserir(modelo);
        return result;
    }

    @Override
    public boolean alterar(Modelo modelo) throws PersistenciaException, NegocioException {
        
       if((modelo.getDescricao() == null) || (modelo.getDescricao().isEmpty()))
            throw new NegocioException("Obrigatório informar o nome.");
                          
        boolean result = modeloDAO.atualizar(modelo);
        return result;
    }

    @Override
    public boolean excluir(Modelo modelo) throws PersistenciaException, NegocioException {
        
        boolean result = modeloDAO.delete(modelo);
        return result;       
    }

    @Override
    public List<Modelo> pesquisarTodos() throws PersistenciaException {
        List<Modelo> result = modeloDAO.listarTodos();
        return result;
    }

    @Override
    public Modelo pesquisarPorId(Long id) throws PersistenciaException {
        Modelo result = modeloDAO.consultarPorId(id);
        return result;       
    }    
}
