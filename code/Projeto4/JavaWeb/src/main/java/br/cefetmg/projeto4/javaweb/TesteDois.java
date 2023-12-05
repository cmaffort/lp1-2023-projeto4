package br.cefetmg.projeto4.javaweb;

import br.cefetmg.projeto4.dao.DoacaoDAO;
import br.cefetmg.projeto4.dto.DoacaoDTO;
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


@WebServlet(name = "TesteDois", urlPatterns = {"/TesteDois"})
public class TesteDois extends HttpServlet {


    private List<DoacaoDTO> doacoes;
    DoacaoDAO doacaoDAO;


    public List<DoacaoDTO> getDoacoes() {

        try  {

            doacaoDAO = new DoacaoDAO();

            doacoes = doacaoDAO.listar();

        } catch (SQLException ex) {
            Logger.getLogger(GestaoDoacao.class.getName()).log(Level.SEVERE, null, ex);
            // Trate a exceção de alguma forma apropriada aqui (por exemplo, exibir uma mensagem de erro).
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestaoDoacao.class.getName()).log(Level.SEVERE, null, ex);
        } 
            return doacoes;        
    }

}