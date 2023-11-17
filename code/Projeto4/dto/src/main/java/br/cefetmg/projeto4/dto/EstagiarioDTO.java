package br.cefetmg.projeto4.dto;

public class EstagiarioDTO extends UsuarioDTO {
    private String dataEntrada;
    private String dataSaida;
    
    public EstagiarioDTO(String nome, String CPF, String email, String senha, String dataEntrada, String dataSaida) {
        super(nome, CPF, email, senha, Tipo.ESTAGIARIO);
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }
    
    public String getDataEntrada() {
        return dataEntrada;
    }

    public String getDataSaida() {
        return dataSaida;
    }

    @Override
    public EstagiarioDTO safe() {
        return new EstagiarioDTO(nome, codigo, email, null, dataEntrada, dataSaida);
    }
}
