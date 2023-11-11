const headerEl = document.querySelector('header');
const icons = {
    'srcs' : [
        'img/logo-cefet.png',
        'img/login.png',
        'img/suporte.png',
        'img/sobre-nos.png'
    ],
    'alts' : [
        'Logo CEFET',
        'Login',
        'Suporte',
        'Sobre nós',
    ],
    'hrefs' : [
        'index.html',
        'login.jsp',
        '',
        'https://www.dde.cefetmg.br/2023/08/29/oficina-de-recuperacao-de-computadores-beneficia-estudantes-sem-acesso-a-computadores/'
    ]
};
const menu = {
    SRC: 'img/hamburger.png',
    ALT: 'Menu',
    EL: newNav('menu', 'hidden')
};
const AltType = {
    ALT: 0,
    TEXT: 1
};

function newEl(tag, ...classNames) {
    const el = document.createElement(tag);

    for (const className of classNames)
        el.classList.add(className);

    return el;
}

function newImg(src, alt = null, ...classNames) {
    const img = newEl('img', ...classNames);

    img.src = src;

    if (alt)
        img.alt = alt;

    return img;
}

function newFigure(img, href, text = null, ...classNames) {
    const figure = newEl('figure', ...classNames);
    
    figure.appendChild(img);

    if (text) {
        const textEl = newEl('span');

        textEl.innerHTML = text;

        figure.append(textEl);
    }
    
    figure.addEventListener('click', () => redirect(href));

    return figure;
}

function newNav(id = null, ...classNames) {
    const nav = newEl('nav', ...classNames);

    if (id)
        nav.setAttribute('id', id);

    return nav;
}

function newLi(text, href, ...classNames) {
    const li = newEl('li', ...classNames);

    li.addEventListener('click', () => redirect(href));
    li.innerHTML = text;

    return li;
}

function newMenu() {
    const img = newImg(menu.SRC, menu.ALT, 'menu');
    const figure = newEl('figure');
    const nav = newNav(null, 'menu');

    figure.appendChild(img);
    nav.appendChild(figure);
    nav.appendChild(menu.EL);

    loadMenu();

    figure.addEventListener('click', toggleMenu);

    return nav;
}

function newPopulatedNav(id, startIndex, endIndex, altType = AltType.ALT, ...classNames) {
    const nav = newNav(id, ...classNames);

    switch(altType) {
        case AltType.TEXT:
            populateNavText(nav, startIndex, endIndex);
            break;
        default:
            populateNavAlt(nav, startIndex, endIndex);
    }

    return nav;
}

function populateNavAlt(nav, startIndex, endIndex) {
    for (let i = startIndex; i < endIndex; ++i) {
        const img = newImg(icons['srcs'][i], icons['alts'][i])
        const figure = newFigure(img, icons['hrefs'][i]);

        nav.appendChild(figure);
    }
}

function populateNavText(nav, startIndex, endIndex) {
    for (let i = startIndex; i < endIndex; ++i) {
        const img = newImg(icons['srcs'][i])
        const figure = newFigure(img, icons['hrefs'][i], icons['alts'][i]);

        nav.appendChild(figure);
    }
}

function redirect(href) {
    window.location.href = href;
}

function toggleMenu() {
    menu.EL.classList.toggle('hidden');
}

function loadMenu() {
    const ul = newEl('ul');
    const lis = [
        newLi('Agenda', 'agenda.jsp'),
        newLi('Agendar entrega', 'agendamentoEntrega.jsp'),
        newLi('Fazer doação', 'cadastroDoacao.jsp'),
        newLi('Relatar peças faltantes', 'cadastroPecaFaltante.jsp'),
        newLi('Dar feedback', 'feedback.jsp'),
        newLi('Gerir doações', 'MostrarDoacoes'),
        newLi('Gerir doadores', 'gestaoDoadores.jsp'),
        newLi('Solicitar reparo', 'solicitacaoReparo.jsp'),
        newLi('Verificar posição na fila', 'verificarPosicao.jsp'),
        newLi('Deletar conta', 'deletarConta.jsp', 'danger')
    ];

    for (const li of lis)
        ul.appendChild(li);

    menu.EL.appendChild(ul);
}

function loadHeader() {
    if (!headerEl)
        return;

    const navHome = newPopulatedNav('home', 0, 1);
    const navPages = newPopulatedNav('pages', 1, 4, AltType.TEXT);
    const section = newEl('section');

    headerEl.appendChild(navHome);
    headerEl.appendChild(section);
    section.appendChild(navPages);
    section.appendChild(newMenu());
}

document.addEventListener('DOMContentLoaded', loadHeader);