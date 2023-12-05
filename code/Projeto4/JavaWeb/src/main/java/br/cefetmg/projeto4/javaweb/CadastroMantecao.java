/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.cefetmg.projeto4.javaweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.cefetmg.projeto4.dao.EstagiarioDAO;
import br.cefetmg.projeto4.dao.MantecaoDAO;
import br.cefetmg.projeto4.dto.DonatarioDTO;
import br.cefetmg.projeto4.dto.EstagiarioDTO;
import br.cefetmg.projeto4.dto.MantecaoDTO;
import br.cefetmg.projeto4.dto.UsuarioDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author julia-sg
 */
@WebServlet(name = "mantecao", urlPatterns = {"/mantecao"})
public class CadastroMantecao extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws ClassNotFoundException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (
            PrintWriter out = response.getWriter();
            EstagiarioDAO estagiarioDAO = new EstagiarioDAO();
            MantecaoDAO mantecaoDAO = new MantecaoDAO()
        ) {
            String data = request.getParameter("retirada");
            String estado = request.getParameter("estado");
            String email = request.getParameter("email");

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
            EstagiarioDTO arrumador = (EstagiarioDTO) estagiarioDAO.selecionar(email).orElseThrow();

            MantecaoDTO mantecao = new MantecaoDTO(data, estado, donatario, arrumador);

            if(mantecaoDAO.inserir(mantecao))
                response.sendRedirect("manterComputador.jsp?status=success");
            else
                response.sendRedirect("manterComputador.jsp?status=fail");
        } catch (SQLException e) {
            System.err.println("Erro: " + e.getMessage());
            response.sendRedirect("manterComputador.jsp?status=fail");
        } catch (NoSuchElementException e) {
            response.sendRedirect("manterComputador.jsp?e=email");
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