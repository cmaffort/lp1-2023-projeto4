package br.cefetmg.projeto4.dto;


public class ProfessorDTO extends UsuarioDTO  {
    private String departamento;

    public ProfessorDTO(String nome, String CPF, String email, String senha, String departamento) {
        this(nome, CPF, email, senha, null, departamento);
    }

    public ProfessorDTO(String nome, String CPF, String email, String senha, byte[] foto, String departamento) {
        super(nome, CPF, email, senha, Tipo.PROFESSOR, foto);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public ProfessorDTO safe() {
        return new ProfessorDTO(nome, codigo, email, null, foto, departamento);
    }
}