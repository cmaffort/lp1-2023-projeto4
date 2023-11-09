package br.cefetmg.projeto4.dto;

public class Estagiario extends UsuarioDoSistema {
    private int computadoresFeitosEssaSemana;
    private String curso;
    private int serie;
    private String dataEntrada;
    
    private String dataSaida;
    private String senha;    
   private String anoEntrada; 
    private String mesEntrada;    
    private String diaEntrada;
    private String anoSaida;    
    private String mesSaida;    
    private String diaSaida;
    
public Estagiario(String nome, String CPF, String email, String diaEntrada, String mesEntrada, String anoEntrada, String diaSaida, String mesSaida, String anoSaida, String senha) {
    super(nome, CPF, email);
    this.diaEntrada = diaEntrada;
    this.mesEntrada = mesEntrada;
    this.anoEntrada = anoEntrada;
    this.diaSaida = diaSaida;
    this.mesSaida = mesSaida;
    this.anoSaida = anoSaida;
    this.senha = senha;
    }
public Estagiario(String nome, String CPF, String email, String dataEntrada, String dataSaida, String senha) {
    super(nome, CPF, email);
    this.dataEntrada = dataEntrada;
    this.dataSaida = dataSaida;
    this.senha = senha;
    }
    
    public String getDataEntrada() {
        String data = diaEntrada + "/" + mesEntrada + "/" + anoEntrada;
        return data;
    }

    public String getDataSaida() {
        String data = diaSaida + "/" + mesSaida + "/" + anoSaida;
        return data;
    }
    public int getComputadoresFeitosEssaSemana() {
        return computadoresFeitosEssaSemana;
    }

    public void setComputadoresFeitosEssaSemana(int computadoresFeitosEssaSemana) {
        this.computadoresFeitosEssaSemana = computadoresFeitosEssaSemana;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getNome()
    {
        return super.getNome();
    }
    public String getCPF()
    {
        return super.getCPF();
    }
    public int getIdade()
    {
        return super.getIdade();
    }

}
