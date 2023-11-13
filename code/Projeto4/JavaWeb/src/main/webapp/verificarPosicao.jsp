<%--
    Document   : verificarPosicao
    Created on : 11 de nov. de 2023, 11:58:38
    Author     : lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.cefetmg.projeto4.dao.DonatarioDAO"%> <!-- Importe o pacote DonatarioDAO -->

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
    <main>
        <form action="ServletLogin" method="post"> <!-- Altere o método para POST -->
            <figure id="logo">
                <img src="img/logo-cefet.png">
            </figure>
            <div class="campo">
                <label for="login">Email:</label>
                <input type="email" id="login" name="login" required>
            </div>
            <div class="campo">
                <label for="senha">Senha:</label>
                <input type="password" id="senha" name="senha" required>
            </div>
            <div id="submit">
                <input type="submit" value="Acessar">
            </div>
        </form>

        <%-- Verifique se os dados foram enviados --%>
        <%
            String login = request.getParameter("login");
            String senha = request.getParameter("senha");

            if (login != null && senha != null) {
                DonatarioDAO donatarioDAO = new DonatarioDAO();
                int posicaoFila = donatarioDAO.getPosicaoFila(login, senha);

                if (posicaoFila != -1) {
        %>
                    <div id="posicaoFila">
                        Posição na fila: <%= posicaoFila %>
                    </div>
        <%
                } else {
        %>
                    <div id="posicaoFila">
                        Dados inválidos. Por favor, verifique seu login e senha.
                    </div>
        <%
                }
            }
        %>
    </main>
</body>
</html>
