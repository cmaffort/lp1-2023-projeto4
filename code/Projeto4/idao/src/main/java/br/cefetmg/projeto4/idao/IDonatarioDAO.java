/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.cefetmg.projeto4.idao;

/**
 *
 * @author lucas
 */
public interface IDonatarioDAO extends IUsuarioDoSistemaDAO {
    public String getEscola();
    public int getPosicao();
    public int getSerie();
    // public Computador getComputador();
    public void setComputador(IComputadorDAO computador);
    public String getAvaliacao();
    public void setAvaliacao(String avaliacao);
    public String getProblemas();
    public void setProblemas(String problemas);
    public String getEmail();
    public void setEmail(String email);
}
