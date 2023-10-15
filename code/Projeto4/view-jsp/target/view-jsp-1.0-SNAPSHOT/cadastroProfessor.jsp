

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Professor</h1>
    <form action="#" method="post">
        
        <label for="nome">Nome completo:</label>
        <input type="text" id="nome" name="nome" required>
        <br><br>
        
        <label for="login">Departamento: </label>
        <input type="text" id="escola" name="escola" required>
        <br><br>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>
        <br><br>
        <label for="senha">Senha:</label>
        <input type="password" id="senha" name="senha" required>
        <br><br>
        <label for="confirmarSenha">Confirmar Senha:</label>
        <input type="password" id="confirmarSenha" name="confirmarSenha" required>
        <br><br>

        <input type="submit" value="Cadastrar">
    </form>
    </body>
</html>
