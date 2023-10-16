const headerEl = document.querySelector('header');
const imgs = [
    'img/logo-cefet.png',
    'img/pedido.png',
    'img/suporte.png',
    'img/login.png',
    'img/sobre-nos.png',
    'img/doacao.png'
    ];
const alts = [
    'Logo CEFET',
    'Fazer pedido',
    'Suporte',
    'Login',
    'Sobre nós',
    'Fazer doação'
    ];
const links = [
    'pedido.html', 
    'suporte.html',
    'login.jsp',
    'sobre-nos.html',
    'doacao.html'
    ];

function newEl(tag, ...classNames) {
    const el = document.createElement(tag);

    for (const className of classNames)
        el.classList.add(className);

    return el;
}

function newImg(src, alt = null, ...classNames) {
    const img = newEl('img', ...classNames);

    img.src = src;

    if (alt != null)
        img.alt = alt;

    return img;
}

function newFigure(img, text = null, evt = null, response = null, ...classNames) {
    const figure = newEl('figure', ...classNames);
    
    figure.appendChild(img);

    if (text != null) {
        const textEl = newEl('p');

        textEl.innerHTML = text;

        figure.append(textEl);
    }
    if (evt != null)
        figure.addEventListener(evt, response);

    return figure;
}

function newNav(...classNames) {
    const nav = newEl('nav', ...classNames);

    for (let i = 0; i < links.length; ++i) {
        const img = newImg(imgs[i + 1]);
        const figure = newFigure(img, alts[i + 1], 'click', () => redirect(links[i]));

        nav.appendChild(figure);
    }

    return nav;
}

function redirect(href) {
    window.location.href = href;
}

function loadHeader() {
    const logo = newImg(imgs[0], alts[0]);
    const nav = newNav();

    headerEl.appendChild(logo);
    headerEl.appendChild(nav);
}

document.addEventListener('DOMContentLoaded', loadHeader);