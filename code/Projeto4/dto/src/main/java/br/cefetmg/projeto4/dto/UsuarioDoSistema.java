package br.cefetmg.projeto4.dto;
import java.time.LocalDateTime;
public class UsuarioDoSistema {
    private String nome;
    private String CPF;
    private int idade;
    public String getNome()
    {
        return nome;
    }
    public void setNome(String nome)
    {
        this.nome = nome;
    }
    public String getCPF()
    {
        return CPF;
    }
   /* public int  getIdade()
    {}
    public int getDataDeCadastro()
    {}*/

}
