package br.cefetmg.projeto4.dto;

public class AgendamentoDTO {
    private String data;
    private String horario;
    private DonatarioDTO donatario;

public AgendamentoDTO(String data, String horario, DonatarioDTO donatario) {
        this.data = data;
        this.horario = horario;
        this.donatario = donatario;
    }

    public String getData() {
        return data;
    }

    public String getHorario() {
        return horario;
    }

    public DonatarioDTO getDonatario() {
        return donatario;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public void setIdDonatario(DonatarioDTO donatario) {
        this.donatario = donatario;
    }
}