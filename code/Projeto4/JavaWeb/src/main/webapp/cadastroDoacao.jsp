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

            
            <a href="gestaoGeral.jsp">Texto a ser exibido</a>
            
            <form action="CadastrarDoacaoServlet" method="post">
                <figure id="logo">
                    <img src="img/logo-cefet.png">
                </figure>
                <div class="campo">
                    <label for="nome">Quantidade:</label>
                    <input type="text" id="quantidade" name="quantidade" required>
                </div><div class="campo">
                    <label for="status">Estado do Produto:</label>
                    <select id="opcoes" name="opcoes" form="opcoes">
                        <option value="" disabled selected>Selecione</option>    
                        <option value="funcionando">Funcionando</option>
                        <option value="quebrados">Quebrado</option>
                        <option value="faltandoPeca">Faltando Peça</option>
                        <option value="algunsDefeitos">Alguns defeitos</option>
                    </select>
                </div><div class="campo">
                    <label for="nome">Modelo:</label>
                    <input type="text" id="modelo" name="modelo" required>
                </div><div class="campo">
                    <label for="marca">Marca:</label>
                    <input type="text" id="marca" name="marca" required>
                </div><div class="campo">
                    <label for="quantidadeRAM">Quantidade de RAM:</label>
                    <input type="text" id="quantidadeRAM" name="quantidadeRAM" required>
                </div><div class="campo">
                    <label for="formaEntrega">Como deseja fornecer o produto:</label>
                    <ul>
                        <li>
                            <label>
                                <input type="radio" name="formaEntrega" value="op1" id="entrega"> Entrega
                            </label>
                        </li>
                        <li>
                            <label>
                                <input type="radio" name="formaEntrega" value="op2" id="busca"> Busca
                            </label>
                        </li>
                    </ul>
                </div><div class="campo">
                    <label for="data">Data:</label>
                    <input type="date" name="data">
                </div><div id="submit">
                    <input type="submit" value="Cadastrar">
                </div>
            </form>
        </main>
            
        <script src="code/header.js"></script>
    </body>
</html>