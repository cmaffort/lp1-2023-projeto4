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

function mostrarclasses() {

    if (contador % 3 == 0) {
        let novaDiv = document.createElement("div");
        novaDiv.classLis.add("divMaior");
        novaDiv.style.top += 15 + "px";
    }

    let novaClasseDoador = document.createElement("div");
    let novaClasseDoacao = document.createElement("div");
    let novaClasseManutencao = document.createElement("div");
    let novaClasseFuncionario = document.createElement("div");

    if (doadoresEl.style.display == "block") {


        if (posicaoClasseDoador == "direita") {
            novaClasseDoador.classList.add("esquerda");
            posicaoClasseDoador = "esquerda";
        } else if (posicaoClasseDoador == "esquerda") {
            novaClasseDoador.classList.add("meio");
            posicaoClasseDoador = "meio";
        } else if (posicaoClasseDoador == "meio") {
            novaClasseDoador.classList.add("direita");
            posicaoClasseDoador = "direita";
        }

    }
    
    if (doacoesEl.style.display == "block") {


        if (posicaoClasseDoacao == "direita") {
            novaClasseDoacao.classList.add("esquerda");
            posicaoClasseDoacao = "esquerda";
        } else if (posicaoClasseDoacao == "esquerda") {
            novaClasseDoacao.classList.add("meio");
            posicaoClasseDoacao = "meio";
        } else if (posicaoClasseDoacao == "meio") {
            novaClasseDoacao.classList.add("direita");
            posicaoClasseDoacao = "direita";
        }

    }
    
    if (manutencoesEl.style.display == "block") {


        if (posicaoClasseManutencao == "direita") {
            novaClasseManutencao.classList.add("esquerda");
            posicaoClasseManutencao = "esquerda";
        } else if (posicaoClasseManutencao == "esquerda") {
            novaClasseManutencao.classList.add("meio");
            posicaoClasseManutencao = "meio";
        } else if (posicaoClasseManutencao == "meio") {
            novaClasseManutencao.classList.add("direita");
            posicaoClasseManutencao = "direita";
        }

    }
    
    if (funcionariosEl.style.display == "block") {


        if (posicaoClasseFuncionario == "direita") {
            novaClasseFuncionario.classList.add("esquerda");
            posicaoClasseFuncionario = "esquerda";
        } else if (posicaoClasseFuncionario == "esquerda") {
            novaClasseFuncionario.classList.add("meio");
            posicaoClasseFuncionario = "meio";
        } else if (posicaoClasseFuncionario == "meio") {
            novaClasseFuncionario.classList.add("direita");
            posicaoClasseFuncionario = "direita";
        }

    }
}

