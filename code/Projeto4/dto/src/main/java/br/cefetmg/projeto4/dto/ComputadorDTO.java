package br.cefetmg.projeto4.dto;


public class ComputadorDTO {
    private String doador;
    private String dataDeChegada;
    private String donatario;
    private String marca;
    private String modeloProcessador;
    private int quantidadeDeRAM;
    
    public ComputadorDTO(String doador, String dataDeChegada, String donatario, String marca, String modeloProcessador, int quantidadeDeRAM) {
        this.doador = doador;
        this.dataDeChegada = dataDeChegada;
        this.donatario = donatario;
        this.marca = marca;
        this.modeloProcessador = modeloProcessador;
        this.quantidadeDeRAM = quantidadeDeRAM;
    }

    public ComputadorDTO() {
        this.marca = "Desconhecida";
        this.doador = null;
    }
    
    // Métodos "get" para obter os valores dos campos

    public ComputadorDTO(String dataDeChegada, String marca, int quantidadeDeRAM) {
        this.dataDeChegada = dataDeChegada;
        this.marca = marca;
        this.quantidadeDeRAM = quantidadeDeRAM;
    }
    

    public String getDataDeChegada() {
        return dataDeChegada;
    }

    public String getDonatario() {
        return donatario;
    }

    public String getMarca() {
        return marca;
    }
    
    public String getDoador() {
        return doador;
    }

    public String getModeloProcessador() {
        return modeloProcessador;
    }

    public int getQuantidadeDeRAM() {
        return quantidadeDeRAM;
    }

    public void setDoador(String doador) {
        this.doador = doador;
    }

    public void setDataDeChegada(String dataDeChegada) {
        this.dataDeChegada = dataDeChegada;
    }

    public void setDonatario(String donatario) {
        this.donatario = donatario;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModeloProcessador(String modeloProcessador) {
        this.modeloProcessador = modeloProcessador;
    }

    public void setQuantidadeDeRAM(int quantidadeDeRAM) {
        this.quantidadeDeRAM = quantidadeDeRAM;
    }
}
