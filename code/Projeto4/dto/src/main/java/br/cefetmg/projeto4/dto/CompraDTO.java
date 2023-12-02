package br.cefetmg.projeto4.dto;

public class CompraDTO extends PecasDTO {
    private double valorUnitario;

    public CompraDTO(String nome, String marca, int quantidade, double valorUnitario) {
        this(null, nome, marca, quantidade, valorUnitario);
    }

    public CompraDTO(Integer id, String nome, String marca, int quantidade, double valorUnitario) {
        super(id, nome, marca, Status.COMPRADO, quantidade);
        this.valorUnitario = valorUnitario;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public double getValorTotal() {
        return getQuantidade() * getValorUnitario();
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
}