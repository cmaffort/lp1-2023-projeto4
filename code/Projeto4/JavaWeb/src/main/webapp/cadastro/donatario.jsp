<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String p = request.getParameter("p");
%>
<!DOCTYPE html>
<html>
    <body>
        <form action="DonatarioCadastro" method="post">
            <figure id="logo">
                <img src="img/logo-cefet.png">
            </figure>
<%
    if (p != null) {
%>
            <input type="hidden" name="p" value="<%=p%>">
<%
    }
%>
            <div class="campo">
                <label for="nome">Nome completo:</label>
                <input type="text" id="nome" name="nome" required>
            </div><div class="campo">    
                <label for="serie">Serie:</label>
                <input type="number" id="serie" name="serie" required>
            </div><div class="campo">    
                <label for="escola">Escola:</label>
                <input type="text" id="escola" name="escola" required>
            </div><div class="campo">    
                <label for="endereco">Endereço:</label>
                <input type="text" id="endereco" name="endereco" required>
            </div><div class="campo">    
                <label for="login">CPF:</label>
                <input type="text" id="cpf" name="cpf" required>
            </div><div class="campo">    
                <label for="bairro">Bairro:</label>
                <input type="text" id="bairro" name="bairro" required>
            </div><div class="campo">     
                <label for="cidade">Cidade:</label>
                <input type="text" id="cidade" name="cidade" required>
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