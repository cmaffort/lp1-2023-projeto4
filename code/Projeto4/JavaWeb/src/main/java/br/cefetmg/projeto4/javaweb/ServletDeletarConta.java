package br.cefetmg.projeto4.javaweb;

import br.cefetmg.projeto4.dao.mysql.MySqlConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "ServletDeletarConta", urlPatterns = {"/ServletDeletarConta"})
public class ServletDeletarConta extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String email = request.getParameter("login");
            String senha = request.getParameter("senha");
            String[] tabelas = {"doadorJuridica", "doadorFisica", "professores", "donatarios", "estagiarios"};

            MySqlConnection bancoDeDados = new MySqlConnection();
            try (Connection conexao = bancoDeDados.getConexao()) {
                String salvando = null;

                for (String tabela : tabelas) {
                    if (verificarTabela(conexao, tabela, email, senha)) {
                        try {
                            PreparedStatement statement = conexao.prepareStatement("DELETE FROM " + tabela + " WHERE email = ? AND senha = ?");
                            statement.setString(1, email);
                            statement.setString(2, senha);
                            int rowsDeleted = statement.executeUpdate(); // Usar executeUpdate() para DELETE
                            response.sendRedirect("http://localhost:8080/view-jsp/index.html");

                        } catch (SQLException e) {
                            System.out.println("Erro ao excluir registros da tabela " + tabela + ": " + e.getMessage());
                        }
                    }
                }

                if (salvando != null) {
                    Cookie cookie = new Cookie("tipoDeLogin", salvando);
                    cookie.setMaxAge(24 * 60 * 60);
                    response.addCookie(cookie);
                } else {
                    response.sendRedirect("paginaDeErro.jsp");
                }
            } catch (SQLException e) {
                out.println("<p>Error: " + e.getMessage() + "</p>");
            }
        }
    }

    private boolean verificarTabela(Connection conexao, String tabela, String email, String senha) throws SQLException {
        try (PreparedStatement statement = conexao.prepareStatement("SELECT * FROM " + tabela + " WHERE email = ? AND senha = ?")) {
            statement.setString(1, email);
            statement.setString(2, senha);
            return statement.executeQuery().next();
        } catch (SQLException e) {
            System.out.println("Erro ao verificar a tabela " + tabela + ": " + e.getMessage());
            return false;
        }
    }
}
