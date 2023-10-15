<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <form action="#" method="post">
        <label for="login">Login (Email):</label>
        <input type="email" id="login" name="login" required>
        <br><br>
        <label for="senha">Senha:</label>
        <input type="password" id="senha" name="senha" required>
        <br><br>
        <input type="submit" value="Entrar">
    </form>
        <p><a href="cadastro.jsp">Não possui conta ? Cadastre-se</a></p>
    </body>
</html>
