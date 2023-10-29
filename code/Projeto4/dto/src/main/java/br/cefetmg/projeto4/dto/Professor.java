package br.cefetmg.projeto4.dto;


public class Professor  {
    String nome;
    String CPF;
    String email;
    String departamento;
    String senha;

    public Professor(String nome, String CPF, String email, String departamento, String senha) {
        this.nome = nome;
        this.CPF = CPF;
        this.email = "silvia@gmail.com";
        this.departamento = departamento;
        this.senha = senha;
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
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

 
    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
