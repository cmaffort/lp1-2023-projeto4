package br.cefetmg.pi.model.service;

import br.cefetmg.pi.model.dto.VeiculoCliente;
import br.cefetmg.pi.model.exception.NegocioException;
import br.cefetmg.pi.model.dao.exception.PersistenciaException;
import java.util.List;

public interface IManterVeiculoCliente {
    public Long cadastrar(VeiculoCliente veiculoCliente) throws PersistenciaException, NegocioException;
    public boolean alterar(VeiculoCliente veiculoCliente) throws PersistenciaException, NegocioException;
    public boolean excluir(VeiculoCliente veiculoCliente) throws PersistenciaException, NegocioException;
    public List<VeiculoCliente> pesquisarTodos() throws PersistenciaException;
    public VeiculoCliente pesquisarPorId(Long id) throws PersistenciaException;    
}
