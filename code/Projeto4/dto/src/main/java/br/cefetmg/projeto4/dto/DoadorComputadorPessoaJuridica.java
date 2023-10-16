package br.cefetmg.projeto4.dto;
import java.time.LocalDateTime;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.LinkedList;
import java.util.Queue;

public class DoadorComputadorPessoaJuridica {
    private String nome;
    private final String CNPJ;
    private final LocalDateTime dataDeCadastro;
    private String email;
    private LinkedList<Computador> computadoresDoados;
    String endereco;
    String bairro;
    String cidade;
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

    public DoadorComputadorPessoaJuridica(String nome, String CNPJ, String email, String endereco, String bairro, String cidade) {
        this.nome = nome;
        this.CNPJ = CNPJ;
        this.dataDeCadastro = LocalDateTime.now();
        this.email = email;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCNPJ() {
        return CNPJ;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.endereco = bairro;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String endereco) {
        this.endereco = endereco;
    }

    public long getDiasDesdeCadastro() {
        LocalDateTime dataAtual = LocalDateTime.now();
        Duration diff = Duration.between(dataDeCadastro, dataAtual);
        return diff.toDays();
    }
}