<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="java.util.List"%>
<%@page import="br.cefetmg.projeto4.dao.MantecaoDAO"%>
<%@page import="br.cefetmg.projeto4.dto.MantecaoDTO"%>
<%@page import="br.cefetmg.projeto4.dto.UsuarioDTO"%>

<%
    if (session == null || session.getAttribute("usuario") == null) {
        response.sendRedirect("login.jsp?p=mostraManutencoes.jsp");
        return;
    }

    UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("usuario");

    if (!usuario.getTipo().equals("PROFESSOR") && !usuario.getTipo().equals("ESTAGIARIO")) {
        response.sendRedirect("negado.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style/header.css">
    <link rel="stylesheet" href="style/main.css">
    <link rel="stylesheet" href="style/exception.css">
    <link rel="stylesheet" href="style/table.css">
    <title>Manutenções</title>
</head>
<body>
    <header></header>

    <main>
<%
    try (MantecaoDAO mantecaoDAO = new MantecaoDAO()) {
        List<MantecaoDTO> mantecoes = mantecaoDAO.listar();
%>
        <table class="hidden hideable">
            <caption>Manutenções</caption>
            <thead>
                <tr>
                    <th>Data entrega</th>
                    <th>Estado</th>
                    <th>Email donatario</th>
                    <th>Email arrumador</th>
                </tr>
            </thead>
            <tbody>
<%
        for (MantecaoDTO mantecao : mantecoes) {             
%>
                <tr>
                    <td><%=mantecao.getData()%></td>
                    <td><%=mantecao.getEstado()%></td>
                    <td><%=mantecao.getEmailDonatario()%></td>
                    <td><%=mantecao.getEmailArrumador()%></td>
                </tr>
<% 
        }
%>
            </tbody>
        </table>
<%
    } catch (Exception e) {
%>
        <div id="exception">
            <h2>Erro ao carregar manutenções</h2>
            <p>Descrição: <%=e.getMessage()%></p>
        </div>
<%        
    }
%>
    </main>

    <script src="code/header.js"></script>
    <script src="code/th.js"></script>
    <script src="code/exception.js"></script>
</body>
</html>
