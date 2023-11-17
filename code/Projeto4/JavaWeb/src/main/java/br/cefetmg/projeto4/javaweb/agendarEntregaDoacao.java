package br.cefetmg.projeto4.javaweb;

import br.cefetmg.projeto4.dao.AgendamentoDAO;
import br.cefetmg.projeto4.dto.AgendamentoDTO;
import br.cefetmg.projeto4.dto.DonatarioDTO;
import br.cefetmg.projeto4.dto.UsuarioDTO;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author Aluno
 */
@WebServlet(name = "EntregaDoacao", urlPatterns = {"/EntregaDoacao"})
public class agendarEntregaDoacao extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String data = request.getParameter("dataRetirada");
            String hora = request.getParameter("horaRetirada");

            HttpSession session = request.getSession(false);

            if (session == null || session.getAttribute("usuario") == null) {
                response.sendRedirect("login.jsp");
                return;
            }
        
            UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("usuario");
        
            if (!usuario.getTipo().equals("DONATARIO")) {
                response.sendRedirect("negado.jsp");
                return;
            }

            DonatarioDTO donatario = (DonatarioDTO) usuario;

            AgendamentoDTO agendamento = new AgendamentoDTO(data, hora, donatario);

            try {
                AgendamentoDAO agendamentoDAO = new AgendamentoDAO();

                if(agendamentoDAO.inserir(agendamento))
                    out.println("<p>inserido</p>");
                else
                    out.println("<p>erro</p>");
            } catch (SQLException e) {
                out.println("<p>SQLException</p>");
            }
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
        } catch (ClassNotFoundException e) {
            Logger.getLogger(agendarEntregaDoacao.class.getName()).log(Level.SEVERE, null, e);
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
        } catch (ClassNotFoundException e) {
            Logger.getLogger(agendarEntregaDoacao.class.getName()).log(Level.SEVERE, null, e);
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
