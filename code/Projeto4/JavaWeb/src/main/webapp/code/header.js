const headerEl = document.querySelector('header');
const icons = {
    'srcs' : [
        'img/logo-cefet.png',
        'img/pedido.png',
        'img/suporte.png',
        'img/login.png',
        'img/sobre-nos.png',
        'img/doacao.png'
    ],
    'alts' : [
        'Logo CEFET',
        'Fazer pedido',
        'Suporte',
        'Login',
        'Sobre nós',
        'Fazer doação'
    ],
    'hrefs' : [
        'index.html',
        '', 
        '',
        'login.jsp',
        'https://www.dde.cefetmg.br/2023/08/29/oficina-de-recuperacao-de-computadores-beneficia-estudantes-sem-acesso-a-computadores/',
        'cadastroDoacao.jsp'
    ]
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

function loadHeader() {
    if (!headerEl)
        return;

    const navHome = newPopulatedNav('home', 0, 1);
    const navPages = newPopulatedNav('pages', 1, icons['srcs'].length, AltType.TEXT);

    headerEl.appendChild(navHome);
    headerEl.appendChild(navPages);
}

document.addEventListener('DOMContentLoaded', loadHeader);