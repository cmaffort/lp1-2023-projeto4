package br.cefetmg.projeto4.dto;

public class DoadorJuridica {
        private String nome;
        private String endereco;
        private String CNPJ;
        private String email;
        private String senha;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public DoadorJuridica(String nome, String endereco, String CNPJ, String email, String senha) {
        this.nome = nome;
        this.endereco = endereco;
        this.CNPJ = CNPJ;
        this.email = email;
        this.senha = senha;
    }
}
