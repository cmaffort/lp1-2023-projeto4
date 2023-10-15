<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Cadastro Doador Pessoa Juridica</h1>
            <form action="#" method="post">
        
        <label for="nome">Nome completo:</label>
        <input type="text" id="nome" name="nome" required>
        <br><br>
        
        <label for="login">Endereço:</label>
        <input type="text" id="endereco" name="endereco" required>
        <br><br>
        
        <label for="login">Bairro:</label>
        <input type="text" id="bairro" name="bairro" required>
        <br><br>
        
        <label for="login">Cidade:</label>
        <input type="text" id="cidade" name="cidade" required>
        <br><br>
        <label for="login">CNPJ:</label>
        <input type="text" id="cidade" name="cidade" required>
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

</html>
