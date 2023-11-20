function removeParameterFromURL(parameterName) {
    const url = window.location.href;
    const urlWithoutParameter = url.replace(new RegExp('[?&]' + parameterName + '=[^&#]*(#.*)?$'), '$1');
    
    window.history.replaceState({}, document.title, urlWithoutParameter);
}

removeParameterFromURL('status');
removeParameterFromURL('e');