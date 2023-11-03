const contDoacao = document.getElementById('article-despesas');
const quadradoDoacao = document.querySelectorAll(".quadradoDoacao");
let posicaoDoacao = 1;

function adicionaDoacao(str, str1, str2, str3, str4,  qntdRAM) {
    const doacao = newEl('div', 'doacao');
    const novoQuadrado = newEl('div');
    const doador = newEl('div');
    const data = newEl('div');
    const donatario = newEl('div');
    const marca = newEl('div');
    const modeloProcessador = newEl('div');
    const quantidadeDeRAM = newEl('div');

    doador.textContent = "Doador: " + str;
    data.textContent = "Data de Chegada: " + str1;
    donatario.textContent = "Donatario: " + str2;
    marca.textContent = "Marca: " + str3;
    modeloProcessador.textContent = "Modelo: " + str4;
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
    posicaoDoacao += 30;
   
    contDoacao.appendChild(doacao);
}

for (let i = 0; i < quadradoDoacao.length; i++) {
    const conteudoAtual = quadradoDoacao[i].innerHTML;
    const conteudoDivido = conteudoAtual.split('*');
   
    adicionaDoacao(...conteudoDivido);
}