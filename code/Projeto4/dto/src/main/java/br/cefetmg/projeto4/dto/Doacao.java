package br.cefetmg.projeto4.dto;

public class Doacao {
   
    private int quantidade;
    private Computador computador;

    public Doacao(int quantidade, Computador computador) {
        this.quantidade = quantidade;
        this.computador = computador;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Computador getComputador() {
        return computador;
    }

    public void setComputador(Computador computador) {
        this.computador = computador;
    }
    
}
