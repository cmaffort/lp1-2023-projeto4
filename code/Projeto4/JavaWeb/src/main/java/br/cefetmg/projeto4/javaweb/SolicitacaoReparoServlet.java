package br.cefetmg.projeto4.javaweb;

import br.cefetmg.projeto4.dto.SolicitacaoReparoDTO;
import br.cefetmg.projeto4.dto.ComputadorDTO;
import br.cefetmg.projeto4.dto.SolicitacaoReparoDTO.EstadoManutencao;
import br.cefetmg.projeto4.dao.SolicitacaoReparoDAO;

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

@WebServlet(name = "SolicitacaoReparoServlet", urlPatterns = {"/SolicitacaoReparoServlet"})
public class SolicitacaoReparoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            out.println("<p>inserido</p>");

            String estado = request.getParameter("problema");
            String especificacoes = request.getParameter("especificacoes");
            ComputadorDTO computador = new ComputadorDTO();
            String dataDeDoacao = "2023-11-14";
            SolicitacaoReparoDTO manutencao = new SolicitacaoReparoDTO();
            out.println("<p>"+ estado + "</p>");
            out.println("<p>"+ especificacoes + "</p>");


            switch (estado) {
                case "mal_funcionamento":
                    manutencao.setManutencao(EstadoManutencao.MAL_FUNCIONAMENTO);
                    break;
                case "pecas_faltando":
                    manutencao.setManutencao(EstadoManutencao.FALTANDO_PECAS);
                    break;
                case "outro":
                    manutencao.setManutencao(EstadoManutencao.OUTRO);
                    break;
                default:
                    break;
            }

            SolicitacaoReparoDTO reparo = new SolicitacaoReparoDTO(computador, dataDeDoacao, especificacoes);

            try {
                SolicitacaoReparoDAO reparoDAO = new SolicitacaoReparoDAO();
                out.print(reparo.getDataDeDoacao());
                if (reparoDAO.inserir(reparo)) {
                    out.println("<p>inserido</p>");
                }
                else {
                    out.println("<p>erro</p>");

                }

            } catch (SQLException e) {
                out.println("<p>SQLException</p>");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(GestaoDoacao.class.getName()).log(Level.SEVERE, null, ex);
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
