<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="style/header.css">
    <link rel="stylesheet" href="style/signup.css">
    <title>AJAX JSP Example</title>
</head>
<body>
    <header></header>

    <nav id="type">
        <button id="donatario">Donatario</button>
        <button id="professor">Professor</button>
        <button id="estagiario">Estagiario</button>
        <button id="doadorF">Doador Pessoa Fisica</button>
        <button id="doadorJ">Doador Pessoa Juridica</button>
    </nav>

    <div id="dynamicContent">Selecione o modo de cadastro</div>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="code/header.js"></script>
    <script src="code/cadastro.js"></script>
</body>
</html>
