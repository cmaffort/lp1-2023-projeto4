package br.cefetmg.projeto4.dto;

public class Donatario {
    private String nome;
    private String email;
    private String escola;
    private int posicao;
    private int codigo;
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
