// Definir qual classe será exibida

let doadoresEl = document.querySelector('#doadores');
let botaoDoadoresEl = document.querySelector('#botaoDoadores');
let doacoesEl = document.querySelector('#doacoes');
let botaoDoacoesEl = document.querySelector('#botaoDoacoes');
let manutencoesEl = document.querySelector('#manutencoes');
let botaoManutencoesEl = document.querySelector('#botaoManutencoes');
let funcionariosEl = document.querySelector('#funcionarios');
let botaoFuncionariosEl = document.querySelector('#botaoFuncionarios');

botaoDoadoresEl.addEventListener('click', function () {

    doadoresEl.style.display = "block";
    doacoesEl.style.display = "none";
    manutencoesEl.style.display = "none";
    funcionariosEl.style.display = "none";
});

botaoDoacoesEl.addEventListener('click', function () {

    doacoesEl.style.display = "block";
    doadoresEl.style.display = "none";
    manutencoesEl.style.display = "none";
    funcionariosEl.style.display = "none";
});


botaoManutencoesEl.addEventListener('click', function () {

    manutencoesEl.style.display = "block";
    doadoresEl.style.display = "none";
    doacoesEl.style.display = "none";
    funcionariosEl.style.display = "none";
});

botaoFuncionariosEl.addEventListener('click', function () {

    funcionariosEl.style.display = "block";
    doadoresEl.style.display = "none";
    doacoesEl.style.display = "none";
    manutencoesEl.style.display = "none";
});