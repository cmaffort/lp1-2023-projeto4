package br.cefetmg.projeto4.javaweb;

import br.cefetmg.projeto4.dao.DoadorDAO;
import br.cefetmg.projeto4.dao.DoadorJuridicoDAO;
import br.cefetmg.projeto4.dao.MantecaoDAO;
import br.cefetmg.projeto4.dao.EstagiarioDAO;
import br.cefetmg.projeto4.dao.ProfessorDAO;
import br.cefetmg.projeto4.dao.DoacaoDAO;
import br.cefetmg.projeto4.dto.DoadorDTO;
import br.cefetmg.projeto4.dto.DoadorJuridicoDTO;
import br.cefetmg.projeto4.dto.MantecaoDTO;
import br.cefetmg.projeto4.dto.EstagiarioDTO;
import br.cefetmg.projeto4.dto.ProfessorDTO;
import br.cefetmg.projeto4.dto.DoacaoDTO;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/relatorioGeral")
public class GestaoGeralServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try (PrintWriter out = response.getWriter()) {
            
            DoacaoDAO doacaoDAO = new DoacaoDAO();
            List<DoacaoDTO> doacoes = doacaoDAO.listar();
            EstagiarioDAO estagiarioDAO = new EstagiarioDAO();
            List<EstagiarioDTO> estagiarios = estagiarioDAO.listar();
            
            int computadoresRecebidos = 0;
            int computadoresDoados = 0;
            
            for (DoacaoDTO contador: doacoes) {
                computadoresRecebidos += contador.getQuantidade();
            }
            
            for (EstagiarioDTO contador: estagiarios) {
                computadoresDoados++;
            }
            
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
            out.println("<tr><th>Computadores Recebidos</th><th>Computadores Doados</th></tr>");
            out.println("</thead><tbody>");
            out.println("<tr><td>" + computadoresRecebidos + "</td><td>" + computadoresDoados + "</td></tr>");
            
            

        } catch (SQLException ex) {
            Logger.getLogger(GestaoDoacao.class.getName()).log(Level.SEVERE, null, ex);
            // Trate a exceção de alguma forma apropriada aqui (por exemplo, exibir uma mensagem de erro).
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestaoDoacao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}