package br.cefetmg.projeto4.dto;

public class FeedbackDTO {
    private int estrelas;
    private String descricao;
    private String modeloPC;
    private DonatarioDTO donatario;

    public FeedbackDTO(int estrelas, String descricao, DonatarioDTO donatario) {
        this(estrelas, descricao, null, donatario);
    }

    public FeedbackDTO(int estrelas, String descricao, String modeloPC, DonatarioDTO donatario) {
        this.estrelas = estrelas;
        this.descricao = descricao;
        this.modeloPC = modeloPC;
        this.donatario = donatario;
    }

    public int getEstrelas() {
        return estrelas;
    }

    public void setEstrelas(int estrelas) {
        this.estrelas = estrelas;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getModeloPC() {
        return modeloPC;
    }

    public void setModeloPC(String modeloPC) {
        this.modeloPC = modeloPC;
    }

    public DonatarioDTO getDonatario() {
        return donatario;
    }

    public void setDonatario(DonatarioDTO donatario) {
        this.donatario = donatario;
    }
}