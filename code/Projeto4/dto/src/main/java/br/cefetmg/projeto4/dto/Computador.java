package br.cefetmg.projeto4.dto;

import java.util.Queue;
enum EstadoComputador{
    DISPONIVEL("Disponível"),
    DOADO("Doado"),
    MANUTENCAO("Em manutenção"),
    RETIRADADEPECAS("Retirada de Peças");
    private String estado;
    EstadoComputador(String estado){
        this.estado = estado;
    }
    public String getEstado(){
        return estado;
    }
}
public class Computador {
    
    private String dataDeChegada;
    private String modelo;
    private int quantidadeDeRAM;
    private int capacidadeDeArmazenamento;
    private String modeloProcessador;
    private String codigo;
    private DoadorComputador doador;
    private EstadoComputador estado;
    private Queue<String> problemas;
    private Donatario donatario;
    public Computador()
    {
        this.estado = EstadoComputador.MANUTENCAO;
    }
    public String getDataDeChegada() {
        return dataDeChegada;
    }

    public String getModelo() {
        return modelo;
    }

    public int getQuantidadeDeRAM() {
        return quantidadeDeRAM;
    }

    public int getCapacidadeDeArmazenamento() {
        return capacidadeDeArmazenamento;
    }

    public String getModeloProcessador() {
        return modeloProcessador;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDoador() {
        return doador.getNome();
    }  

    public void addProblemas(String problema) {
        problemas.add(problema);
    }

    public String getDonatario() {
        return donatario.getNome();
    }

    public void setDonatario(Donatario donatario) {
        this.donatario = donatario;
    }
}
