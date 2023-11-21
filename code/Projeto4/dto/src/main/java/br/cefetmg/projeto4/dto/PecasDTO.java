package br.cefetmg.projeto4.dto;


public class PecasDTO {
   private enum Status {
        EM_FALTA, COMPRADO;
   }

    private Integer id;
    private int quantidade;
    private String nome;
    private String marca;
    private Status status;

    public PecasDTO(String nome, String marca, String status, int quantidade) {
        this(null, nome, marca, status, quantidade);
    }

    public PecasDTO(Integer id, String nome, String marca, String status, int quantidade) {
        this(id, nome, marca, Status.valueOf(status), quantidade);
    }

    public PecasDTO(String nome, String marca, int quantidade) {
        this((Integer) null, nome, marca, quantidade);
    }

    public PecasDTO(Integer id, String nome, String marca, int quantidade) {
        this(id, nome, marca, Status.EM_FALTA, quantidade);
    }

    private PecasDTO(Integer id, String nome, String marca, Status status, int quantidade) {
        this.id = id;
        this.quantidade = quantidade;
        this.nome = nome;
        this.marca = marca;
        this.status = status;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getStatus() {
        return status.name();
    }

    public void setStatus(String status) {
        this.status = Status.valueOf(status);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}