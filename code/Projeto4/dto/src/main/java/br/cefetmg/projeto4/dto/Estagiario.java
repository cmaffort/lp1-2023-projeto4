/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.projeto4.dto;

/**
 *
 * @author lucas
 */
public class Estagiario {
    private String nome;
    private String cpf;
    private int idade;
    private int dataDeCadastro;
    private int dataDeEntrada;
    private int computadoresFeitosEssaSemana;
    private String curso;
    private int serie;
    private String fimDoEstagio;
        public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return cpf;
    }

    public void setCPF(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getDataDeCadastro() {
        return dataDeCadastro;
    }

    public int getDataDeEntrada() {
        return dataDeEntrada;
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
        return fimDoEstagio;
    }

}
