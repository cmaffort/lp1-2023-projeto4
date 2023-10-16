<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Cadastrar Doação</h1>
        <form>
                    <label for="quantidade">Quantidade:</label>
        <input type="number" id="quantidade" name="quantidade" required><br><br>

        <label>Estado do Produto:</label><br>
        <input type="radio" id="novo" name="estado_produto" value="novo">
        <label for="novo">Novo</label><br>
        <input type="radio" id="usado" name="estado_produto" value="usado">
        <label for="usado">Usado</label><br><br>

        <label for="especificacoes">Especificações:</label><br>
        <textarea id="especificacoes" name="especificacoes" rows="4" cols="50"></textarea><br><br>

        <label>Como fornecer o produto:</label><br>
        <input type="checkbox" id="entrega" name="fornecimento[]" value="entrega">
        <label for="entrega">Entrega</label><br>
        <input type="checkbox" id="busca" name="fornecimento[]" value="busca">
        <label for="busca">Busca</label><br><br>

        <input type="submit" value="Enviar Pedido">

        </form>
    </body>
</html>
