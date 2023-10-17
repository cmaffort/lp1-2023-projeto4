package br.cefetmg.projeto4.idao;

public interface IComputadorDAO {
    public String getDataDeChegada();
    public String getModelo();
    public int getQuantidadeDeRAM();
    public int getCapacidadeDeArmazenamento();
    public String getModeloProcessador();
    public String getCodigo();
    public String getDoador();
    public boolean getEstaParaDoacao();
    public void setEstaParaDoacao(boolean estado);
    public boolean getEstaParaRetiradaDePecas();
    public void setEstaParaRetiradaDePecas(boolean estado);
    // os problemas estão armazenados em uma fila de acordo com a ordem de importancia
    public String getProblemas();
    public void addProblemas(String problemas);
    public String getDonatario();
    public void setDonatario(IDonatarioDAO donatario);
    
}
