package br.cefetmg.projeto4.dto;


public class DoadorJuridicoDTO extends DoadorDTO {
    private String endereco;

    public DoadorJuridicoDTO(String nome, String CNPJ,  String email, String senha, String endereco) {
        this(nome, CNPJ, email, senha, null, endereco);
    }
    
    public DoadorJuridicoDTO(String nome, String CNPJ,  String email, String senha, String foto, String endereco) {
        this(nome, CNPJ, email, senha, foto, 0, endereco);
    } 

    public DoadorJuridicoDTO(String nome, String CNPJ,  String email, String senha, int computadoresDoados, String endereco) {
        this(nome, CNPJ, email, senha, null, 0, endereco);
    }

    public DoadorJuridicoDTO(String nome, String CNPJ,  String email, String senha, String foto, int computadoresDoados, String endereco) {
        super(nome, CNPJ, email, senha, foto, computadoresDoados, TipoDoador.JURIDICO);
        this.endereco = endereco;
    } 

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public DoadorJuridicoDTO safe() {
        return new DoadorJuridicoDTO(nome, codigo, email, null, foto, computadoresDoados, endereco);
    }
}