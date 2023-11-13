package br.cefetmg.projeto4.dto;

public class SolicitacaoReparoDTO {
    
    private ComputadorDTO computador;
    private String dataDeDoacao;
    private String especificacoes;
    private EstadoManutencao manutencao;
    
    public SolicitacaoReparoDTO (ComputadorDTO computador, String dataDeDoacao, String especificacoes) {
        this.computador = computador ;
        this.dataDeDoacao = dataDeDoacao ;
        this.especificacoes = especificacoes;
    }
    
    public SolicitacaoReparoDTO () {}
    
    public enum EstadoManutencao {
 
    FALTANDO_PECAS ,
    MAL_FUNCIONAMENTO ,
    OUTRO;
    
    }
    
     public Enum getManutencao () {
    
        return manutencao;
    }
    
     public void setManutencao (EstadoManutencao manutencao) {
   
       this.manutencao = manutencao;
   } 
    
    
    public ComputadorDTO getComputador () {
        return computador;
    } 
    
    public void setComputador (ComputadorDTO computador) {
        this.computador = computador;
    }
    
    public String getDataDeDoacao () {
        return dataDeDoacao;
    }

    public void setDataDeDoacao () {
        this.dataDeDoacao = dataDeDoacao;
    }
    
    public String getEspecificacoes () {
        return especificacoes;
    }    
    
    public void seteEspecificacoes () {
        this.especificacoes = especificacoes;
    }    
        
}
