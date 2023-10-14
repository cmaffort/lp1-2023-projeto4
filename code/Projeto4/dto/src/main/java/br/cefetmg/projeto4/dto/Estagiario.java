package br.cefetmg.projeto4.dto;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;

public class Estagiario extends UsuarioDoSistema {
    private int computadoresFeitosEssaSemana;
    private String curso;
    private int serie;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;


    public Estagiario(String nome, String CPF, String email, int diaEntrada, int mesEntrada, int anoEntrada, int diaSaida, int mesSaida, int anoSaida) {
        super(nome, CPF, email);
         dataEntrada = LocalDate.of(anoEntrada, mesEntrada, diaEntrada);         
         dataSaida = LocalDate.of(anoSaida, mesSaida, diaSaida);
    }


    public int getComputadoresFeitosEssaSemana() {
        return computadoresFeitosEssaSemana;
    }

    public String getCurso() {
        return curso;
    }

    public int getSerie() {
        return serie;
    }

    public String getFimDoEstagio() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = dateFormat.format(dataSaida);
        return dataFormatada;
    }
    public String getInicioDoEstagio() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = dateFormat.format(dataEntrada);
        return dataFormatada;
    }


}
