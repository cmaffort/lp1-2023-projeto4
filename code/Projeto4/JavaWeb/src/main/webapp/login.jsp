<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style/header.css">
        <link rel="stylesheet" href="style/login.css">
        <title>Login</title>
    </head>

    <body>
        <header></header>
    
        <main>
            <form action="ServletLogin" method="get">
                <figure>
                    <img src="img/logo-cefet.png">
                </figure>
                <div class="campo">    
                    <label for="login">Email:</label>
                    <input type="email" id="login" name="login" required>
                </div><div class="campo">    
                    <label for="senha">Senha:</label>
                    <input type="password" id="senha" name="senha" required>
                </div><div id="acessar">
                    <input type="submit" value="Acessar">
                </div>

                <p>Não possui conta? <a href="cadastro.jsp">Cadastre-se</a></p>
            </form>
        </main>

        <script src="code/header.js"></script>
    </body>
</html>
