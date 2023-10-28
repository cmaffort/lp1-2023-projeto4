package br.cefetmg.projeto4.dto;

public class Donatario {
    private String nome;
    private String CPF;
    private String email;
    private String escola;
    private int posicao;
    private String serie;
    private String enderecoCompleto;
    public Donatario(String nome, String CPF, String email, String escola, int posicao, String serie, String enderecoCompleto) {
        this.nome = nome;
        this.CPF = CPF;
        this.email = email;
        this.escola = escola;
        this.posicao = posicao;
        this.serie = serie;
        this.enderecoCompleto = enderecoCompleto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEscola() {
        return escola;
    }

    public void setEscola(String escola) {
        this.escola = escola;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }


    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }
    
    }
