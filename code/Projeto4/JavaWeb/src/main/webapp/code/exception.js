const main = document.querySelector('main');
const hideable = document.querySelector('.hideable');
const exception = document.getElementById('exception');

function fixContent() {
    main.removeChild(hideable);
}

function showContent() {
    hideable.classList.remove('hidden');
}

document.addEventListener('DOMContentLoaded', () => {
    if (exception)
        fixContent();
    if (hideable)
        showContent();
});