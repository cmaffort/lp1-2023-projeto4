package br.cefetmg.projeto4.dto;
import java.time.LocalDateTime;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;

public class DoadorComputadorPessoaJuridica {
    private String nome;
    private final String CNPJ;
    private final LocalDateTime dataDeCadastro;
    private String email;
    private Queue<Computador> computadoresDoados;

    public String getEmail () {
        return email;
    }    
    public void adicionarComputador(Computador computador)
    {
        this.computadoresDoados.add(computador);
    }

    
    public void setEmail (String email) {
        this.email = email;
    }    

    public UsuarioDoSistema(String nome, String CNPJ, String email) {
        this.nome = nome;
        this.CNPJ = CNPJ;
        this.dataDeCadastro = LocalDateTime.now();
        
    }

    public String getNome() {
        return nome;
    }
    public int getIdade() {
        LocalDate dataAtual = LocalDate.now();
        Period periodo = Period.between(dataNascimento, dataAtual);
        return periodo.getYears();
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public long getDiasDesdeCadastro() {
        LocalDateTime dataAtual = LocalDateTime.now();
        Duration diff = Duration.between(dataDeCadastro, dataAtual);
        return diff.toDays();
    }
}