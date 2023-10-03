package br.cefetmg.pi.model.service;

import br.cefetmg.pi.model.dao.ICategoriaDAO;
import br.cefetmg.pi.model.dao.CategoriaDAO;
import br.cefetmg.pi.model.dto.Categoria;
import br.cefetmg.pi.model.exception.NegocioException;
import br.cefetmg.pi.model.dao.exception.PersistenciaException;
import java.util.List;

public class ManterCategoria implements IManterCategoria {

    private ICategoriaDAO categoriaDAO;
    
    public ManterCategoria() {
        categoriaDAO = new CategoriaDAO();
    }
    
    @Override
    public Long cadastrar(Categoria categoria) throws PersistenciaException, NegocioException {
        
        if((categoria.getDescricao() == null) || (categoria.getDescricao().isEmpty()))
                throw new NegocioException("Obrigatório informar a descrição");
                  
        Long result = categoriaDAO.inserir(categoria);
        return result;
    }

    @Override
    public boolean alterar(Categoria categoria) throws PersistenciaException, NegocioException {
        
        if((categoria.getDescricao() == null) || (categoria.getDescricao().isEmpty()))
                throw new NegocioException("Obrigatório informar a descrição");
                  
        boolean result = categoriaDAO.atualizar(categoria);
        return result;
    }

    @Override
    public boolean excluir(Categoria categoria) throws PersistenciaException, NegocioException {
        
        boolean result = categoriaDAO.delete(categoria);
        return result;       
    }

    @Override
    public List<Categoria> pesquisarTodos() throws PersistenciaException {
        List<Categoria> result = categoriaDAO.listarTodos();
        return result;       
    }

    @Override
    public Categoria pesquisarPorId(Long id) throws PersistenciaException {
        Categoria result = categoriaDAO.consultarPorId(id);
        return result;       
    }    
}
