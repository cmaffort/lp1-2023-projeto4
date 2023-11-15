package br.cefetmg.projeto4.dto;

public class ItemEstoqueDTO {
    private enum Status {
        DISPONIVEL, DOADO;
    }

    private String tipo;
    private int quantidade;
    private Status status;

    public ItemEstoqueDTO(String tipo, int quantidade, String status) {
        this(tipo, quantidade, Status.valueOf(status));
    }

    private ItemEstoqueDTO(String tipo, int quantidade, Status status) {
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.status = status;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getStatus() {
        return status.name();
    }

    public void setStatus(String status) {
        setStatus(Status.valueOf(status));
    }

    private void setStatus(Status status) {
        this.status = status;
    }
}