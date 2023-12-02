// Definir qual classe será exibida

let doadoresEl = document.querySelector('#doadores');
let botaoDoadoresEl = document.querySelector('#botaoDoadores');
let doacoesEl = document.querySelector('#doacoes');
let botaoDoacoesEl = document.querySelector('#botaoDoacoes');
let geralEl = document.querySelector('#geral');
let botaoGeralEl = document.querySelector('#botaoGeral');
let manutencoesEl = document.querySelector('#manutencoes');
let botaoManutencoesEl = document.querySelector('#botaoManutencoes');
let funcionariosEl = document.querySelector('#funcionarios');
let botaoFuncionariosEl = document.querySelector('#botaoFuncionarios');



botaoDoadoresEl.addEventListener('click', function () {

    doadoresEl.style.display = "block";
    doacoesEl.style.display = "none";
    geralEl.style.display = "none";
    manutencoesEl.style.display = "none";
    funcionariosEl.style.display = "none";
});

botaoDoacoesEl.addEventListener('click', function () {

    doacoesEl.style.display = "block";
    doadoresEl.style.display = "none";
    geralEl.style.display = "none";
    manutencoesEl.style.display = "none";
    funcionariosEl.style.display = "none";
});

botaoGeralEl.addEventListener('click', function () {

    geralEl.style.display = "block";
    doadoresEl.style.display = "none";
    doacoesEl.style.display = "none";
    manutencoesEl.style.display = "none";
    funcionariosEl.style.display = "none";

});

botaoManutencoesEl.addEventListener('click', function () {

    manutencoesEl.style.display = "block";
    geralEl.style.display = "none";
    doadoresEl.style.display = "none";
    doacoesEl.style.display = "none";
    funcionariosEl.style.display = "none";

});

botaoFuncionariosEl.addEventListener('click', function () {

    funcionariosEl.style.display = "block";
    geralEl.style.display = "none";
    doadoresEl.style.display = "none";
    doacoesEl.style.display = "none";
    manutencoesEl.style.display = "none";
});

// Função que exibe o Banco de dados

let contador = 0;
let posicaoClasseDoador = "direita";
let posicaoClasseDoacao = "direita";
let posicaoClasseManutencao = "direita";
let posicaoClasseFuncionario = "direita";
let classe = document.querySelector(".classe");
let conteudoObtido = document.querySelectorAll(".classe");

