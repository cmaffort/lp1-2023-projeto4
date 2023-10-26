<%-- 
    Document   : cadastrarComputador
    Created on : 15 de out de 2023, 10:26:03
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
        <header></header>
    
        <h1>Cadastro de Computador</h1>  
        
        <form action="#" method="post">
            <label for="nome">Marca:</label>
            <input type="text" id="nome" name="nome" required>
            <br>
            <br>
            <label for="curso">Quantidade de RAM:</label>
            <input type="number" id="curso" name="curso" required> 
            <br>
            <br>        
            <label for="email">Armazenamento interno:</label>
            <input type="email" id="email" name="email" required>
            <br>
            <br>        
            <label for="senha">Processador:</label>
            <input type="password" id="senha" name="senha" required>
            <br>
            <br>
            
            <label for="confirmarSenha">Quando a máquina foi adquirida:</label>
            <input type="password" id="confirmarSenha" name="confirmarSenha" required>
            <br>
            <br>        
            <label for="confirmarSenha">Senha:</label>
            <input type="password" id="confirmarSenha" name="confirmarSenha" required>
            <br>
            <br>
            
            <div id="Cadastrar"><input type="submit" value="Cadastrar"></div>
        </form>
    
    <script src="code/header.js"></script>
    </body>
</html>
