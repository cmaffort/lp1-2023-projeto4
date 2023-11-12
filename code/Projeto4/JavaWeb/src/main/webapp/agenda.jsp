<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="br.cefetmg.projeto4.dao.mysql.MySqlConnection"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style/header.css">
    <link rel="stylesheet" href="style/main.css">
    <link rel="stylesheet" href="style/agenda.css">
    <link rel="stylesheet" href="style/table.css">
    <title>Agenda de doações</title>
</head>
<body>
    <header></header>

    <main>
<%
    try {
        MySqlConnection mySqlConnection = new MySqlConnection();

        try (Connection connection = mySqlConnection.getConexao()) {
            String sql = "SELECT agendamentos.data, agendamentos.horario, usuarios.nome, usuarios.email FROM `agendamentos` JOIN `usuarios` ON agendamentos.id_donatario = usuarios.id;";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
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
            while(resultSet.next()) {
                String data = resultSet.getString("data");
                String horario = resultSet.getString("horario");
                String nome = resultSet.getString("nome");
                String email = resultSet.getString("email");                
%>
                <tr>
                    <td><%=data%></td>
                    <td><%=horario%></td>
                    <td><%=nome%></td>
                    <td><%=email%></td>
                </tr>
<% 
            }
            resultSet.close();
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