<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String p = request.getParameter("p");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style/header.css">
        <link rel="stylesheet" href="style/main.css">
        <title>Login</title>
    </head>

    <body>
        <header></header>
    
        <main>
            <form action="ServletLogin" method="post">
                <figure id="logo">
                    <img src="img/logo-cefet.png">
                </figure>
<%
    if (p != null) {
%>
                <input type="hidden" name="p" value="<%=p%>">
<%
    }
%>
                <div class="campo">    
                    <label for="email">Email:</label>
                    <input type="email" id="email" name="email" required>
                </div><div class="campo">    
                    <label for="senha">Senha:</label>
                    <input type="password" id="senha" name="senha" required>
                </div><div id="submit">
                    <input type="submit" value="Acessar">
                </div>

                <p>Não possui conta? <a href='cadastro.jsp<%=p != null ? "?p=" + p : "" %>'>Cadastre-se</a></p>
            </form>
        </main>

        <script src="code/header.js"></script>
    </body>
</html>