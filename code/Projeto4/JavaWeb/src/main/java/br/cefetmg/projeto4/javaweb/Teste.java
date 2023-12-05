package br.cefetmg.projeto4.javaweb;

import br.cefetmg.projeto4.dto.*;
import br.cefetmg.projeto4.dao.*;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Teste", urlPatterns = {"/Teste"})
public class Teste extends HttpServlet {

    private List<DoadorDTO> doadoresFisicos;
    private List<DoadorDTO> doadoresJuridicos;
    DoadorDAO doadorDAO;
    DoadorJuridicoDAO doadorJuridicoDAO;


    public List<DoadorDTO> getDoadorFisico() {
        try {

            doadorDAO = new DoadorDAO();
            doadoresFisicos = doadorDAO.listar();

        } catch (SQLException ex) {
            Logger.getLogger(GestaoDoacao.class.getName()).log(Level.SEVERE, null, ex);
            // Trate a exceção de alguma forma apropriada aqui (por exemplo, exibir uma mensagem de erro).
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestaoDoacao.class.getName()).log(Level.SEVERE, null, ex);
        }   
            return doadoresFisicos;

    }

    public List<DoadorDTO> getDoadoresJuridicos() {

        try {

            doadorJuridicoDAO = new DoadorJuridicoDAO();
            doadoresJuridicos = doadorJuridicoDAO.listar();

        } catch (SQLException ex) {
            Logger.getLogger(GestaoDoacao.class.getName()).log(Level.SEVERE, null, ex);
            // Trate a exceção de alguma forma apropriada aqui (por exemplo, exibir uma mensagem de erro).
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestaoDoacao.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return doadoresJuridicos;

    }

}