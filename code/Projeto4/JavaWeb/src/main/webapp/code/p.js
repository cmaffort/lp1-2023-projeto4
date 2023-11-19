function getParameterByName(name, url) {
    if (!url) url = window.location.href;

    name = name.replace(/[\[\]]/g, "\\$&");

    const regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)");
    const results = regex.exec(url);
    
    if (!results) 
        return null;
    if (!results[2]) 
        return '';
    return decodeURIComponent(results[2].replace(/\+/g, " "));
}

function addHiddenInput() {
    const pValue = getParameterByName('p');

    if (pValue) {
        const pInput = document.createElement('input');

        pInput.type = 'hidden';
        pInput.name = 'p';
        pInput.value = pValue;

        document.querySelector('form').appendChild(pInput);
    }
}

document.addEventListener('DOMContentLoaded', addHiddenInput);