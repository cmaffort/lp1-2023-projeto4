<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="br.cefetmg.projeto4.dto.UsuarioDTO"%>

<%
    String status = request.getParameter("status");
    String error = request.getParameter("e");

    if (session == null || session.getAttribute("usuario") == null) {
        response.sendRedirect("login.jsp?p=cadastroCompra.jsp");
        return;
    }

    UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("usuario");

    if (!usuario.getTipo().equals("PROFESSOR") && !usuario.getTipo().equals("ESTAGIARIO")) {
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
        <link rel="stylesheet" href="style/cadastroDoacao.css">
        <title>Cadastrar Compra</title>
    </head>

    <body>
        <header></header>

        <main>
            <h2>Cadastrar Compra</h2>

            <form action="compra" method="post">
                <figure id="logo">
                    <img src="img/logo-cefet.png">
                </figure>

<%
    if (status != null && status.equals("fail")) {
%>
                <p class="fail">Tente novamente</p>
<%
    } else if (error != null && error.equals("id")) {
%>
                <p class="fail">Código inválido</p>
<%
    }
%>     

                <div class="campo">           
                    <label>Código peça:
                    <input type="number" id="codigo" name="codigo" required></label> 
                </div><div class="campo">
                    <label for="nome">Quantidade: </label>
                    <input type="number" id="quantidade" name="quantidade" required>
                </div><div class="campo">
                    <label for="valor">Valor unitário: </label>
                    <input type="text" name="valor" pattern="^\d+([\.,]\d{1,2})?$" required>
                </div><div id="submit">
                    <input type="submit" value="Cadastrar">
                </div>
            </form>
        </main>
            
        <script src="code/header.js"></script>
        <script src="code/refresh.js"></script>
    </body>
</html>