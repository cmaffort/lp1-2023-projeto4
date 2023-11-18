<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.cefetmg.projeto4.dto.UsuarioDTO"%>

<%
    if (session == null || session.getAttribute("usuario") == null) {
        response.sendRedirect("login.jsp?p=feedback.jsp");
        return;
    }

    UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("usuario");

    if (!usuario.getTipo().equals("DONATARIO")) {
        response.sendRedirect("negado.jsp");
        return;
    }

    String status = request.getParameter("status");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style/header.css">
        <link rel="stylesheet" href="style/main.css">
        <link rel="stylesheet" href="style/feedback.css">
        <title>Dê seu feedback!</title>
    </head>
    <body>
        <header></header>

        <main id="feedbackBox">
            <h2>Feedback</h2>

            <form action="feedback" method="get">
                <figure id="logo">
                    <img src="img/logo-cefet.png">
                </figure>
<%
    if (status != null && status.equals("fail")) {
%>
            <p class="fail">Não foi possível enviar seu feedback, tente novamente</p>
<%
    } else if (status != null && status.equals("success")) {
%>
            <p class="success">Feedback enviado!</p>
<%
    }
%>
                <section id="rating">
                    <label>
                        <input type="radio" name="rating" value="0" checked>
                    </label><label>
                        <input type="radio" name="rating" value="1">
                        <i class="fa-solid fa-star star"></i>
                    </label><label>
                        <input type="radio" name="rating" value="2">
                        <i class="fa-solid fa-star star"></i>
                    </label><label>
                        <input type="radio" name="rating" value="3">
                        <i class="fa-solid fa-star star"></i>
                    </label><label>
                        <input type="radio" name="rating" value="4">
                        <i class="fa-solid fa-star star"></i>
                    </label><label>
                        <input type="radio" name="rating" value="5">
                        <i class="fa-solid fa-star star"></i>
                    </label>
                </section>

                <textarea name="comments" rows="4" cols="50" placeholder="Descreva a sua experiência" required></textarea>

                <div id="submit">
                    <input type="submit" value="Enviar">
                </div>
            </form>
        </main>

        <script src="code/header.js"></script>
        <script src="code/feedback.js"></script>
        <script src="https://kit.fontawesome.com/5e2c2b2fc2.js" crossorigin="anonymous"></script>
    </body>
</html>