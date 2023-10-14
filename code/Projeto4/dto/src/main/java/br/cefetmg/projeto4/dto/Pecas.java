package br.cefetmg.projeto4.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.TemporalQueries.localDate;

public class Pecas {
    
    private int quantidade;
    private String modelo;
    private String descricao;
    private LocalDate dataChegada;
    
    public String getDataChegada()
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        return dataChegada.format(formatter);
    }
    public int getQuantidade () {
        return quantidade;
    }
    
    public void setQuantidade (int quantidade) {
        this.quantidade = quantidade;
    }
    
    public String getModelo () {
        return modelo;
    }

    public void setModelo (String modelo) {
        this.modelo = modelo;
    }
    
    public String getDescricao () {
        return descricao;
    }
    
    public void setDescricao (String descricao) {
        this.descricao = descricao;
    }
}