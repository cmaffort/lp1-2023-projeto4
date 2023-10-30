package br.cefetmg.projeto4.dto;

public class Agendamento {
    private String data;
    private String horario;
    private int idDonatario;

    public Agendamento(String data, String horario, int idDonatario) {
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

    public int getDonatario() {
        return idDonatario;
    }
}
