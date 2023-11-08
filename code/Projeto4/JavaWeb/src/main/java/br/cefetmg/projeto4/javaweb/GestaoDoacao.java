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
                out.println("<link rel=\"stylesheet\" href=\"style/header.css\">");
                out.println("<link rel=\"stylesheet\" href=\"style/main.css\">");
                out.println("<link rel=\"stylesheet\" href=\"style/doacoes.css\">");
                out.println("</head><body>");
                out.println("<header></header>");
                out.println("<main><section>");
                out.println("<table>");
                out.println("<caption>Lista de Doações</caption>");
                out.println("<thead>");
                out.println("<tr><th>ID</th><th>Quantidade</th><th>Computador</th></tr>");
                out.println("</thead><tbody>");

                // Iterar sobre os resultados e exibi-los na tabela HTML
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    int quantidade = resultSet.getInt("quantidade");
                    String computador = resultSet.getString("computador");

                    out.println("<tr><td>" + id + "</td><td>" + quantidade + "</td><td>" + computador + "</td></tr>");
                }

                out.println("</tbody></table></section>");
                resultSet = statement.executeQuery(newSql);
                out.println("<section><table>");
                out.println("<caption>Fila de Espera</caption>");
                out.println("<thead>");
                out.println("<tr><th>Posição</th><th>Nome</th></tr>");
                out.println("</thead><tbody>");
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String nome = resultSet.getString("nome_aluno");

                    out.println("<tr><td>" + id + "</td><td>" + nome + "</td></tr>");
                }

                out.println("</tbody></table>");
                out.println("</section></main>");
                out.println("<script src=\"code/header.js\"></script>");
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
