const donatario = document.getElementById('donatario');
const professor = document.getElementById('professor');
const estagiario = document.getElementById('estagiario');
const doadorFisico = document.getElementById('doadorF');
const doadorJuridico = document.getElementById('doadorJ');
const conteudoEl = document.getElementById('conteudo');

function setConteudo(type) {
    const xhr = new XMLHttpRequest();

    xhr.open('GET', `cadastro/${type}.jsp`, true);

    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4 && xhr.status === 200) 
            conteudoEl.innerHTML = xhr.responseText;
    }

    xhr.send();
}

function selectCadastro(evt, type) {
    const target = evt.target;

    setConteudo(type);

    const selected = document.querySelector('.selected');

    if (selected)
        selected.classList.remove('selected');

    target.classList.add('selected');
}

donatario.addEventListener('click', e => selectCadastro(e, 'donatario'));
professor.addEventListener('click', e => selectCadastro(e, 'professor'));
estagiario.addEventListener('click', e => selectCadastro(e, 'estagiario'));
doadorFisico.addEventListener('click', e => selectCadastro(e, 'doador/fisico'));
doadorJuridico.addEventListener('click', e => selectCadastro(e, 'doador/juridico'));

window.addEventListener('DOMContentLoaded', () => donatario.click());