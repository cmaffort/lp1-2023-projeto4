/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.cefetmg.projeto4.javaweb;
import br.cefetmg.projeto4.dto.ComprasDTO;
import br.cefetmg.projeto4.dao.ComprasDAO;
import br.cefetmg.projeto4.dao.PecasDAO;
import br.cefetmg.projeto4.dto.PecasDTO;
import br.cefetmg.projeto4.dto.PecasDTO;
import br.cefetmg.projeto4.dto.DoacaoDTO;
import br.cefetmg.projeto4.dao.DoacaoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucas
 */
@WebServlet(name = "RelatorioServlet", urlPatterns = {"/Relatorio"})
public class RelatorioServlet extends HttpServlet {

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
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<html><head>");
            out.println("<link rel=\"stylesheet\" href=\"style/header.css\">");
            out.println("<link rel=\"stylesheet\" href=\"style/main.css\">");
            out.println("<link rel=\"stylesheet\" href=\"style/gestaoDoadores.css\">");
            out.println("<link rel=\"stylesheet\" href=\"style/table.css\">");
            out.println("</head><body>");
            out.println("<header></header>");
            out.println("<main><section>");
            ComprasDAO comprasDAO = new ComprasDAO();
            int total = comprasDAO.valorTotal();
            out.println("<p> Total gasto: " + total + "</p>");
            out.println("<table>");
           /* out.println("<caption>Lista de Peças em Falta</caption>");
            out.println("<thead>");
            out.println("<tr><th>Nome</th><th>Marca</th><th>Quantidade</th></tr>");
            out.println("</thead><tbody>");

            PecasDAO pecasDAO = new PecasDAO(); // Trate a exceção de alguma forma apropriada aqui (por exemplo, exibir uma mensagem de erro).
            List<PecasDTO> pecasEmFalta = pecasDAO.listarFaltosos();
            for(PecasDTO pecas : pecasEmFalta)
            {
                out.println("<tr><td>" + pecas.getNome() + "</td><td>" + pecas.getMarca() + "</td><td>" + pecas.getQuantidade() + "</td></tr>");

            }
            out.println("</table>");*/
            out.println("<table>");
            out.println("<caption>Lista de Peças Doadas</caption>");
            out.println("<thead>");
            out.println("<tr><th>Nome</th><th>Marca</th><th>Quantidade</th></tr>");
            out.println("</thead><tbody>");
            PecasDAO pecasDAO = new PecasDAO(); 
            List<PecasDTO> pecasDoadas = pecasDAO.listarDoados();
            out.println(pecasDoadas.size());
            for(PecasDTO pecas : pecasDoadas)
            {
                out.println("<tr><td>" + pecas.getNome() + "</td><td>" + pecas.getMarca() + "</td><td>" + pecas.getQuantidade() + "</td></tr>");

            }
            
            out.println("</table>");
            out.println("<table>");
            out.println("<caption>Lista de Computadores Doados</caption>");
            out.println("<thead>");
            out.println("<tr><th>Marca</th><th>Doador</th><th>Donatario</th><th>Data de Chegada</th></tr>");
            out.println("</thead><tbody>");
            DoacaoDAO doacao = new DoacaoDAO();
            List<DoacaoDTO> computadoresDoados = doacao.listarComputadoresDoados();
            for(DoacaoDTO computadores : computadoresDoados)
            {
                out.println("<tr><td>" + computadores.getMarca() + "</td><td>" + computadores.getDoador() + "</td><td>" + computadores.getDonatario() + "</td>" + "<td>" + computadores.getDataDeChegada() + "</td></tr>");

            }
            out.println("</table>");

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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(RelatorioServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RelatorioServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(RelatorioServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RelatorioServlet.class.getName()).log(Level.SEVERE, null, ex);
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
