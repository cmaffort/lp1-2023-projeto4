package br.cefetmg.projeto4.idao;

public interface IProfessorDAO extends IUsuarioDoSistemaDAO{
    public String getDepartamento();
    public int getEntradaNoProjeto();
}
