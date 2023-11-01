<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Solicitação de reparo</title>
    </head>
    <body>
        <h1>Solicitação de Reparo</h1>
        <form>
        <p>Qual é o problema</p>
        <label>
            <input type="radio" name="issue" value="pecas_faltando"> Peças Faltando
        </label><br>
        <label>
            <input type="radio" name="issue" value="mal_funcionamento"> Mal Funcionamento
        </label><br>
        <label>
            <input type="radio" name="issue" value="outro"> Outro
        </label><br>

        <p>Especifique o problema:</p>
        <textarea name="details" rows="4" cols="50"></textarea><br>

        <input type="submit" value="Submit">
    </form>

    </body>
</html>
