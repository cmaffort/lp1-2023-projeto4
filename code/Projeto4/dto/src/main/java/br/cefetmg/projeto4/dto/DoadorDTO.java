package br.cefetmg.projeto4.dto;

public class DoadorDTO extends UsuarioDTO {
    protected enum TipoDoador {
        FISICO("Fisico"), 
        JURIDICO("Juridico");

        private String str;

        TipoDoador(String str) {
            this.str = str;
        }

        @Override
        public String toString() {
            return str;
        }
    }

    private int computadoresDoados;
    private TipoDoador tipo;
    private String cpf;

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
        return tipo.toString();
    }

    public void setTipoDoador(TipoDoador tipo) {
        this.tipo = tipo;
    }
    
    public String getCPF () {
        return cpf;
    }
    
    public void setCPF(String cpf) {
        this.cpf = cpf;
    }
}