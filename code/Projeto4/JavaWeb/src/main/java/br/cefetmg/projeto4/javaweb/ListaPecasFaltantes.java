package br.cefetmg.projeto4.javaweb;

import br.cefetmg.projeto4.dao.PecasDAO;
import br.cefetmg.projeto4.dto.PecasDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/PecasFaltantes")
public class ListaPecasFaltantes extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter(); PecasDAO pecasDAO = new PecasDAO()) {
            List<PecasDTO> pecas = pecasDAO.listarFaltosos();

            response.setContentType("text/html");

            out.println("<html><head>");
            out.println("<link rel=\"stylesheet\" href=\"style/header.css\">");
            out.println("<link rel=\"stylesheet\" href=\"style/main.css\">");
            out.println("<link rel=\"stylesheet\" href=\"style/doacoes.css\">");
            out.println("<link rel=\"stylesheet\" href=\"style/table.css\">");
            out.println("</head><body>");
            out.println("<header></header>");
            out.println("<main><section>");
            out.println("<table>");
            out.println("<caption>Peças faltantes</caption>");
            out.println("<thead>");
            out.println("<tr><th>Codigo</th><th>Nome</th><th>Marca</th><th>Quantidade</th></tr>");
            out.println("</thead><tbody>");

            for (PecasDTO peca : pecas) {
                out.println("<tr id=\"row_" + peca.getId() + "\">");
                out.println("<td>" + peca.getId() + "</td>");
                out.println("<td>" + peca.getNome() + "</td>");
                out.println("<td>" + peca.getMarca() + "</td>");
                out.println("<td>" + peca.getQuantidade() + "</td>");
                
                
                out.println("</tr>");
            }

            out.println("</tbody><tfoot></table>");
            out.println("<table>");
            out.println("<caption>Peças Compradas</caption>");
            out.println("<thead>");
            out.println("<tr><th>Codigo</th><th>Nome</th><th>Marca</th><th>Quantidade</th></tr>");
            out.println("</thead><tbody>");
            pecas = pecasDAO.listarCompradas();

            for (PecasDTO peca : pecas) {
                out.println("<tr id=\"row_" + peca.getId() + "\">");
                out.println("<td>" + peca.getId() + "</td>");
                out.println("<td>" + peca.getNome() + "</td>");
                out.println("<td>" + peca.getMarca() + "</td>");
                out.println("<td>" + peca.getQuantidade() + "</td>");
                
                // Adicionando um botão com um evento de clique que chama a função comprarPeca
                
                out.println("</tr>");
            }

            out.println("</tbody><tfoot></table>");
            out.println("<tr><td colspan=\"5\" id=\"redirect\"><button onclick=\"redirect('cadastroCompra.jsp')\">Relatar compra</button></td></tr>");
            out.println("</tfoot></table>");
            out.println("</section></main>");
            out.println("<script src=\"code/header.js\"></script>");
            out.println("<script src=\"code/th.js\"></script>");


            out.println("</body></html>");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(GestaoDoacao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
