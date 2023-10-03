package br.cefetmg.pi.model.service;

import br.cefetmg.pi.model.dao.IUsuarioDAO;
import br.cefetmg.pi.model.dao.UsuarioDAO;
import br.cefetmg.pi.model.dto.Usuario;
import br.cefetmg.pi.model.service.IManterUsuario;
import br.cefetmg.pi.model.exception.NegocioException;
import br.cefetmg.pi.model.dao.exception.PersistenciaException;
import java.util.List;

public class ManterUsuario implements IManterUsuario {

    private IUsuarioDAO usuarioDAO;
    
    public ManterUsuario() {
        usuarioDAO = new UsuarioDAO();
    }
    
    @Override
    public Long cadastrar(Usuario usuario) throws PersistenciaException, NegocioException {
        
        if((usuario.getNome() == null) || (usuario.getNome().isEmpty()))
            throw new NegocioException("Obrigatório informar o nome.");
        
        //TODO: DEMAIS VERIFICAÇÕES
        
        Long result = usuarioDAO.inserir(usuario);
        return result;
    }

    @Override
    public boolean alterar(Usuario usuario) throws PersistenciaException, NegocioException {
        
        if((usuario.getNome() == null) || (usuario.getNome().isEmpty()))
            throw new NegocioException("Obrigatório informar o nome.");
        
        //TODO: DEMAIS VERIFICAÇÕES
                  
        boolean result = usuarioDAO.atualizar(usuario);
        return result;
    }

    @Override
    public boolean excluir(Usuario usuario) throws PersistenciaException, NegocioException {
        
        boolean result = usuarioDAO.delete(usuario);
        return result;       
    }

    @Override
    public List<Usuario> pesquisarTodos() throws PersistenciaException {
        List<Usuario> result = usuarioDAO.listarTodos();
        return result;
    }

    @Override
    public Usuario pesquisarPorId(Long id) throws PersistenciaException {
        Usuario result = usuarioDAO.consultarPorId(id);
        return result;       
    }    

    @Override
    public Usuario getUserLogin(String nome, String senha) throws PersistenciaException, NegocioException {
        Usuario result = usuarioDAO.consultarPorUsuarioSenha(nome, senha);
        return result;               
    }
}
