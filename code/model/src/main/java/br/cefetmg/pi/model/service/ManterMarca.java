package br.cefetmg.pi.model.service;

import br.cefetmg.pi.model.dao.IMarcaDAO;
import br.cefetmg.pi.model.dao.MarcaDAO;
import br.cefetmg.pi.model.dto.Marca;
import br.cefetmg.pi.model.service.IManterMarca;
import br.cefetmg.pi.model.exception.NegocioException;
import br.cefetmg.pi.model.dao.exception.PersistenciaException;
import java.util.List;

public class ManterMarca implements IManterMarca {

    private IMarcaDAO marcaDAO;
    
    public ManterMarca() {
        marcaDAO = new MarcaDAO();
    }
    
    @Override
    public Long cadastrar(Marca marca) throws PersistenciaException, NegocioException {
        
        if((marca.getDescricao()== null) || (marca.getDescricao().isEmpty()))
            throw new NegocioException("Obrigatório informar a descrição.");
                          
        Long result = marcaDAO.inserir(marca);
        return result;
    }

    @Override
    public boolean alterar(Marca marca) throws PersistenciaException, NegocioException {
        
       if((marca.getDescricao() == null) || (marca.getDescricao().isEmpty()))
            throw new NegocioException("Obrigatório informar a descrição.");
                          
        boolean result = marcaDAO.atualizar(marca);
        return result;
    }

    @Override
    public boolean excluir(Marca marca) throws PersistenciaException, NegocioException {
        
        boolean result = marcaDAO.delete(marca);
        return result;       
    }

    @Override
    public List<Marca> pesquisarTodos() throws PersistenciaException {
        List<Marca> result = marcaDAO.listarTodos();
        return result;
    }

    @Override
    public Marca pesquisarPorId(Long id) throws PersistenciaException {
        Marca result = marcaDAO.consultarPorId(id);
        return result;       
    }    
}
