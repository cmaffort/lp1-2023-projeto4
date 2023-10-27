package br.cefetmg.projeto4.dto;

import java.util.Queue;
public class Computador {
    
    private String dataDeChegada;
    private final String marca;
    private int quantidadeDeRAM;
    private int capacidadeDeArmazenamento;
    private String modeloProcessador;
    private String codigo;
    private final DoadorComputadorPessoaFisica doador;
 //   private EstadoComputador estado;
    private Queue<String> problemas;
    private Donatario donatario;
    public Computador(String marca, int quantidadeDeRAM,  int capacidadeDeArmazenamento, Queue<String> problemas, DoadorComputadorPessoaFisica doador)
    {
   //     this.estado = EstadoComputador.NAO_RECEBIDO;
        this.marca = marca;
        this.quantidadeDeRAM = quantidadeDeRAM;
        this.capacidadeDeArmazenamento = capacidadeDeArmazenamento;
        this.problemas = problemas;
        this.doador = doador;
        
    }
    public String getDataDeChegada() {
        return dataDeChegada;
    }

    public String getMarca() {
        return marca;
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
    public void setRam(int ram)
    {
        this.quantidadeDeRAM = ram;
    }
    public void setCapacidadeDeArmazenamento(int armazenamento)
    {
        this.capacidadeDeArmazenamento = armazenamento;
    }

}
