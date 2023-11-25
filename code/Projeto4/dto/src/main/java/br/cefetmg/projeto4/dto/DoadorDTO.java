package br.cefetmg.projeto4.dto;


public class DoadorDTO extends UsuarioDTO {
    protected enum TipoDoador {
        FISICO, JURIDICO;
    }

    protected int computadoresDoados;
    private TipoDoador tipo;

    public DoadorDTO(String nome, String CPF,  String email, String senha) {
        this(nome, CPF, email, senha, null);
    }

    public DoadorDTO(String nome, String CPF,  String email, String senha, String foto) {
        this(nome, CPF, email, senha, foto, 0);
    }

    public DoadorDTO(String nome, String CPF,  String email, String senha, int computadoresDoados) {
        this(nome, CPF, email, senha, null, computadoresDoados);
    }

    public DoadorDTO(String nome, String CPF,  String email, String senha, String foto, int computadoresDoados) {
        this(nome, CPF, email, senha, foto, computadoresDoados, TipoDoador.FISICO);
    }

    public DoadorDTO(String nome, String codigo,  String email, String senha, String foto, int computadoresDoados, String tipo) {
        this(nome, codigo, email, senha, foto, computadoresDoados, TipoDoador.valueOf(tipo));
    }

    protected DoadorDTO(String nome, String codigo,  String email, String senha, String foto, int computadoresDoados, TipoDoador tipo) {
        super(nome, codigo, tipo == TipoDoador.FISICO ? TipoCodigo.CPF : TipoCodigo.CNPJ, email, senha, Tipo.DOADOR, foto);
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

    @Override
    public DoadorDTO safe() {
        return new DoadorDTO(nome, codigo, email, null, foto, computadoresDoados, tipo);
    }
}