package br.cefetmg.projeto4.javaweb;
import br.cefetmg.projeto4.dto.EstagiarioDTO;
import br.cefetmg.projeto4.dao.EstagiarioDAO;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
@WebServlet(name = "EstagiarioServlet", urlPatterns = {"/EstagiarioServlet"})
public class EstagiarioServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String nome = request.getParameter("nome");
           /* String curso = request.getParameter("curso");
            String serie = request.getParameter("serie"); */
            String email = request.getParameter("email");
            String cpf = request.getParameter("cpf");
            String senha = request.getParameter("senha");
            String confirmarSenha = request.getParameter("confirmarSenha");
            EstagiarioDTO estagiario = new EstagiarioDTO(nome, cpf, email, senha, "21/1/1", "10/1/1");
            try {
            EstagiarioDAO estagiarioDAO = new EstagiarioDAO();
            if(estagiarioDAO.inserir(estagiario))
            {
                response.sendRedirect("login.jsp");

            }
            }catch (SQLException e) {
                out.println("<p>SQLException</p>");
            }
// processo de confirmar a senha
            
// processo de confirmar a senha        
            

            
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
        } catch (SQLException ex) {
            Logger.getLogger(EstagiarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EstagiarioServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(EstagiarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EstagiarioServlet.class.getName()).log(Level.SEVERE, null, ex);
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
    }
}
