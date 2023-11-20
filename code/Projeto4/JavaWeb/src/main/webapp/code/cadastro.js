const donatario = document.getElementById('donatario');
const professor = document.getElementById('professor');
const estagiario = document.getElementById('estagiario');
const doadorFisico = document.getElementById('doadorF');
const doadorJuridico = document.getElementById('doadorJ');
const conteudoEl = document.getElementById('conteudo');
const p = getParameterByName('p');

function getParameterByName(name, url) {
    if (!url) 
        url = window.location.href;

    name = name.replace(/[\[\]]/g, "\\$&");

    const regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)");
    const results = regex.exec(url);

    if (!results) 
        return null;
    if (!results[2]) 
        return '';
    
    return decodeURIComponent(results[2].replace(/\+/g, " "));
}

function setConteudo(type) {
    const xhr = new XMLHttpRequest();
    const url = `cadastro/${type}.jsp` + (p != null ? `?p=${p}` : '');

    xhr.open('GET', url, true);

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