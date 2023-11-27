<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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

        <%@page import="br.cefetmg.projeto4.dto.*"%>
        <%@page        %>

        <header></header>



        <main id="doadores">

            <h1>Doadores</h1>




            <div class="esquerda">

                <img  src="img/pessoa-anonima.png" id="pessoaAnonima">

            </div>
            <div class="meioEsquerda">

                <img  src="img/pessoa-anonima.png" id="pessoaAnonima">

            </div>
            <div class="meioDireita">

                <img  src="img/pessoa-anonima.png" id="pessoaAnonima">

            </div>
            <div class="direita">

                <img  src="img/pessoa-anonima.png" id="pessoaAnonima">

            </div>

        </main>

        <main id="doacoes">

            <h1>Doacões</h1>

            <div class="esquerda">

                <img  src="img/pessoa-anonima.png" id="pessoaAnonima">

            </div>
            <div class="meioEsquerda">

                <img  src="img/pessoa-anonima.png" id="pessoaAnonima">

            </div>
            <div class="meioDireita">

                <img  src="img/pessoa-anonima.png" id="pessoaAnonima">

            </div>
            <div id="direita">

                <img  src="img/pessoa-anonima.png" id="pessoaAnonima">

            </div>


        </main>
        <main id="geral">

            <h1>Relatório Geral</h1>

            <div class="esquerda">

                <img  src="img/pessoa-anonima.png" id="pessoaAnonima">

            </div>
            <div class="meioEsquerda">

                <img  src="img/pessoa-anonima.png" id="pessoaAnonima">

            </div>
            <div class="meioDireita">

                <img  src="img/pessoa-anonima.png" id="pessoaAnonima">

            </div>
            <div class="direita">

                <img  src="img/pessoa-anonima.png" id="pessoaAnonima">

            </div>

        </main>
        <main id="manutencoes">

            <h1> Manutencões </h1>

            <div class="esquerda">

                <img  src="img/pessoa-anonima.png" id="pessoaAnonima">

            </div>
            <div class="meioEsquerda">

                <img  src="img/pessoa-anonima.png" id="pessoaAnonima">

            </div>
            <div class="meioDireita">

                <img  src="img/pessoa-anonima.png" id="pessoaAnonima">

            </div>
            <div class="direita">

                <img  src="img/pessoa-anonima.png" id="pessoaAnonima">

            </div>

        </main>
        <main id="funcionarios">

            <h1> Funcionários </h1>


            <div class="esquerda">

                <img  src="img/pessoa-anonima.png" id="pessoaAnonima">

            </div>
            <div class="meioEsquerda">

                <img  src="img/pessoa-anonima.png" id="pessoaAnonima">

            </div>
            <div class="meioDireita">

                <img  src="img/pessoa-anonima.png" id="pessoaAnonima">

            </div>
            <div class="direita">

                <img  src="img/pessoa-anonima.png" id="pessoaAnonima">

            </div>

        </main>

        <div id="menuGeral">
            <ul>
                <li> <button id="botaoDoadores"> Doadores</button> </li>
                <li> <button id="botaoDoacoes"> Doações</button> </li>
                <li> <button id="botaoGeral"> Relatório geral</button> </li>
                <li> <button id="botaoManutencoes"> Manutenções</button> </li>
                <li> <button id="botaoFuncionarios"> Funcionários</button></li>
            </ul>

        </div>  


        <script src="code/gestaoGeral.js"></script>
        <script src="code/header.js"></script>
    </body>
</html>
