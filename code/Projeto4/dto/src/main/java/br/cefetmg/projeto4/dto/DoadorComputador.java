package br.cefetmg.projeto4.dto;

public class DoadorComputador {
    private String nome;
    private String email;
    private int anoInicioDoacao;
    private String tipoPessoa; // "Física" ou "Jurídica"
    private String identificacao; // CPF ou CNPJ

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int anoInicioDoacao() {
        return anoInicioDoacao;
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public String getIdentificacao() {
        return identificacao;
    }
}
