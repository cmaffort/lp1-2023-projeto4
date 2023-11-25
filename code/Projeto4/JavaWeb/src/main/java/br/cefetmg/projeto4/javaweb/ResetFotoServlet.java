package br.cefetmg.projeto4.javaweb;

import java.io.IOException;
import java.sql.SQLException;

import br.cefetmg.projeto4.core.CloudHelper;
import br.cefetmg.projeto4.dao.UsuarioDAO;
import br.cefetmg.projeto4.dto.UsuarioDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "deletarFoto", urlPatterns = {"/deletarFoto"})
public class ResetFotoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        try (UsuarioDAO usuarioDAO = new UsuarioDAO()) {
            HttpSession session = request.getSession(false);

            if (session == null || session.getAttribute("usuario") == null) {
                response.sendRedirect("negado.jsp");
                return;
            }

            UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("usuario");
            String filePath = usuario.getFoto();

            String defaultPicture = CloudHelper.deletar(filePath);
            
            if (defaultPicture.equals(filePath)) {
                response.sendRedirect("perfil.jsp?status=fail");
                return;
            }

            usuarioDAO.resetFoto(usuario.getEmail());
            usuario.setFoto(defaultPicture);
            session.setAttribute("usuario", usuario);

            response.sendRedirect("perfil.jsp?status=success");
        } catch (SQLException e) {
            System.err.println("Error: " + e);
            response.sendRedirect("perfil.jsp?status=fail");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
