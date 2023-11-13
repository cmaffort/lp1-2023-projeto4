package br.cefetmg.projeto4.dto;


public class PecasDTO {
   
    private int quantidade;
    private String codigo;
    private String nome;
    private String descricao;
    private String marca;

    public PecasDTO(int quantidade, String codigo, String nome, String marca) {
        this.quantidade = quantidade;
        this.codigo = codigo;
        this.nome = nome;
        this.marca = marca;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
}