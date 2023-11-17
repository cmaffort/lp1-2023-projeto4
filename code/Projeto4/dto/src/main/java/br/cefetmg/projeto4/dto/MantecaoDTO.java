package br.cefetmg.projeto4.dto;

public class MantecaoDTO {
    private enum Estado {
        FUNCIONANDO, QUEBRADO, FALTANDO_PECA, DEFEITUOSO;
    }

    private String data;
    private Estado estado;
    private DonatarioDTO donatario;
    private EstagiarioDTO arrumador;

    public MantecaoDTO(String data, String estado, DonatarioDTO donatario, EstagiarioDTO arrumador) {
        this(data, Estado.valueOf(estado), donatario, arrumador);
    }

    private MantecaoDTO(String data, Estado estado, DonatarioDTO donatario, EstagiarioDTO arrumador) {
        this.data = data;
        this.estado = estado;
        this.donatario = donatario;
        this.arrumador = arrumador;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getEstado() {
        return estado.name();
    }

    public void setEstado(String estado) {
        setEstado(Estado.valueOf(estado));
    }

    private void setEstado(Estado estado) {
        this.estado = estado;
    }

    public DonatarioDTO getDonatario() {
        return donatario;
    }

    public String getEmailDonatario() {
        return donatario == null ? null : donatario.getEmail();
    }

    public void setDonatario(DonatarioDTO donatario) {
        this.donatario = donatario;
    }

    public EstagiarioDTO getArrumador() {
        return arrumador;
    }

    public String getEmailArrumador() {
        return arrumador == null ? null : arrumador.getEmail();
    }

    public void setArrumador(EstagiarioDTO arrumador) {
        this.arrumador = arrumador;
    }
}