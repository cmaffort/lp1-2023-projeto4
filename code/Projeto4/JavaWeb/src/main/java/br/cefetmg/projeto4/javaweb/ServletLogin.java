package br.cefetmg.projeto4.javaweb;
import br.cefetmg.projeto4.dao.mysql.MySqlConnection;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "ServletLogin", urlPatterns = {"/ServletLogin"})
public class ServletLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            MySqlConnection bancoDeDados = new MySqlConnection();
            
            try {
                Connection conexao = bancoDeDados.getConexao();
                PreparedStatement statement = conexao.prepareStatement("INSERT INTO pessoas (nome, idade) VALUES (?, ?)");
                String nome = request.getParameter("login");
                String senha = request.getParameter("senha");
                statement.setString(1, nome);
                statement.setString(2, senha);
                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0) {
                    out.println("<p>sucesso</p>");
                } else {
                    out.println("<p>erro</p>");
                }
            } catch (SQLException e) {
                // Handle any SQL exceptions, e.g., log or display an error message
                out.println("<p>Error: " + e.getMessage() + "</p>");
            }
        }
    }
}
