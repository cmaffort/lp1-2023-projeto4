package br.cefetmg.projeto4.idao;

public interface IUsuarioDoSistemaDAO {
    public String getNome();
    public void setNome(String nome);
    public String getCPF();
    public void setCPF(String cpf);
    public int  getIdade();
    public void setIdade(int idade);
    public int getDataDeCadastro();
}
