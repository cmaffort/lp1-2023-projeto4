package br.cefetmg.projeto4.javaweb;

import br.cefetmg.projeto4.dto.DoadorDTO;
import br.cefetmg.projeto4.dto.DoadorJuridicoDTO;
import br.cefetmg.projeto4.dao.DoadorDAO;
import br.cefetmg.projeto4.dao.DoadorJuridicoDAO;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet(name = "gestaoDoadoresServlet", urlPatterns = {"/gestaoDoadoresServlet"})
public class gestaoDoadoresServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        try {
            DoadorDAO doadorFisicaDAO = new DoadorDAO();
            List<DoadorDTO> doadoresFisicos = doadorFisicaDAO.listar();
            DoadorJuridicoDAO doadorJuridicoDAO = new DoadorJuridicoDAO();
            List<DoadorJuridicoDTO> doadoresJuridicos = doadorJuridicoDAO.listar();
            
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            // Escrever a página HTML
            out.println("<html><head>");
            out.println("<link rel=\"stylesheet\" href=\"style/header.css\">");
            out.println("<link rel=\"stylesheet\" href=\"style/main.css\">");
            out.println("<link rel=\"stylesheet\" href=\"style/gestaoDoadores.css\">");
            out.println("<link rel=\"stylesheet\" href=\"style/table.css\">");
            out.println("</head><body>");
            out.println("<header></header>");
            out.println("<main><section>");
            out.println("<table>");
            out.println("<caption>Lista de Doadores Fisicos</caption>");
            out.println("<thead>");
            out.println("<tr><th>Nome</th><th>Email</th><th>Computadores doados</th><th>CPF</th><th>Codigo</th></tr>");
            out.println("</thead><tbody>");

            // Iterar sobre os resultados e exibi-los na tabela HTML
            for (DoadorDTO doadores : doadoresFisicos) {
                out.println("<tr><td>" + doadores.getNome()+ "</td><td>" + doadores.getEmail() + "</td><td>" + doadores.getComputadoresDoados()+ "</td><td>" + doadores.getCPF() + "</td><td>" + doadores.getCodigo());
            }
            for (DoadorJuridicoDTO doadores : doadoresJuridicos) {
                out.println("<tr><td>" + doadores.getNome()+ "</td><td>" + doadores.getEmail()+ "</td><td>" + doadores.getComputadoresDoados() + "</td><td>" + doadores.getCNPJ() + "</td><td>" + doadores.getCodigo());
            }

            out.println("</table></body></html>");


            // Iterar sobre os resultados e exibi-los na tabela HTML
        }
        catch (SQLException ex) {
            Logger.getLogger(GestaoDoacao.class.getName()).log(Level.SEVERE, null, ex);
            // Trate a exceção de alguma forma apropriada aqui (por exemplo, exibir uma mensagem de erro).
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestaoDoacao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
