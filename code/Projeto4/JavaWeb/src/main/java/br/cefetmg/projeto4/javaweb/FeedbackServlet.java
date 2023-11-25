package br.cefetmg.projeto4.javaweb;

import br.cefetmg.projeto4.dao.FeedbackDAO;
import br.cefetmg.projeto4.dto.DonatarioDTO;
import br.cefetmg.projeto4.dto.FeedbackDTO;
import br.cefetmg.projeto4.dto.UsuarioDTO;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


@WebServlet(name = "feedback", urlPatterns = {"/feedback"})
public class FeedbackServlet extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (FeedbackDAO feedbackDAO = new FeedbackDAO()) {
            String estrelas = request.getParameter("rating");
            String descricao = request.getParameter("comments");

            HttpSession session = request.getSession(false);

            if (session == null || session.getAttribute("usuario") == null) {
                response.sendRedirect("negado.jsp");
                return;
            }

            UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("usuario");

            if (!usuario.getTipo().equals("DONATARIO")) {
                response.sendRedirect("negado.jsp");
                return;
            }

            DonatarioDTO donatario = (DonatarioDTO) usuario;
            FeedbackDTO feedback = new FeedbackDTO(Integer.parseInt(estrelas), descricao, donatario);

            if (!feedbackDAO.inserir(feedback))
                response.sendRedirect("feedback.jsp?status=fail");
            else
                response.sendRedirect("feedback.jsp?status=success");
        } catch (SQLException e) {
            System.err.println("Error: " + e);
            response.sendRedirect("feedback.jsp?status=fail");
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
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
