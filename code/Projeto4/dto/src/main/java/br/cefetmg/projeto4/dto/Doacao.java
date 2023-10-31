package br.cefetmg.projeto4.dto;

public class Doacao {
   
    private int quantidade;
    private Computador computador;
    private String dataDeChegada;
    private String donatario;
    private String marca;
    private String modeloProcessador;
    private int quantidadeDeRAM;
    private String doador;

    public Doacao(int quantidade, Computador computador) {
        this.quantidade = quantidade;
        this.computador = computador;
    }
    
    public Doacao(String doador, String dataDeChegada, String donatario, String marca, String modeloProcessador, int quantidadeDeRAM) {
    
    this.dataDeChegada = dataDeChegada;
    this.donatario = donatario; 
    this.marca = marca;
    this.modeloProcessador = modeloProcessador;
    this.quantidadeDeRAM = quantidadeDeRAM;
    this.doador = doador;
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
