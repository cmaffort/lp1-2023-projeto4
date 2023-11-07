package br.cefetmg.projeto4.javaweb;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import br.cefetmg.projeto4.dto.SolicitacaoReparo;
import br.cefetmg.projeto4.dto.EstadoManutencao;
import br.cefetmg.projeto4.dto.Computador;

@WebServlet(name = "SolicitacaoReparoServlet", urlPatterns = {"/SolicitacaoReparoServlet"})
public class SolicitacaoReparoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
            
            Object estado = request.getAttribute("issue");
            String especificacoes = request.getParameter("especificacoes");
            EstadoManutencao manutencao;
            Computador computador;
            //SolicitacaoReparo reparo = new SolicitacaoReparo(computador, dataDeDoacao, especificacoes);
            
            //if (estado == "pecas_faltando")
              //  manutencao.FALTANDO_PECAS;
            //else if (estado == "mal_funcionamento")
            //    manutencao.MAL_FUNCIONAMENTO;
            //else if (estado == "outro")
            //    manutencao.OUTRO;
            
            
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
