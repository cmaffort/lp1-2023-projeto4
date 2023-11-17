<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="br.cefetmg.projeto4.dao.EstoqueDAO"%>
<%@page import="br.cefetmg.projeto4.dto.ItemEstoqueDTO"%>

<%
    if (session == null || session.getAttribute("usuario") == null) {
        response.sendRedirect("login.jsp");
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
    <title>Estoque</title>
</head>
<body>
    <header></header>

    <main>
<%
    try {
        EstoqueDAO estoqueDAO = new EstoqueDAO();
        List<ItemEstoqueDTO> itens = estoqueDAO.listar();
%>
        <table id="estoque">
            <caption>Estoque</caption>
            <thead>
                <tr>
                    <th>Tipo</th>
                    <th>Quantidade</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody>
<%
        for (ItemEstoqueDTO item : itens) {
%>
                <tr>
                    <td><%=item.getTipo()%></td>
                    <td><%=item.getQuantidade()%></td>
                    <td><%=item.getStatus()%></td>
                </tr>
<%
        }
%>
            </tbody>
            <tfoot>
                <tr>
                    <td colspan="3">
                        <button onclick="redirect('cadastroPecaFaltante.jsp')">Relatar peças faltantes</button>
                    </td>
                </tr>
            </tfoot>
        </table>
<%
    } catch (Exception e) {
%>
        <div id="exception">
            <h2>Erro ao carregar estoque</h2>
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