package br.cefetmg.projeto4.dto;

public class SolicitacaoReparo {
    
    private Computador computador;
    private String dataDeDoacao;
    private String especificacoes;
    
    public SolicitacaoReparo (Computador computador, String dataDeDoacao, String especificacoes) {
        this.computador = computador ;
        this.dataDeDoacao = dataDeDoacao ;
        this.especificacoes = especificacoes;
    }
    
    public Computador getComputador () {
        return computador;
    } 
    
    public void setComputador (Computador computador) {
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
