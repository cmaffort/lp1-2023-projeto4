<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style/header.css">
        <link rel="stylesheet" href="style/main.css">
        <link rel="stylesheet" href="style/cadastroDoacao.css">
        <title>Cadastrar Doação</title>
    </head>

    <body>
        <header></header>

        <main>
            <h2>Cadastrar Doação</h2>

            <form action="PecaFaltanteServlet" method="post">
                <figure id="logo">
                    <img src="img/logo-cefet.png">
                </figure>
                <div class="campo">
                
                <label for="nome">Nome peça:</label>
                <input type="text" id="nome" name="nome" required>   
                </div><div class="campo">
                    <label for="nome">Marca:</label>
                <input type="text" id="marca" name="marca" required>
                
                </div><div class="campo">
                <label for="nome">Quantidade: </label>
                <input type="number" id="quantidade" name="quantidade" required>
 
                </div><div class="campo">
                 </div><div id="submit">
                    <input type="submit" value="Cadastrar">
                </div>
            </form>
        </main>
            
        <script src="code/header.js"></script>
    </body>
</html>