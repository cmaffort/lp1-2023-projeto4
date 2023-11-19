package br.cefetmg.projeto4.dto;


public class UsuarioDTO {
    protected enum TipoCodigo {
        CPF, CNPJ;
    }

    protected enum Tipo {
        DONATARIO, PROFESSOR, ESTAGIARIO, DOADOR;
    }

    protected String nome;
    protected String codigo;
    private TipoCodigo tipoCodigo;
    protected String email;
    protected String senha;
    private Tipo tipo;
    protected byte[] foto;

    public UsuarioDTO(String nome, String codigo, String tipoCodigo, String email, String senha, String tipo) {
        this(nome, codigo, tipoCodigo, email, senha, tipo, null);
    }

    public UsuarioDTO(String nome, String codigo, String tipoCodigo, String email, String senha, String tipo, byte[] foto) {
        this(nome, codigo, TipoCodigo.valueOf(tipoCodigo), email, senha, Tipo.valueOf(tipo), foto);
    }

    protected UsuarioDTO(String nome, String CPF, String email, String senha) {
        this(nome, CPF, email, senha, Tipo.DONATARIO, null);
    }

    protected UsuarioDTO(String nome, String CPF, String email, String senha, byte[] foto) {
        this(nome, CPF, email, senha, Tipo.DONATARIO, foto);
    }

    protected UsuarioDTO(String nome, String CPF, String email, String senha, Tipo tipo) {
        this(nome, CPF, email, senha, tipo, null);
    }

    protected UsuarioDTO(String nome, String CPF, String email, String senha, Tipo tipo, byte[] foto) {
        this(nome, CPF, TipoCodigo.CPF, email, senha, tipo, foto);
    }

    protected UsuarioDTO(String nome, String codigo, TipoCodigo tipoCodigo, String email, String senha, Tipo tipo) {
        this(nome, codigo, tipoCodigo, email, senha, tipo, null);
    }

    protected UsuarioDTO(String nome, String codigo, TipoCodigo tipoCodigo, String email, String senha, Tipo tipo, byte[] foto) {
        this.nome = nome;
        this.codigo = codigo;
        this.tipoCodigo = tipoCodigo;
        this.email = email;
        this.senha = senha;
        this.tipo = tipo;
        this.foto = foto;
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
        return tipoCodigo.name();
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
        if (senha == null)
            throw new UnsupportedOperationException("Este objeto não pode manter senha");

        return senha;
    }

    public void setSenha(String senha) {
        if (this.senha == null)
            throw new UnsupportedOperationException("Este objeto não pode manter senha");

        this.senha = senha;
    }

    public String getTipo() {
        return tipo.name();
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public UsuarioDTO safe() {
        return new UsuarioDTO(nome, codigo, tipoCodigo, email, null, tipo);
    }
}