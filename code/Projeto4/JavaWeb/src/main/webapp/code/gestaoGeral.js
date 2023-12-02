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



botaoDoadoresEl.addEventListener('click', function() {

    doadoresEl.style.display = "block";
    doacoesEl.style.display = "none";
    geralEl.style.display = "none";
    manutencoesEl.style.display = "none";
    funcionariosEl.style.display = "none";
});

botaoDoacoesEl.addEventListener('click', function() {

    doacoesEl.style.display = "block";
    doadoresEl.style.display = "none";
    geralEl.style.display = "none";
    manutencoesEl.style.display = "none";
    funcionariosEl.style.display = "none";
});

botaoGeralEl.addEventListener('click', function() {

    geralEl.style.display = "block";
    doadoresEl.style.display = "none";
    doacoesEl.style.display = "none";
    manutencoesEl.style.display = "none";
    funcionariosEl.style.display = "none";

});

botaoManutencoesEl.addEventListener('click', function() {

    manutencoesEl.style.display = "block";
    geralEl.style.display = "none";
    doadoresEl.style.display = "none";
    doacoesEl.style.display = "none";
    funcionariosEl.style.display = "none";

});

botaoFuncionariosEl.addEventListener('click', function() {

    funcionariosEl.style.display = "block";
    geralEl.style.display = "none";
    doadoresEl.style.display = "none";
    doacoesEl.style.display = "none";
    manutencoesEl.style.display = "none";
});

// Função que exibe o Banco de dados

let contador = 0;
let posicaoClasse = "direita";

function mostrarclasses () {

if (contador % 3 == 0) { 
    let novaDiv = document.createElement("div");
    novaDiv.classLis.add("divMaior");
    novaDiv.style.top += 15 + "px";
    }
    
let novaClasse = document.createElement("div");



if (posicaoClasse == "direita") {
    novaClasse.classList.add("esquerda");
    posicaoClasse = "esquerda";
} else if (posicaoClasse == "esquerda") {
        novaClasse.classList.add("meio");
        posicaoClasse = "meio";
} else if (posicaoClasse == "meio") {
        novaClasse.classList.add("direita");
        posicaoClasse = "direita";
}
}

