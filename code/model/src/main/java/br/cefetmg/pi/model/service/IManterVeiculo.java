package br.cefetmg.pi.model.service;

import br.cefetmg.pi.model.dto.Veiculo;
import br.cefetmg.pi.model.exception.NegocioException;
import br.cefetmg.pi.model.dao.exception.PersistenciaException;
import java.util.List;

public interface IManterVeiculo {
    public Long cadastrar(Veiculo veiculo) throws PersistenciaException, NegocioException;
    public boolean alterar(Veiculo veiculo) throws PersistenciaException, NegocioException;
    public boolean excluir(Veiculo veiculo) throws PersistenciaException, NegocioException;
    public List<Veiculo> pesquisarTodos() throws PersistenciaException;
    public Veiculo pesquisarPorId(Long id) throws PersistenciaException;   
    public Veiculo pesquisarPorPlaca(String placa) throws PersistenciaException;   
}
