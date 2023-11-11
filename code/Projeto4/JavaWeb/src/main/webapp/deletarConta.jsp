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
        <title>JSP Page</title>
    </head>
    <body>
                <main>
            <form action="ServletDeletarConta" method="post">
                <figure id="logo">
                    <img src="img/logo-cefet.png">
                </figure>
                <div class="campo">    
                    <label for="login">Email:</label>
                    <input type="email" id="login" name="login" required>
                </div><div class="campo">    
                    <label for="senha">Senha:</label>
                    <input type="password" id="senha" name="senha" required>
                </div><div id="submit">
                    <input type="submit" value="Deletar">
                </div>

            </form>
        </main>

    </body>
</html>
