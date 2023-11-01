<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <form action="EstagiarioServlet" method="post">
            <div class="campo"> 
                <label for="nome">Nome completo:</label>
                <input type="text" id="nome" name="nome" required>
            </div><div class="campo"> 
                <label for="curso">Curso: </label>
                <input type="text" id="curso" name="curso" required>
            </div><div class="campo">         
                <label for="curso">Serie/Periodo: </label>
                <input type="number" id="serie" name="serie" required> 
            </div><div class="campo"> 
                <label for="login">CPF: </label>
                <input type="text" id="cpf" name="cpf" required> 
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