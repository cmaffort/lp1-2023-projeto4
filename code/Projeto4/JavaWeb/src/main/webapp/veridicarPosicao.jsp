<%-- 
    Document   : veridicarPosicao
    Created on : 11 de nov. de 2023, 11:58:38
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
            <form action="VerificarPosicao" method="get">
                <figure id="logo">
                    <img src="img/logo-cefet.png">
                </figure>
                <div class="campo">    
                    <label for="login">Email:</label>
                    <input type="email" id="login" name="login" required>
                </div><div class="campo">    
                    <input type="submit" value="Acessar">
                </div>

    </body>
</html>
