package br.cefetmg.pi.model.service;

import br.cefetmg.pi.model.dao.ICidadeDAO;
import br.cefetmg.pi.model.dao.CidadeDAO;
import br.cefetmg.pi.model.dto.Cidade;
import br.cefetmg.pi.model.service.IManterCidade;
import br.cefetmg.pi.model.exception.NegocioException;
import br.cefetmg.pi.model.dao.exception.PersistenciaException;
import java.util.List;

public class ManterCidade implements IManterCidade {

    private ICidadeDAO cidadeDAO;
    
    public ManterCidade() {
        cidadeDAO = new CidadeDAO();
    }
    
    @Override
    public Long cadastrar(Cidade cidade) throws PersistenciaException, NegocioException {
        
        if((cidade.getNome() == null) || (cidade.getNome().isEmpty()))
            throw new NegocioException("Obrigatório informar o nome.");
        
        if(cidade.getEstado().getId() == null)
            throw new NegocioException("Obrigatório informar o estado.");
                  
        Long result = cidadeDAO.inserir(cidade);
        return result;
    }

    @Override
    public boolean alterar(Cidade cidade) throws PersistenciaException, NegocioException {
        
       if((cidade.getNome() == null) || (cidade.getNome().isEmpty()))
            throw new NegocioException("Obrigatório informar o nome.");
        
        if(cidade.getEstado().getId() == null)
            throw new NegocioException("Obrigatório informar o estado.");
                  
        boolean result = cidadeDAO.atualizar(cidade);
        return result;
    }

    @Override
    public boolean excluir(Cidade cidade) throws PersistenciaException, NegocioException {
        
        boolean result = cidadeDAO.delete(cidade);
        return result;       
    }

    @Override
    public List<Cidade> pesquisarTodos() throws PersistenciaException {
        List<Cidade> result = cidadeDAO.listarTodos();
        return result;
    }

    @Override
    public Cidade pesquisarPorId(Long id) throws PersistenciaException {
        Cidade result = cidadeDAO.consultarPorId(id);
        return result;       
    }    
}
