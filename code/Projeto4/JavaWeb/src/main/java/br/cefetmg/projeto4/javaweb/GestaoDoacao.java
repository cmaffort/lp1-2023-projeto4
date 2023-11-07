package br.cefetmg.projeto4.javaweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import br.cefetmg.projeto4.dao.mysql.MySqlConnection;

@WebServlet("/MostrarDoacoes")
public class GestaoDoacao extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Configuração da conexão com o banco de dados (substitua pelos seus próprios dados)

        try {
            MySqlConnection mySqlConnection = new MySqlConnection();
            // Criar uma declaração SQL
            try ( // Conectar ao banco de dados
                    Connection connection = mySqlConnection.getConexao()) {
                // Criar uma declaração SQL
                String sql = "SELECT id, quantidade, computador FROM doacao";
                Statement statement = connection.createStatement();
                String newSql = "SELECT id, nome_aluno FROM fila_espera";
                // Executar a consulta SQL
                ResultSet resultSet = statement.executeQuery(sql);

                // Configurar a resposta HTTP com um tipo de conteúdo HTML
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();

                // Escrever a página HTML
                out.println("<html><head>");
                out.println("<style>");
                out.println("body { font-family: Arial, sans-serif; background-color: #e0e0ff; margin: 0; padding: 0; }");
                out.println("h2 { color: #336699; }");
                out.println("table { width: 80%; margin: 20px auto; border-collapse: collapse; background-color: #cce0ff; box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1); }");
                out.println("table, th, td { border: 1px solid #99b3e6; }");
                out.println("th, td { padding: 10px; text-align: left; }");
                out.println("th { background-color: #336699; color: #fff; }");
                out.println("tr:nth-child(even) { background-color: #ccd9ff; }");
                out.println("tr:nth-child(odd) { background-color: #cce0ff; }");
                out.println("</style>");
                out.println("</head><body>");
                out.println("<h2>Lista de Doações</h2>");
                out.println("<table>");
                out.println("<tr><th>ID</th><th>Quantidade</th><th>Computador</th></tr>");

                // Iterar sobre os resultados e exibi-los na tabela HTML
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    int quantidade = resultSet.getInt("quantidade");
                    String computador = resultSet.getString("computador");

                    out.println("<tr><td>" + id + "</td><td>" + quantidade + "</td><td>" + computador + "</td></tr>");
                }

                out.println("</table>");
                resultSet = statement.executeQuery(newSql);
                out.println("<h2>Fila de Espera</h2>");
                out.println("<table>");
                out.println("<tr><th>Posição</th><th>Nome</th></tr>");
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String nome = resultSet.getString("nome_aluno");

                    out.println("<tr><td>" + id + "</td><td>" + nome + "</td></tr>");
                }

                out.println("</body></html>");

                // Fechar recursos
                resultSet.close();
                statement.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
