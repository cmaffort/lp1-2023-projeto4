<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    if (session == null || session.getAttribute("usuario") == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    UsuarioDTO usuario = session.getAttribute("usuario");

    if (!usuario.getTipo().equals("DONATARIO")) {
        response.sendRedirect("negado.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="style/header.css">
    <link rel="stylesheet" href="style/main.css">
    <title>Manter Computador</title>
</head>

<body>
    <header></header>

    <main>
        <form action="mantecao" method="get"> 
            <figure id="logo">
                <img src="img/logo-cefet.png">
            </figure>

            <div class="campo"> 
            <label for="data">Data da retirada: </label>
            <input type="date" id="retirada" name="retirada">
            </div>

            <div class="campo">
            <label for="estado">Estado do pc retirado: </label>
            <select name="estado" id="estado">
                <option value="" disabled selected>Selecione</option>
                <option value="FUNCIONANDO">Funcionando </option>
                <option value="QUEBRADO">Quebrado</option>
                <option value="FALTANDO_PECA">Faltando Peça</option>
                <option value="DEFEITUOSO">Alguns defeitos</option>
            </select>
            </div>

            <div class="campo">
            <label for="reparo">Quem reparou o pc? </label>
            <input type="email" id="reparo" name="reparo">
            </div>

            <div id="submit">
                <input type="submit" value="submit">
            </div>
        </form>
    </main>

    <script src="code/header.js"></script>
</body>

</html>