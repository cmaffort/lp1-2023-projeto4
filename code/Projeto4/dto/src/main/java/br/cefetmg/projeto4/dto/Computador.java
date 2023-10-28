package br.cefetmg.projeto4.dto;


public class Computador {
    private String codigo;
    private String doador;
    private String dataDeChegada;
    private String donatario;
    private String marca;
    private String modeloProcessador;
    private int quantidadeDeRAM;
    public Computador(String codigo, String doador, String dataDeChegada, String donatario, String marca, String modeloProcessador, int quantidadeDeRAM) {
        this.codigo = codigo; 
        this.doador = doador;
        this.dataDeChegada = dataDeChegada;
        this.donatario = donatario;
        this.marca = marca;
        this.modeloProcessador = modeloProcessador;
        this.quantidadeDeRAM = quantidadeDeRAM;
    }

    public Computador() {
        this.marca = "Desconhecida";
        this.doador = null;
    }
    // Métodos "get" para obter os valores dos campos
    public String getCodigo() {
        return codigo;
    }

    public String getDoador() {
        return doador;
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

    public String getModeloProcessador() {
        return modeloProcessador;
    }

    public int getQuantidadeDeRAM() {
        return quantidadeDeRAM;
    }

    // Métodos "set" para definir os valores dos campos
    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
