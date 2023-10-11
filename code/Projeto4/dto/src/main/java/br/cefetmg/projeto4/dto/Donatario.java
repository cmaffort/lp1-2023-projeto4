/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.projeto4.dto;

/**
 *
 * @author lucas
 */
public class Donatario {
    private String nome;
    private String email;
    private String escola;
    private int posicao;
    private int serie;
    private String avaliacao;
    private String problemas;

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getEscola() {
        return escola;
    }

    public int getPosicao() {
        return posicao;
    }

    public int getSerie() {
        return serie;
    }


    public String getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getProblemas() {
        return problemas;
    }

    public void setProblemas(String problemas) {
        this.problemas = problemas;
    }
}
