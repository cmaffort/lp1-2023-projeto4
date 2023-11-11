package br.cefetmg.projeto4.dto;
public class DoadorFisica {
    String nome;
    String email;
    String CPF;
    String senha;
    int computadoresDoados;

    public DoadorFisica(String nome, String CPF,  String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.CPF = CPF;
        this.senha = senha;
        this.computadoresDoados = 0;
    }
        public DoadorFisica(String nome, String CPF,  String email, String senha, int computadoresDoados) {
        this.nome = nome;
        this.email = email;
        this.CPF = CPF;
        this.senha = senha;
        this.computadoresDoados = 0;
    }


    public int getComputadoresDoados() {
        return computadoresDoados;
    }

    public void setComputadoresDoados(int computadoresDoados) {
        this.computadoresDoados = computadoresDoados;
    }
    public void aumentarComputadoresDoados(int computadoresDoados) {
        this.computadoresDoados += computadoresDoados;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
