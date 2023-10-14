package br.cefetmg.projeto4.dto;

public class Professor extends UsuarioDoSistema {
    
    public Professor(String nome, String CPF, String email) {
        super(nome, CPF, email);
    }
    
    private String departamento;
    private String email;
    
    public String getDepartamento () {
        return departamento;
    }
    
    public void setDepartamento (String departamento) {
        this.departamento = departamento;
    }
    
    
}