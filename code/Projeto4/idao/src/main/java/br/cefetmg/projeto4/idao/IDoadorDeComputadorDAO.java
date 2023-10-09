/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.cefetmg.projeto4.idao;

/**
 *
 * @author lucas
 */
public interface IDoadorDeComputadorDAO {
    public String getNome();
    public String getEmail();
    public String setEmail();
    public int anoInicioDoacao();
    // public ComputadoresDoados
    // public peças doadas;
    
    // retorna se o doador é uma pessoa fisica ou juridica
    public String getTipoPessoa();
    
    
    // retorna o CPF se for uma pessoa física e retorna o CNPJ se for uma pessoa jurica
    public String getIdentificacao();
}