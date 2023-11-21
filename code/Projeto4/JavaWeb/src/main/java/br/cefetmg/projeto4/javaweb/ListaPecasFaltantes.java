/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 
package br.cefetmg.projeto4.javaweb;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import br.cefetmg.projeto4.dto.PecasDTO;
import br.cefetmg.projeto4.dao.PecasDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
@WebServlet(name = "ListaPecasFaltantes", urlPatterns = {"/ListaPecasFaltantes"})
public class ListaPecasFaltantes extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            PecasDAO pecasDAO = new PecasDAO();
                        out.println("<head>");
            out.println("<title>Servlet ListaPecasFaltantes</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListaPecasFaltantes at " + request.getContextPath() + "</h1>");

            List<PecasDTO> pecas = pecasDAO.listar();
            for(PecasDTO peca : pecas)
            {
                out.println("<p>" + peca.getCodigo() + " " + peca.getMarca() + peca.getNome() + " " + peca.getQuantidade()+ "</p>");
            }
            out.println("</body>");
            out.println("</html>");
        } catch (SQLException ex) {
            Logger.getLogger(ListaPecasFaltantes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListaPecasFaltantes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListaPecasFaltantes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

} */
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
        // Configuração da conexão com o banco de dados (substitua pelos seus próprios dados)
        try {
            PecasDAO pecasDAO = new PecasDAO();
            List<PecasDTO> pecas = pecasDAO.listarFaltosos();

            // Configurar a resposta HTTP com um tipo de conteúdo HTML
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

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
            out.println("<caption>Peças faltantes</caption>");
            out.println("<thead>");
            out.println("<tr><th>Codigo</th><th>Nome</th><th>Marca</th><th>Quantidade</th></tr>");
            out.println("</thead><tbody>");

            // Iterar sobre os resultados e exibi-los na tabela HTML
            for (PecasDTO peca : pecas) {
                out.println("<tr><td>" + peca.getId() + "</td><td>" + peca.getNome() + "</td><td>" + peca.getMarca() + "</td><td>" + peca.getQuantidade() + "</td>");
            }
            out.println("</tbody><tfoot>");
            out.println("<tr><td colspan=\"4\" id=\"redirect\"><button onclick=\"redirect('cadastroCompra.jsp')\">Relatar compra</button></td></tr>");
            out.println("</tfoot></table>");
            out.println("</section></main>"); 
            out.println("<script src=\"code/header.js\"></script>");
            out.println("<script src=\"code/th.js\"></script>");
            out.println("</body></html>");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(GestaoDoacao.class.getName()).log(Level.SEVERE, null, ex);
            // Trate a exceção de alguma forma apropriada aqui (por exemplo, exibir uma mensagem de erro).
        }
    }
}
