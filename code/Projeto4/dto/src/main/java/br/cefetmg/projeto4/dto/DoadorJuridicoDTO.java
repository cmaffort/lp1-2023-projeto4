package br.cefetmg.projeto4.dto;

public class DoadorJuridicoDTO extends DoadorDTO {
    private String endereco;
    private String CNPJ;
    
    public DoadorJuridicoDTO(String nome, String CNPJ,  String email, String senha, String endereco) {
        this(nome, CNPJ, email, senha, 0, endereco);
    } 

    public DoadorJuridicoDTO(String nome, String CNPJ,  String email, String senha, int computadoresDoados, String endereco) {
        super(nome, CNPJ, email, senha, computadoresDoados, TipoDoador.JURIDICO);
        this.endereco = endereco;
    } 

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public String getCNPJ () {
        return CNPJ;
    }

    public void setCNPJ () {
        this.CNPJ = CNPJ;
    }
}