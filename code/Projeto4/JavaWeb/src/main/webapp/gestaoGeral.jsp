
@@ -0,0 +1,63 @@
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style/header.css">
        <link rel="stylesheet" href="style/main.css">
        <link rel="stylesheet" href="style/gestaoGeral.css">
        <title>Gestão Geral</title>
    </head>
    <body>
        <header></header>

        <div id="menuGeral">

            <ul>

                <li> <span id="botaoDoadores"> Doadores </span> </li>
                <li> <span id="botaoDoacoes"> Doações </span> </li>
                <li> <span id="botaoGeral"> Relatório geral </span> </li>
                <li> <span id="botaoManutencoes"> Manutenções </span> </li>
                <li> <span id="botaoFuncionarios"> Funcionários </span> </li>
            </ul>


        </div>

        <main id="doadores">

            <h1>Doadores</h1>

        </main>
        <main id="doacoes">

            <h1>Doacões</h1>


        </main>
        <main id="geral">

            <h1>Relatório Geral</h1>


        </main>
        <main id="manutencoes">

            <h1> Manutencões </h1>


        </main>
        <main id="funcionario">

            <h1> Funcionários </h1>



        </main>


        <script src="code/gestaoGeral.js"></script>
        <script src="code/header.js"></script>
    </body>
</html>
