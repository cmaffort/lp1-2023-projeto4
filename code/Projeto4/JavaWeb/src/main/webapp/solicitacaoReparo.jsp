<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="style/header.css">
    <link rel="stylesheet" href="style/main.css">
    <link rel="stylesheet" href="style/solicitacaoReparo.css">
    <title>Solicitação de reparo</title>
</head>
<body>
    <header></header>

    <main>
        <h2>Solicitação de Reparo</h2>

        <form action="SolicitacaoReparoServlet" method="post">
            <figure id="logo">
                <img src="img/logo-cefet.png">
            </figure>
            <p>Qual é o problema?</p>
            <label>
                <input type="radio" name="especificacoes" value="pecas_faltando"> Peças Faltando
            </label><br>
            <label>
                <input type="radio" name="especificacoes" value="mal_funcionamento"> Mal Funcionamento
            </label><br>
            <label>
                <input type="radio" name="especificacoes" value="outro"> Outro
            </label><br>

            <label for="problema">Descrição do Problema:</label>
            <input type="text" id="problema" name="problema" required>

            <div id="submit">
                <input type="submit" value="Solicitar">
            </div>
        </form>
    </main>

    <script src="code/header.js"></script>
</body>
</html>
