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

});

botaoDoacoesEl.addEventListener('click', function() {

    doacoesEl.style.display = "block";

});

botaoGeralEl.addEventListener('click', function() {

    geralEl.style.display = "block";

});

botaoManutencoesEl.addEventListener('click', function() {

    manutencoesEl.style.display = "block";

});

botaoFuncionarioEl.addEventListener('click', function() {

    funcionariosEl.style.display = "block";

});

