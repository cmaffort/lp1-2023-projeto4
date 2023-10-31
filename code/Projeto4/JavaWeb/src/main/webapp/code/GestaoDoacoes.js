    let posicaoDoacao = 1;
    let contDoacao = document.querySelector("#article-despesas");

function adicionaDoacao(str, str1, str2, str3,str4,  qntdRAM) {
    let doacao = document.createElement("div");
    doacao.classList.add("Doacao");
   
    let novoQuadrado = document.createElement("div");
   
    let doador = document.createElement("div");
    doador.textContent = "Doador: " + str;
   
    let data = document.createElement("div");
    data.textContent = "Data de Chegada: " + str1;
   
    let donatario = document.createElement("div");
    donatario.textContent = "Donatario: " + str2;
   
    let marca = document.createElement("div");
    marca.textContent = "Marca: " + str3;
    
    let modeloProcessador = document.createElement("div");
    modeloProcessador.textContent = "Modelo: " + str4;
    
    let quantidadeDeRAM = document.createElement("div");
    quantidadeDeRAM.textContent = "Quantidade de RAM: " + qntdRAM;
   
    novoQuadrado.appendChild(data);
    novoQuadrado.appendChild(donatario);
    novoQuadrado.appendChild(marca);
    novoQuadrado.appendChild(modeloProcessador);
    novoQuadrado.appendChild(quantidadeDeRAM);
    
    
    doacao.appendChild(doador);
    doacao.appendChild(novoQuadrado);
   
    novoQuadrado.classList.add("flex-conteudo-despesas");
    doador.classList.add("flex-doador");
    doacao.classList.add("flex-doacao");
   
    if (ultimo == "D") {
        doacao.classList.add("esquerda");
        ultimo = "E";
    }
    else {
        doacao.classList.add("direita");
        ultimo = "D";
    }
   
    doacao.style.top = posicaoDoacao + "%";
    posicaoDoacao+= 30;
   
    contDoacao.appendChild(doacao);
}

let quadradoDoacao = document.querySelectorAll(".quadradoDoacao");

for (let i = 0; i < quadradoDoacao.length; i++) {
    let conteudoAtual = quadradoDoacao[i].innerHTML;
    let conteudoDivido = conteudoAtual.split('*');
   
    let str = conteudoDivido[0];
    let str1 = conteudoDivido[1];
    let str2 = conteudoDivido[2];
    let str3 = conteudoDivido[3];
    let str4 = conteudoDivido[4];
    let qntdRAM = conteudoDivido[5];
   
    adicionaDoacao(str, str1, str2, str3, str4, qntdRAM);
}

