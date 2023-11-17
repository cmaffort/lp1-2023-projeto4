<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
        <link rel="stylesheet" href="style/agendamentoEntrega.css">
        <title>Agendar Entrega da Doação</title>
    </head>
    <body>
        <header></header>

        <main>
            <h2>Agende aqui a melhor data para retirar seu pc</h2>

            <form action="EntregaDoacao" method="post">
                <figure id="logo">
                    <img src="img/logo-cefet.png">
                </figure>
                <div class="campo">
                    <label for="dataRetirada"> selecione a data: </label>
                    <input type="date" name="dataRetirada">
                </div><div class="campo">
                    <label for="horaRetirada"> selecione o horário: </label>
                    <input type="time" name="horaRetirada">
                </div><div id="submit">
                    <input type="submit" name="agendar" value="Agendar">
                </div>
                <p> <br>Documentos necessários para a retirada: <br>
                    • identidade ou outro documento com foto</p>
            </form>
        </main>
        
        <script src="code/header.js"></script>
    </body>
</html>