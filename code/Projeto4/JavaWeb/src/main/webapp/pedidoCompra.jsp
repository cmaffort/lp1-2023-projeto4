<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.List"%>
<%@page import="br.cefetmg.projeto4.dto.UsuarioDTO"%>
<%@page import="br.cefetmg.projeto4.dao.CompraDAO"%>
<%@page import="br.cefetmg.projeto4.dto.CompraDTO"%>

<%
    if (session == null || session.getAttribute("usuario") == null) {
        response.sendRedirect("login.jsp?p=pedidoCompra.jsp");
        return;
    }

    UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("usuario");

    if (!usuario.getTipo().equals("PROFESSOR") && !usuario.getTipo().equals("ESTAGIARIO")) {
        response.sendRedirect("negado.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style/header.css">
    <link rel="stylesheet" href="style/main.css">
    <link rel="stylesheet" href="style/exception.css">
    <link rel="stylesheet" href="style/table.css">
    <title>Pedidos de Compra</title>
</head>

<body>
    <header></header>

    <main>
<%
    try (CompraDAO compraDAO = new CompraDAO()) {
        List<CompraDTO> pedidos = compraDAO.listar();
%>
        <table id="compra" class="hideable hidden">
            <caption>Pedidos</caption>
            <thead>
                <tr>
                    <th>Peça</th>
                    <th>Marca</th>
                    <th>Quantidade</th>
                    <th>Valor (un.)</th>
                </tr>
            </thead>
            <tbody>
<%
        for (CompraDTO pedido : pedidos) {
            double valorUnitario = pedido.getValorUnitario();
            DecimalFormat df = new DecimalFormat("0.00");
            String formattedValorUnitario = "R$" + df.format(valorUnitario);
%>
                <tr>
                    <td><%=pedido.getNome()%></td>
                    <td><%=pedido.getMarca()%></td>
                    <td><%=pedido.getQuantidade()%></td>
                    <td><%=formattedValorUnitario%></td>
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
            <h2>Erro ao carregar pedidos de compra</h2>
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