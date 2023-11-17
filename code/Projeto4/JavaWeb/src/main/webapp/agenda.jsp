<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="br.cefetmg.projeto4.dao.AgendamentoDAO"%>
<%@page import="br.cefetmg.projeto4.dto.AgendamentoDTO"%>

<%
    if (session == null || session.getAttribute("usuario") == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    UsuarioDTO usuario = session.getAttribute("usuario");

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
    <title>Agenda de doações</title>
</head>
<body>
    <header></header>

    <main>
<%
    try {
        AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
        List<AgendamentoDTO> agendamentos = agendamentoDAO.listar();
%>
        <table>
            <caption>Doações Agendadas</caption>
            <thead>
                <tr>
                    <th>Data</th>
                    <th>Horario</th>
                    <th>Nome donatario</th>
                    <th>Email donatario</th>
                </tr>
            </thead>
            <tbody>
<%
        for (AgendamentoDTO agendamento : agendamentos) { 
            DonatarioDTO donatario = agendamento.getDonatario();                
%>
                <tr>
                    <td><%=agendamento.getData()%></td>
                    <td><%=agendamento.getHorario()%></td>
                    <td><%=donatario.getNome()%></td>
                    <td><%=donatario.getEmail()%></td>
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
            <h2>Erro ao carregar agenda</h2>
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