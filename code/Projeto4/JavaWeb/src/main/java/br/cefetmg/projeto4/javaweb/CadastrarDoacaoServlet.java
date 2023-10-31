package br.cefetmg.projeto4.javaweb;

import br.cefetmg.projeto4.dao.DoacaoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import br.cefetmg.projeto4.dto.Computador;
import br.cefetmg.projeto4.dto.Doacao;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "CadastrarDoacaoServlet", urlPatterns = {"/CadastrarDoacaoServlet"})
public class CadastrarDoacaoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String quantidade1 = request.getParameter("quantidade");
            String modelo = request.getParameter("modelo");
            String marca = request.getParameter("marca");
            String quantidadeRam = request.getParameter("quantidadeRAM");
            String data = request.getParameter("data");
            String estado = request.getParameter("status");
            int quantidadeRAM = 0;
            int quantidade = 0;
            
            try {
                quantidade = Integer.parseInt(quantidade1);
                System.out.println(quantidade1);
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }
            
            try {
                quantidadeRAM = Integer.parseInt(quantidadeRam);
                System.out.println(quantidadeRAM);
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }

            Computador computador = new Computador(null, data, null, marca, modelo, quantidadeRAM);
            Doacao doacao = new Doacao(quantidade, computador, computador.getDataDeChegada(), computador.getDonatario(), computador.getMarca(), computador.getModeloProcessador(), computador.getQuantidadeDeRAM());
                        try {
                DoacaoDAO doacaoDAO = new DoacaoDAO();
                try {
                    if(doacaoDAO.inserir(doacao))
                        out.println("<p>inserido</p>");
                    else
                        out.println("<p>erro</p>");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DonatarioCadastro.class.getName()).log(Level.SEVERE, null, ex);
                }
            }catch (SQLException e) {
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
