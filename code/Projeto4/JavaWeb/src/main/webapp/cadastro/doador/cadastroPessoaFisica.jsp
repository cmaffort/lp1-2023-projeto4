<%-- 
    Document   : cadastroPessoaFisica
    Created on : 15 de out de 2023, 08:28:02
    Author     : laura
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Cadastro Doador Pessoa Fisica</h1>
    <form action="DoadorFisicaServlet" method="post">
        
        <label for="nome">Nome completo:</label>
        <input type="text" id="nome" name="nome" required>
        <br><br>
        
        <label for="login">CPF:</label>
        <input type="text" id="cpf" name="cpf" required>
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

        <div id="submit"><input type="submit" value="Cadastrar"></div>
    </form>

    </body>
</html>
