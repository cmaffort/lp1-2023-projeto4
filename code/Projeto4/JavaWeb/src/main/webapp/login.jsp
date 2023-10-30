<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style/header.css">
        <link rel="stylesheet" href="style/login.css">
        <title>JSP Page</title>
    </head>

    <body>
        <header></header>
    
        <h1>Entrar</h1>
        <form action="ServletLogin" method="get">
            <label for="login">Email:</label>
            <input type="email" id="login" name="login" required>
            <br><br>
            <label for="senha">Senha:</label>
            <input type="password" id="senha" name="senha" required>
            <br><br>
            <div id="acessar"><input type="submit" value="Acessar"></div>
        </form>

        <p>Não possui conta? <a href="cadastro.jsp">Cadastre-se</a></p>

        <script src="code/header.js"></script>
    </body>
</html>
