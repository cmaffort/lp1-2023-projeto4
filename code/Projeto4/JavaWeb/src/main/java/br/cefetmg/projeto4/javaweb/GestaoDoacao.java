package br.cefetmg.projeto4.javaweb;

import br.cefetmg.projeto4.dao.DoacaoDAO;
import br.cefetmg.projeto4.dao.DonatarioDAO;
import br.cefetmg.projeto4.dto.Doacao;
import br.cefetmg.projeto4.dto.Donatario;

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

@WebServlet("/MostrarDoacoes")
public class GestaoDoacao extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Configuração da conexão com o banco de dados (substitua pelos seus próprios dados)
        try {
            DoacaoDAO doacaoDAO = new DoacaoDAO();
            List<Doacao> doacoes = doacaoDAO.listar();

            // Configurar a resposta HTTP com um tipo de conteúdo HTML
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            // Escrever a página HTML
            out.println("<html><head>");
            out.println("<link rel=\"stylesheet\" href=\"style/header.css\">");
            out.println("<link rel=\"stylesheet\" href=\"style/main.css\">");
            out.println("<link rel=\"stylesheet\" href=\"style/doacoes.css\">");
            out.println("</head><body>");
            out.println("<header></header>");
            out.println("<main><section>");
            out.println("<table>");
            out.println("<caption>Lista de Doações</caption>");
            out.println("<thead>");
            out.println("<tr><th>Quantidade</th><th>Computador</th><th>Ram</th><th>Doador</th><th>Data</th></tr>");
            out.println("</thead><tbody>");

            // Iterar sobre os resultados e exibi-los na tabela HTML
            for (Doacao doacao : doacoes) {
                out.println("<tr><td>" + doacao.getQuantidade()+ "</td><td>" + doacao.getMarcaComputador() + "</td><td>" + doacao.getQuantidadeDeRAM() + "</td><td>" + doacao.getDoador() + "</td><td>" + doacao.getDataDeChegada());
            }

            out.println("</tbody></table></section>");
            DonatarioDAO donatarioDAO = new DonatarioDAO();
            List<Donatario> donatarios = donatarioDAO.listar();
            out.println("<section><table>");
            out.println("<caption>Fila de Espera</caption>");
            out.println("<thead>");
            out.println("<tr><th>Posição</th><th>Nome</th></tr>");
            out.println("</thead><tbody>");
            for (Donatario donatario : donatarios) {
                out.println("<tr><td>" + donatario.getPosicao() + "</td><td>" + donatario.getNome() + "</td></tr>");
            }

            out.println("</tbody></table>");
            out.println("</section></main>");
            out.println("<script src=\"code/header.js\"></script>");
            out.println("</body></html>");
        } catch (SQLException ex) {
            Logger.getLogger(GestaoDoacao.class.getName()).log(Level.SEVERE, null, ex);
            // Trate a exceção de alguma forma apropriada aqui (por exemplo, exibir uma mensagem de erro).
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestaoDoacao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
