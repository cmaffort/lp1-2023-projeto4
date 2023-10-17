/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.cefetmg.projeto4.idao;

/**
 *
 * @author lucas
 */
public interface IPecasDAO {
    public int getQuantidade();
    
    // pode adicionar e remover peças adicionando um numero positivo e negativo
    public void adicionarQuantidade(int quantidade);
}
