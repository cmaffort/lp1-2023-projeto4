/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.cefetmg.projeto4.idao;

/**
 *
 * @author lucas
 */
public interface IEstagiarioDAO extends IUsuarioDoSistemaDAO{
    public int getDataDeEntrada();
    public int getComputadoresFeitosEssaSemana();
    public void adicionarComputadorFeitoEssaSemana(IComputadorDAO computador);
    public String getCurso();
    public int getSerie();
    public String getFimDoEstagio();
}
