package br.cefetmg.projeto4.dto;


public class DonatarioDTO extends UsuarioDTO {
    private String escola;
    private int posicao;
    private int serie;

    public DonatarioDTO(String nome, String CPF, String email, String senha, String escola, int serie) {
        this(nome, CPF, email, senha, null, escola, serie);
    }

    public DonatarioDTO(String nome, String CPF, String email, String senha, byte[] foto, String escola, int serie) {
        this(nome, CPF, email, senha, foto, escola, 0, serie);
    }

    public DonatarioDTO(String nome, String CPF, String email, String senha, String escola, int posicao, int serie) {
        this(nome, CPF, email, senha, null, escola, posicao, serie);
    }

    public DonatarioDTO(String nome, String CPF, String email, String senha, byte[] foto, String escola, int posicao, int serie) {
        super(nome, CPF, email, senha, foto);
        this.escola = escola;
        this.posicao = posicao;
        this.serie = serie;
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

    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    @Override
    public DonatarioDTO safe() {
        return new DonatarioDTO(nome, codigo, email, null, foto, escola, posicao, serie);
    }
}