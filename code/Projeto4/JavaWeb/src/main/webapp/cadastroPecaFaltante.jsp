<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <form action="PecaFaltanteServlet" method="post">
            <figure id="logo">
                <img src="img/logo-cefet.png">
            </figure>
            <div class="campo">
                <label for="nome">Nome peça:</label>
                <input type="text" id="nome" name="nome" required>
                <label for="nome">Marca:</label>
                <input type="text" id="marca" name="marca" required>
                <label for="nome">Quantidade: </label>
                <input type="number" id="quantidade" name="quantidade" required>

            </div><div id="submit">
                <input type="submit" value="Cadastrar">
            </div>
        </form>
    </body>
</html>