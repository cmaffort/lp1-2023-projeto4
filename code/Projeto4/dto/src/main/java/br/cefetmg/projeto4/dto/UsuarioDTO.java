package br.cefetmg.projeto4.dto;

public class UsuarioDTO {
    protected enum TipoCodigo {
        CPF, CNPJ;
    }

    protected enum Tipo {
        DONATARIO("Donatario"), 
        PROFESSOR("Professor"), 
        ESTAGIARIO("Estagiario"), 
        DOADOR("Doador");

        private String str;

        Tipo(String str) {
            this.str = str;
        }

        @Override
        public String toString() {
            return str;
        }
    }

    private String nome;
    private String codigo;
    private TipoCodigo tipoCodigo;
    private String email;
    private String senha;
    private Tipo tipo;

    protected UsuarioDTO(String nome, String email) {
        this(nome, null, email, null);
    }

    protected UsuarioDTO(String nome, String CPF, String email, String senha) {
        this(nome, CPF, email, senha, Tipo.DONATARIO);
    }

    protected UsuarioDTO(String nome, String CPF, String email, String senha, Tipo tipo) {
        this(nome, CPF, TipoCodigo.CPF, email, senha, tipo);
    }

    protected UsuarioDTO(String nome, String codigo, TipoCodigo tipoCodigo, String email, String senha, Tipo tipo) {
        this.nome = nome;
        this.codigo = codigo;
        this.tipoCodigo = tipoCodigo;
        this.email = email;
        this.senha = senha;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipoCodigo() {
        return tipoCodigo.toString();
    }

    public void setTipoCodigo(TipoCodigo tipoCodigo) {
        this.tipoCodigo = tipoCodigo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo.toString();
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
}