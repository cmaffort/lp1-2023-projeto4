<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style/header.css">
        <link rel="stylesheet" href="style/main.css">
        <link rel="stylesheet" href="style/form.css">
        <link rel="stylesheet" href="style/solicitacaoReparo.css">
        <title>Solicitação de reparo</title>
    </head>
    <body>
        <header></header>

        <main>
            <h2>Solicitação de Reparo</h2>

            <form>
                <figure id="logo">
                    <img src="img/logo-cefet.png">
                </figure>

                <p id="problema">Qual é o problema?</p>
                <label>
                    <input type="radio" name="issue" value="pecas_faltando"> Peças Faltando
                </label><br>
                <label>
                    <input type="radio" name="issue" value="mal_funcionamento"> Mal Funcionamento
                </label><br>
                <label>
                    <input type="radio" name="issue" value="outro"> Outro
                </label><br>

                <p id="texto">Especifique o problema:</p>
                <textarea name="details" rows="4" cols="50"></textarea><br>

                <div id="submit">
                    <input type="submit" value="Solicitar">
                </div>
            </form>
        </main>

        <script src="code/header.js"></script>
    </body>
</html>