function montarClasses(nome, codigo, var1, email, foto) {

    if (contador % 3 === 0 || contador === 0) {
        let novaDiv = document.createElement("div");
        novaDiv.classList.add("divMaior");
        novaDiv.style.top += 15 + "px";
    }

    let novaClasseDoador = document.createElement("div");
    let novaClasseDoacao = document.createElement("div");
    let novaClasseManutencao = document.createElement("div");
    let novaClasseFuncionario = document.createElement("div");
    let listaDiv = document.creatElement("ul");
    listaDiv.classList.add("listaDiv");
    let li1 = document.createElement("li");
    let li2 = document.createElement("li");
    let li3 = document.createElement("li");
    let h2 = document.createElement("h2");
    let img = document.creatElement("img");

    if (doadoresEl.style.display === "block") {


        if (posicaoClasseDoador === "direita") {
            novaClasseDoador.classList.add("esquerda");
            posicaoClasseDoador = "esquerda";
            novaDiv.appendChild(novaClasseDoador);
            novaClasseDoador.appendChild(listaDiv);
            img = foto;
            listaDiv.appendChild(img);
            h2.textContent = nome;
            listaDiv.appendChild(h2);
            li1.textContent = "CPF:" + codigo;
            listaDiv.appendChild(li1);
            li2.textContent = "CompuatdoresDoados:" + var1;
            listaDiv.appendChild(li2);
            li3.textContent = "Email:" + email;
            listaDiv.appendChild(li3);
        } else if (posicaoClasseDoador === "esquerda") {
            novaClasseDoador.classList.add("meio");
            posicaoClasseDoador = "meio";
            novaDiv.appendChild(novaClasseDoador);
            novaDiv.appendChild(novaClasseDoador);
            novaClasseDoador.appendChild(listaDiv);
            img = foto;
            listaDiv.appendChild(img);
            h2.textContent = nome;
            listaDiv.appendChild(h2);
            li1.textContent = "CPF:" + codigo;
            listaDiv.appendChild(li1);
            li2.textContent = "CompuatdoresDoados:" + var1;
            listaDiv.appendChild(li2);
            li3.textContent = "Email:" + email;
            listaDiv.appendChild(li3);
        } else if (posicaoClasseDoador === "meio") {
            novaClasseDoador.classList.add("direita");
            posicaoClasseDoador = "direita";
            novaDiv.appendChild(novaClasseDoador);
            novaDiv.appendChild(novaClasseDoador);
            novaClasseDoador.appendChild(listaDiv);
            img = foto;
            listaDiv.appendChild(img);
            h2.textContent = nome;
            listaDiv.appendChild(h2);
            li1.textContent = "CPF:" + codigo;
            listaDiv.appendChild(li1);
            li2.textContent = "CompuatdoresDoados:" + var1;
            listaDiv.appendChild(li2);
            li3.textContent = "Email:" + email;
            listaDiv.appendChild(li3);
        }
        contador++;

    } else if (doacoesEl.style.display === "block") {


        if (posicaoClasseDoacao === "direita") {
            novaClasseDoacao.classList.add("esquerda");
            posicaoClasseDoacao = "esquerda";
            novaDiv.appendChild(novaClasseDoacao);
        } else if (posicaoClasseDoacao === "esquerda") {
            novaClasseDoacao.classList.add("meio");
            posicaoClasseDoacao = "meio";
            novaDiv.appendChild(novaClasseDoacao);
        } else if (posicaoClasseDoacao === "meio") {
            novaClasseDoacao.classList.add("direita");
            posicaoClasseDoacao = "direita";
            novaDiv.appendChild(novaClasseDoacao);
        }
        contador++;
    } else if (manutencoesEl.style.display === "block") {


        if (posicaoClasseManutencao === "direita") {
            novaClasseManutencao.classList.add("esquerda");
            posicaoClasseManutencao = "esquerda";
            novaDiv.appendChild(novaClasseManutencao);
        } else if (posicaoClasseManutencao === "esquerda") {
            novaClasseManutencao.classList.add("meio");
            posicaoClasseManutencao = "meio";
            novaDiv.appendChild(novaClasseManutencao);
        } else if (posicaoClasseManutencao === "meio") {
            novaClasseManutencao.classList.add("direita");
            posicaoClasseManutencao = "direita";
            novaDiv.appendChild(novaClasseManutencao);
        }
        contador++;
    } else if (funcionariosEl.style.display === "block") {


        if (posicaoClasseFuncionario === "direita") {
            novaClasseFuncionario.classList.add("esquerda");
            posicaoClasseFuncionario = "esquerda";
            novaDiv.appendChild(novaClasseFuncionario);
        } else if (posicaoClasseFuncionario === "esquerda") {
            novaClasseFuncionario.classList.add("meio");
            posicaoClasseFuncionario = "meio";
            novaDiv.appendChild(novaClasseFuncionario);
        } else if (posicaoClasseFuncionario === "meio") {
            novaClasseFuncionario.classList.add("direita");
            posicaoClasseFuncionario = "direita";
            novaDiv.appendChild(novaClasseFuncionario);
        }
        contador++;
    }
}



function exibirClasse() {
    for (let i = 0; i < conteudoObtido.length; i++) {
        let conteudo = conteudoObtido[i].innerHTML;
        let conteudoArray = conteudo.split("*");
        
        let nome = conteudoArray[0];
        let codigo = conteudoArray[1];
        let var1 = conteudoArray[2];
        let email = conteudoArray[3];
        let foto = conteudoArray[4];
        
        montarClasses(nome, codigo, var1, email, foto);
    }
}

exibirClasse();
