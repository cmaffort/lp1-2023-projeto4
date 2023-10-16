/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package br.cefetmg.projeto4.dto;

enum EstadoComputador{
    DISPONIVEL("Disponível"),
    DOADO("Doado"),
    NAO_RECEBIDO("Não recebido"),
    MANUTENCAO("Em manutenção"),
    RETIRADADEPECAS("Retirada de Peças");
    private String estado;
    EstadoComputador(String estado){
        this.estado = estado;
    }
    public String getEstado(){
        return estado;
    }
}
