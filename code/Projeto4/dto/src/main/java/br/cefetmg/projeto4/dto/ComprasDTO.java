package br.cefetmg.projeto4.dto;
import br.cefetmg.projeto4.dto.PecasDTO;

public class ComprasDTO {
    private int id;
    private int idPeca;
    private int valorUnitario;
    private PecasDTO peca;
    public int getQuantidade() {
        return peca.getQuantidade();
    }
    public String getNome() {
        return peca.getNome();
    }
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
    public ComprasDTO(int id, int valorUnitario, PecasDTO peca) {
        this.id = id;
        this.valorUnitario = valorUnitario;
        this.peca = peca;
    }
    public ComprasDTO(int id, int idPeca, int valorUnitario) {
        this.id = id;
        this.idPeca = idPeca;
        this.valorUnitario = valorUnitario;
    }

    public ComprasDTO(int idPeca, int valorUnitario) {
        this.idPeca = idPeca;
        this.valorUnitario = valorUnitario;
    }
}
