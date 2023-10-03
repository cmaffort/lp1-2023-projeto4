package br.cefetmg.pi.model.service;

import br.cefetmg.pi.model.dao.IEstadoDAO;
import br.cefetmg.pi.model.dao.EstadoDAO;
import br.cefetmg.pi.model.dto.Estado;
import br.cefetmg.pi.model.service.IManterEstado;
import br.cefetmg.pi.model.exception.NegocioException;
import br.cefetmg.pi.model.dao.exception.PersistenciaException;
import java.util.List;

public class ManterEstado implements IManterEstado {

    private IEstadoDAO estadoDAO;
    
    public ManterEstado() {
        estadoDAO = new EstadoDAO();
    }
    
    @Override
    public Long cadastrar(Estado estado) throws PersistenciaException, NegocioException {
        
        if((estado.getNome() == null) || (estado.getNome().isEmpty()))
            throw new NegocioException("Obrigatório informar o nome.");
        
        if((estado.getSigla() == null) || (estado.getSigla().isEmpty()))
            throw new NegocioException("Obrigatório informar a sigla.");
                  
        Long result = estadoDAO.inserir(estado);
        return result;
    }

    @Override
    public boolean alterar(Estado estado) throws PersistenciaException, NegocioException {
        
        if((estado.getNome() == null) || (estado.getNome().isEmpty()))
            throw new NegocioException("Obrigatório informar o nome.");
        
        if((estado.getSigla() == null) || (estado.getSigla().isEmpty()))
            throw new NegocioException("Obrigatório informar a sigla.");
                  
        boolean result = estadoDAO.atualizar(estado);
        return result;
    }

    @Override
    public boolean excluir(Estado estado) throws PersistenciaException, NegocioException {
        
        boolean result = estadoDAO.delete(estado);
        return result;       
    }

    @Override
    public List<Estado> pesquisarTodos() throws PersistenciaException {
        List<Estado> result = estadoDAO.listarTodos();
        return result;
    }

    @Override
    public Estado pesquisarPorId(Long id) throws PersistenciaException {
        Estado result = estadoDAO.consultarPorId(id);
        return result;
    }    

    @Override
    public Estado pesquisarPorSigla(String sigla) throws PersistenciaException {
        Estado result = estadoDAO.consultarPorSigla(sigla);
        return result;        
    }
}
