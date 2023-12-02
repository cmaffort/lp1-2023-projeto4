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

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "gestaoDoadores", urlPatterns = {"/gestaoDoadores"})
public class gestaoDoadoresServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        try (
            DoadorDAO doadorFisicaDAO = new DoadorDAO(); 
            DoadorJuridicoDAO doadorJuridicoDAO = new DoadorJuridicoDAO()
        ) {
            List<DoadorDTO> doadoresFisicos = doadorFisicaDAO.listar();
            List<DoadorDTO> doadoresJuridicos = doadorJuridicoDAO.listar();
            
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
            out.println("<tr><th>Nome</th><th>Email</th><th>Computadores doados</th><th>CPF</th></tr>");
            out.println("</thead><tbody>");

            // Iterar sobre os resultados e exibi-los na tabela HTML
            for (DoadorDTO doador : doadoresFisicos) {
                out.println("<tr><td>" + doador.getNome()+ "</td><td>" + doador.getEmail() + "</td><td>" + doador.getComputadoresDoados()+ "</td><td>" + doador.getCodigo() + "</td></tr>");
            }

            out.println("</tbody></table>");
            out.println("<table>");
            out.println("<caption>Lista de Doadores Juridicos</caption>");
            out.println("<thead>");
            out.println("<tr><th>Nome</th><th>Email</th><th>Computadores doados</th><th>CNPJ</th><th>Endereço</th></tr>");
            out.println("</thead><tbody>");
            for (DoadorDTO doador : doadoresJuridicos) {
                DoadorJuridicoDTO doadorJuridico = (DoadorJuridicoDTO) doador;

                out.println("<tr><td>" + doador.getNome()+ "</td><td>" + doador.getEmail()+ "</td><td>" + doador.getComputadoresDoados() + "</td><td>" + doador.getCodigo() + "</td><td>" + doadorJuridico.getEndereco() + "</td></tr>");
            }

            out.println("</table>");
            out.println("<script src=\"code/header.js\"></script>");
            out.println("<script src=\"code/th.js\"></script>");
            out.println("</body></html>");


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
