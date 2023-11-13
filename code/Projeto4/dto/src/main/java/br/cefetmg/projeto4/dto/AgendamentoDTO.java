package br.cefetmg.projeto4.dto;

public class AgendamentoDTO {
    private String data;
    private String horario;
    private int idDonatario;

    protected AgendamentoDTO (String data, String horario) {
        this(data, horario, 0);
    }

    public AgendamentoDTO(String data, String horario, int idDonatario) {
        this.data = data;
        this.horario = horario;
        this.idDonatario = idDonatario;
    }

    public String getData() {
        return data;
    }

    public String getHorario() {
        return horario;
    }

    public int getIdDonatario() {
        return idDonatario;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public void setIdDonatario(int idDonatario) {
        this.idDonatario = idDonatario;
    }
}