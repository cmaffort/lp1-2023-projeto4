package br.cefetmg.projeto4.dto;

public class DoacaoDTO {
   
    private int quantidade;
    private ComputadorDTO computador;
    private String dataDeChegada;
    private String donatario;
    private String marca;
    private String modeloProcessador;
    private int quantidadeDeRAM;
    private String doador;

    public DoacaoDTO(int quantidade, ComputadorDTO computador) {
        this.quantidade = quantidade;
        this.computador = computador;
    }
    public DoacaoDTO(String marca, int quantidadeDeRAM) {
        this.marca = marca;
        this.quantidadeDeRAM = quantidadeDeRAM;
    }

    public DoacaoDTO(String doador, String dataDeChegada, String donatario, String marca, String modeloProcessador, int quantidadeDeRAM) {
    
    this.dataDeChegada = dataDeChegada;
    this.donatario = donatario; 
    this.marca = marca;
    this.modeloProcessador = modeloProcessador;
    this.quantidadeDeRAM = quantidadeDeRAM;
    this.doador = doador;
    }        

    public ComputadorDTO getComputador() {
        return computador;
    }

    public String getDataDeChegada() {
        return computador.getDataDeChegada();
    }

    public String getDonatario() {
        return donatario;
    }

    public String getMarca() {
        return marca;
    }

    public String getModeloProcessador() {
        return modeloProcessador;
    }

    public int getQuantidadeDeRAM() {
        return computador.getQuantidadeDeRAM();
    }

    public String getDoador() {
        return computador.getDoador();
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getMarcaComputador() {
        return computador.getMarca();
    }

    public void setComputador(ComputadorDTO computador) {
        this.computador = computador;
    }
    
}