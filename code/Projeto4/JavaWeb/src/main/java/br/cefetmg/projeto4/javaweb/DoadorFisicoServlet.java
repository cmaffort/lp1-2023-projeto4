/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.cefetmg.projeto4.javaweb;
import br.cefetmg.projeto4.dao.DoadorDAO;
import br.cefetmg.projeto4.dto.DoadorDTO;
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

@WebServlet(name = "DoadorFisicoServlet", urlPatterns = {"/DoadorFisicoServlet"})
public class DoadorFisicoServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String nome = request.getParameter("nome");
            String CPF = request.getParameter("cpf");
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            DoadorDTO doadorFisica = new DoadorDTO(nome, CPF, email, senha);
            try {
                DoadorDAO doadorFisicaDAO = new DoadorDAO();
                try {
                    if(doadorFisicaDAO.inserir(doadorFisica))
                    {
                        out.println("<p>inserido</p>");
                        
                        String p = request.getParameter("p");

                        if (p != null)
                            response.sendRedirect("login.jsp?p=" + p);
                        else
                            response.sendRedirect("login.jsp");
                    }
                    else
                        out.println("<p>erro</p>");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DonatarioCadastro.class.getName()).log(Level.SEVERE, null, ex);
                }
            }catch (SQLException e) {
                out.println("<p>SQLException</p>");
            }
        
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DoadorFisicaServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DoadorFisicaServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
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
