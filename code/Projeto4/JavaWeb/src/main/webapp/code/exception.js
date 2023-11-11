const main = document.querySelector('main');
const exception = document.getElementById('exception');

function fixContent() {
    const children = main.children;

    for (const child of children)
        if (child !== exception)
            main.removeChild(child);
}

function showTable() {
    tables[0].style.opacity = 1;
}

document.addEventListener('DOMContentLoaded', () => {
    if (exception)
        fixContent();
    if (tables[0])
        showTable();
})