<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="br.cefetmg.projeto4.dto.UsuarioDTO"%>

<%
    String status = request.getParameter("status");
    String error = request.getParameter("e");

    if (session == null || session.getAttribute("usuario") == null) {
        response.sendRedirect("login.jsp?p=manterComputador.jsp");
        return;
    }

    UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("usuario");

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
<%
    if (status != null) {
        if (status.equals("fail")) {
%>
            <p class="fail">Tente novamente</p>
<%
        } else if (status.equals("success")) {
%>
            <p class="success">Manutenção registrada</p>
<%
        } 
    } else if (error != null && error.equals("email")) {
%>
            <p class="fail">Email inválido</p>
<%
    }
%>
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
            <label for="email">Quem reparou o pc? (email):</label>
            <input type="email" name="email">
            </div>

            <div id="submit">
                <input type="submit" value="Enviar">
            </div>
        </form>
    </main>

    <script src="code/header.js"></script>
    <script src="code/refresh.js"></script>
</body>

</html>