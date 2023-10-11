package br.cefetmg.projeto4.dto;

import java.util.Queue;

public class Computador {
    private String dataDeChegada;
    private String modelo;
    private int quantidadeDeRAM;
    private int capacidadeDeArmazenamento;
    private String modeloProcessador;
    private String codigo;
    private String doador;
    private boolean estaParaDoacao;
    private boolean estaParaRetiradaDePecas;
    private Queue<String> problemas;
    private String donatario;
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
        return doador;
    }

    public boolean getEstaParaDoacao() {
        return estaParaDoacao;
    }

    public void setEstaParaDoacao(boolean estado) {
        estaParaDoacao = estado;
    }

    public boolean getEstaParaRetiradaDePecas() {
        return estaParaRetiradaDePecas;
    }

    public void setEstaParaRetiradaDePecas(boolean estado) {
        estaParaRetiradaDePecas = estado;
    }

    public String getProblemas() {
        if (problemas.isEmpty()) {
            return "Sem problemas";
        }
        return problemas.peek();
    }

    public void addProblemas(String problema) {
        problemas.add(problema);
    }

    public String getDonatario() {
        return donatario;
    }

    public void setDonatario(String donatario) {
        this.donatario = donatario;
    }
}
