package br.cefetmg.projeto4.dto;

public class Doacao {
   
    private int quantidade;
    private Computador computador;
    private String dataDeChegada;
    private String donatario;
    private String marca;
    private String modeloProcessador;
    private int quantidadeDeRAM;

    public Doacao(int quantidade, Computador computador, String dataDeChegada, String donatario, String marca, String modeloProcessador, int quantidadeRAM) {
        this.quantidade = quantidade;
        this.computador = computador;
        this.dataDeChegada = dataDeChegada;
        this.donatario = donatario;
        this.marca = marca;
        this.modeloProcessador = modeloProcessador;
        this.quantidadeDeRAM = quantidadeRAM;
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
