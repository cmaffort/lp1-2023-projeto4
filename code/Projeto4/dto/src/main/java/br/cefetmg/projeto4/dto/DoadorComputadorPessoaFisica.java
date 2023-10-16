package br.cefetmg.projeto4.dto;

import java.util.LinkedList;
import java.util.Queue;

public class DoadorComputadorPessoaFisica extends UsuarioDoSistema {
    Queue<Computador> computadoresDoados;
    public DoadorComputadorPessoaFisica(String nome, String CPF, String email) {
        super(nome, CPF, email);
        computadoresDoados = new LinkedList<> ();

    }
    public void adicionarComputador(Computador computador)
    {
        this.computadoresDoados.add(computador);
    }

}
