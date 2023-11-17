package br.cefetmg.projeto4.javaweb;

import br.cefetmg.projeto4.dao.UsuarioDAO;
import br.cefetmg.projeto4.dto.UsuarioDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
@WebServlet(name = "ServletDeletarConta", urlPatterns = {"/ServletDeletarConta"})
public class ServletDeletarConta extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            String senha = request.getParameter("senha");

            HttpSession session = request.getSession(false);
            UsuarioDTO safeUsuario = (UsuarioDTO) session.getAttribute("usuario");

            UsuarioDAO usuarioDAO = new UsuarioDAO();
            UsuarioDTO usuario = (UsuarioDTO) usuarioDAO.selecionar(safeUsuario.getEmail()).orElseThrow();

            if (!usuarioDAO.autenticar(usuario, senha))
                throw new IllegalArgumentException("Senha errada");
            
            usuarioDAO.remover(usuario);

            response.sendRedirect("logout");
        } catch (SQLException ex) {
            Logger.getLogger(ServletDeletarConta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException e) {
            response.sendRedirect("deletarConta.jsp?status=fail");
        }
    }
}
