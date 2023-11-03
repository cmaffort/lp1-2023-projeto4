<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <form action="ProfessorServlet" method="post">
            <figure id="logo">
                <img src="img/logo-cefet.png">
            </figure>
            <div class="campo"> 
                <label for="nome">Nome completo:</label>
                <input type="text" id="nome" name="nome" required>
            </div><div class="campo"> 
                <label for="login">CPF:</label>
                <input type="text" id="cpf" name="cpf" required>
            </div><div class="campo"> 
                <label for="login">Departamento: </label>
                <input type="text" id="departamento" name="departamento" required>
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