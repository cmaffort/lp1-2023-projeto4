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
    <title>Agenda de doações</title>
</head>
<body>
    <header></header>

    <main>
<%
    try {
        MySqlConnection mySqlConnection = new MySqlConnection();

        try (Connection connection = mySqlConnection.getConexao()) {
            String sql = "SELECT * FROM agendamentos";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
%>
        <table>
            <caption>Doações Agendadas</caption>
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Data</th>
                    <th>Horario</th>
                    <th>Id Donatario</th>
                </tr>
            </thead>
            <tbody>
<%
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String data = resultSet.getString("data");
                String horario = resultSet.getString("horario");
                int idDonatario = resultSet.getInt("id_donatario");
%>
                <tr>
                    <td><%=id%></td>
                    <td><%=data%></td>
                    <td><%=horario%></td>
                    <td><%=idDonatario%></td>
                </tr>
<% 
            }
        }
%>
            </tbody>
        </table>
<%
    } catch (Exception e) {
%>
        <p><%=e.getMessage()%></p>
<%        
    }
%>
    </main>

    <script src="code/header.js"></script>
</body>
</html>