package br.cefetmg.projeto4.javaweb;

import br.cefetmg.projeto4.dto.DoadorFisica;
import br.cefetmg.projeto4.dto.DoadorJuridica;
import br.cefetmg.projeto4.dao.DoadorFisicaDAO;
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
            DoadorFisicaDAO doadorFisicaDAO = new DoadorFisicaDAO();
            List<DoadorFisica> doadoresFisicos = doadorFisicaDAO.listar();
            DoadorJuridicoDAO doadorJuridicoDAO = new DoadorJuridicoDAO();
            List<DoadorJuridica> doadoresjuridicos = doadorJuridicoDAO.listar();
            
        }
        catch (SQLException ex) {
            Logger.getLogger(GestaoDoacao.class.getName()).log(Level.SEVERE, null, ex);
            // Trate a exceção de alguma forma apropriada aqui (por exemplo, exibir uma mensagem de erro).
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestaoDoacao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
