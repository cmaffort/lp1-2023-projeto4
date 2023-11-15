<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <form action="DoadorJuridicoServlet" method="post">
            <figure id="logo">
                <img src="img/logo-cefet.png">
            </figure>
            <div class="campo"> 
                <label for="nome">Nome empresa:</label>
                <input type="text" id="nome" name="nome" required>
            </div><div class="campo">       
                <label for="login">Endereço:</label>
                <input type="text" id="endereco" name="endereco" required>
            </div><div class="campo"> 
                <label for="login">Bairro:</label>
                <input type="text" id="bairro" name="bairro" required>
            </div><div class="campo">  
                <label for="login">Cidade:</label>
                <input type="text" id="cidade" name="cidade" required>
            </div><div class="campo"> 
                <label for="login">CNPJ:</label>
                <input type="text" id="cnpj" name="cnpj" required>
            </div><div class="campo"> 
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required>
            </div><div class="campo"> 
                <label for="senha">Senha:</label>
                <input type="password" id="senha" name="senha" required>
            </div><div class="campo"> 
                <label for="confirmarSenha">Confirmar Senha:</label>
                <input type="password" id="confirmarSenha" name="confirmarSenha" required>
            </div><div id="submit">
                <input type="submit" value="Cadastrar">
            </div>
        </form>
    </body>
</html>