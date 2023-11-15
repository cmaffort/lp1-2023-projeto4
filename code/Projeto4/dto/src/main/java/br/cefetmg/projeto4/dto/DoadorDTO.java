package br.cefetmg.projeto4.dto;

public class DoadorDTO extends UsuarioDTO {
    protected enum TipoDoador {
        FISICO, JURIDICO;
    }

    private int computadoresDoados;
    private TipoDoador tipo;

    public DoadorDTO(String nome, String CPF,  String email, String senha) {
        this(nome, CPF, email, senha, 0);
    }

    public DoadorDTO(String nome, String CPF,  String email, String senha, int computadoresDoados) {
        this(nome, CPF, email, senha, computadoresDoados, TipoDoador.FISICO);
    }

    protected DoadorDTO(String nome, String codigo,  String email, String senha, int computadoresDoados, TipoDoador tipo) {
        super(nome, codigo, tipo == TipoDoador.FISICO ? TipoCodigo.CPF : TipoCodigo.CNPJ, email, senha, Tipo.DOADOR);
        this.computadoresDoados = computadoresDoados;
        this.tipo = tipo;
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

    public String getTipoDoador() {
        return tipo.name();
    }

    public void setTipoDoador(TipoDoador tipo) {
        this.tipo = tipo;
    }
}