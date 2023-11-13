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
import br.cefetmg.projeto4.dao.DeletarUsuarioDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
@WebServlet(name = "ServletDeletarConta", urlPatterns = {"/ServletDeletarConta"})
public class ServletDeletarConta extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String email = request.getParameter("login");
            String senha = request.getParameter("senha");
            DeletarUsuarioDAO deletarUsuarioDAO = new DeletarUsuarioDAO();
            if(deletarUsuarioDAO.deletarUsuario(email, senha))
                out.println("<p>deletado</p>");
            else
                out.println("<p>erro</p>");

    }   catch (SQLException ex) {
            Logger.getLogger(ServletDeletarConta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
