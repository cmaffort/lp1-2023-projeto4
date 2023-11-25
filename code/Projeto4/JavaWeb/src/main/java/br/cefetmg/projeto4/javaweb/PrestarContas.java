/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.cefetmg.projeto4.javaweb;

import br.cefetmg.projeto4.dao.DoacaoDAO;
import br.cefetmg.projeto4.dao.DonatarioDAO;
import br.cefetmg.projeto4.dto.DoacaoDTO;
import br.cefetmg.projeto4.dto.DonatarioDTO;
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
@WebServlet(name = "PrestarContas", urlPatterns = {"/PrestarContas"})
public class PrestarContas extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
        // Configuração da conexão com o banco de dados (substitua pelos seus próprios dados)
        try (
            DoacaoDAO doacaoDAO = new DoacaoDAO();
            DonatarioDAO donatarioDAO = new DonatarioDAO();
        ) {
            List<DoacaoDTO> doacoes = doacaoDAO.listar();

            // Configurar a resposta HTTP com um tipo de conteúdo HTML
            response.setContentType("text/html");

            // Escrever a página HTML
            out.println("<html><head>");
            out.println("<link rel=\"stylesheet\" href=\"style/header.css\">");
            out.println("<link rel=\"stylesheet\" href=\"style/main.css\">");
            out.println("<link rel=\"stylesheet\" href=\"style/doacoes.css\">");
            out.println("<link rel=\"stylesheet\" href=\"style/table.css\">");
            out.println("</head><body>");
            out.println("<header></header>");
            out.println("<main><section>");
            out.println("<table>");
            out.println("<caption>Lista de Doações</caption>");
            out.println("<thead>");
            out.println("<tr><th>Quantidade</th><th>Computador</th><th>Ram</th><th>Doador</th><th>Data</th></tr>");
            out.println("</thead><tbody>");

            // Iterar sobre os resultados e exibi-los na tabela HTML
            for (DoacaoDTO doacao : doacoes) {
                out.println("<tr><td>" + doacao.getQuantidade()+ "</td><td>" + doacao.getMarcaComputador() + "</td><td>" + doacao.getQuantidadeDeRAM() + "</td><td>" + doacao.getDoador() + "</td><td>" + doacao.getDataDeChegada());
            }

            out.println("</tbody></table></section>");
            List<DonatarioDTO> donatarios = donatarioDAO.listar();
            out.println("<section><table>");
            out.println("<caption>Fila de Espera</caption>");
            out.println("<thead>");
            out.println("<tr><th>Posição</th><th>Nome</th><th>Email</th></tr>");
            out.println("</thead><tbody>");
            for (DonatarioDTO donatario : donatarios) {
                out.println("<tr><td>" + donatario.getPosicao() + "</td><td>" + donatario.getNome() + "</td><td>"+ donatario.getEmail()+ "</td></tr>");
            }

            out.println("</tbody></table>");
            out.println("</section></main>"); 
            out.println("<script src=\"code/header.js\"></script>");
            out.println("<script src=\"code/th.js\"></script>");
            out.println("</body></html>");
        } catch (SQLException ex) {
            Logger.getLogger(GestaoDoacao.class.getName()).log(Level.SEVERE, null, ex);
            // Trate a exceção de alguma forma apropriada aqui (por exemplo, exibir uma mensagem de erro).
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
