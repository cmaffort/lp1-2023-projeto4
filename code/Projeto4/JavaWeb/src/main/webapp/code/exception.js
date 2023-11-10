const main = document.querySelector('main');
const exception = document.getElementById('exception');

function fixContent() {
    const children = main.children;

    for (const child of children)
        if (child !== exception)
            main.removeChild(child);
}

document.addEventListener('DOMContentLoaded', () => {
    if (exception)
        fixContent();
})