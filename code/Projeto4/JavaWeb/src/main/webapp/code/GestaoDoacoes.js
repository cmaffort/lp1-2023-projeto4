function adicionaDoacao(quantidade, computador) {
    let novaDoacao = document.createElement("div");
    novaDoacao.classList.add("despesa");
   
    let novoDoador = document.createElement("div");
    novoTitulo.textContent = "Doador: " + novoDoador;
   
    //let novoConteudo = document.createElement("div");
   
    //let novoValor = document.createElement("div");
    //novoValor.textContent = "Valor: R$" + valor;
   
    //let novaData = document.createElement("div");
    //novaData.textContent = "Data ocorrência: " + data;
   
    //let novaDescricao = document.createElement("div");
    //novaDescricao.textContent = "Descrição: " + descricao;
   
    //novoConteudo.appendChild(novoValor);
    //novoConteudo.appendChild(novaData);
    //novoConteudo.appendChild(novaDescricao);
   
    //novaDespesa.appendChild(novoTitulo);
    //novaDespesa.appendChild(novoConteudo);
   
    //novoConteudo.classList.add("flex-conteudo-despesas");
    novoDoador.classList.add("flex-titulo");
    novaDoacao.classList.add("flex-despesas");
   
    if (ultimo == "D") {
        novaDespesa.classList.add("esquerda");
        ultimo = "E";
    }
    else {
        novaDespesa.classList.add("direita");
        ultimo = "D";
    }
   
    novaDespesa.style.top = posicaoDespesas + "%";
    posicaoDespesas+= 30;
   
    contDespesas.appendChild(novaDespesa);
}

let quadradoDoacao = document.querySelectorAll(".quadradoDoacao");

for (let i = 0; i < quadradoDoacao.length; i++) {
    let conteudoAtual = quadradoDoacao[i].innerHTML;
    let conteudoDivido = conteudoAtual.split('*');
   
    let quantidade = conteudoDivido[0];
    let computador = conteudoDivido[1];
   
    adicionaDoacao(quantidade, computador);
}

