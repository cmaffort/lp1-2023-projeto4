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
            String sql = "SELECT * FROM `agendamentos`";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
%>
        <table>
            <caption>Doações Agendadas</caption>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Data</th>
                    <th>Horario</th>
                    <th>Nome donatario</th>
                    <th>Email donatario</th>
                </tr>
            </thead>
            <tbody>
<%
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String data = resultSet.getString("data");
                String horario = resultSet.getString("horario");
                int idDonatario = resultSet.getInt("id_donatario");

                sql = "SELECT * FROM `donatarios` WHERE `id` = ?";
                PreparedStatement stmt = connection.prepareStatement(sql);

                stmt.setInt(1, idDonatario);
                ResultSet resultSet2 = stmt.executeQuery();

                if (resultSet2.next()) {
                    String nome = resultSet2.getString("nome");
                    String email = resultSet2.getString("email");
%>
                <tr>
                    <td><%=id%></td>
                    <td><%=data%></td>
                    <td><%=horario%></td>
                    <td><%=nome%></td>
                    <td><%=email%></td>
                </tr>
<% 
                }
                resultSet2.close();
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
</body>
</html>