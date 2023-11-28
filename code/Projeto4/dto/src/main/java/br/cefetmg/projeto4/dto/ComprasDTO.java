package br.cefetmg.projeto4.dto;


public class ComprasDTO {
    private int id;
    private int idPeca;
    private int valorUnitario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPeca() {
        return idPeca;
    }

    public void setIdPeca(int idPeca) {
        this.idPeca = idPeca;
    }

    public int getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(int valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public ComprasDTO(int id, int idPeca, int valorUnitario) {
        this.id = id;
        this.idPeca = idPeca;
        this.valorUnitario = valorUnitario;
    }
}
