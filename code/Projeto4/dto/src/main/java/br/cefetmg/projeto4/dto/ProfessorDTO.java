package br.cefetmg.projeto4.dto;


public class ProfessorDTO extends UsuarioDTO  {
    private String departamento;

    public ProfessorDTO(String nome, String CPF, String email, String senha, String departamento) {
        super(nome, CPF, email, senha, Tipo.PROFESSOR);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}