<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <h1>Donatario</h1>
        <form action="DonatarioCadastro" method="post">
        
        <label for="nome">Nome completo:</label>
        <input type="text" id="nome" name="nome" required>
        <br><br>
        <label for="serie">Serie:</label>
        <input type="number" id="serie" name="serie" required>
        <br><br>

        
        <label for="escola">Escola:</label>
        <input type="text" id="escola" name="escola" required>
        <br><br>
        <label for="endereco">Endereço:</label>
        <input type="text" id="endereco" name="endereco" required>
        <br><br>
        
        <label for="login">CPF:</label>
        <input type="text" id="cpf" name="cpf" required>
        <br><br>
        
        <label for="bairro">Bairro:</label>
        <input type="text" id="bairro" name="bairro" required>
        <br><br>
        
        <label for="cidade">Cidade:</label>
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

        <div id="submit"><input type="submit" value="Cadastrar"></div>
    </form>
    
    </body>
</html>
