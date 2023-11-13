package br.cefetmg.projeto4.dto;

public class AgendamentoComUsuarioDTO extends AgendamentoDTO {
    private UsuarioDTO donatario;

    public AgendamentoComUsuarioDTO(String data, String horario, String nome, String email) {
        super(data, horario);
        donatario = new UsuarioDTO(nome, email);
    }

    public int getIdDonatario() {
        throw new UnsupportedOperationException("This object doesn't support this data");
    }

    public void setDonatario() {
        throw new UnsupportedOperationException("This object doesn't support this data");
    }

    public String getNome() {
        return donatario.getNome();
    }

    public String getEmail() {
        return donatario.getEmail();
    }
}