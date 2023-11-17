<%-- 
    Document   : deletarConta
    Created on : 9 de nov. de 2023, 15:34:54
    Author     : lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style/header.css">
        <link rel="stylesheet" href="style/main.css">
        <title>JSP Page</title>
    </head>
    <body>
        <header></header>

        <main>
            <form action="ServletDeletarConta" method="post">
                <figure id="logo">
                    <img src="img/logo-cefet.png">
                </figure>
                <p class="danger"> Tem certeza que quer deletar conta?</p>
                <div class="campo">    
                    <label for="senha">Digite sua senha:</label>
                    <input type="password" id="senha" name="senha" required>
                </div><div id="submit">
                    <input type="submit" value="Deletar">
                </div>

            </form>
        </main>

        <script src="code/header.js"></script>
    </body>
</html>
