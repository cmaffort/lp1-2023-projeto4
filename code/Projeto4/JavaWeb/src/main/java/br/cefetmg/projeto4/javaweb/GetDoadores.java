package br.cefetmg.projeto4.javaweb;

import br.cefetmg.projeto4.dto.*;
import br.cefetmg.projeto4.dao.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GetDoadores {
    
    private List<DoadorDTO> doadoresFisicos;
    private List<DoadorJuridicoDTO> doadoresJuridicos;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try (PrintWriter out = response.getWriter()) {
            
            DoadorDAO doadorDAO = new DoadorDAO();
            DoadorJuridicoDAO doadorJuridicoDAO = new DoadorJuridicoDAO();
            
            
            doadoresFisicos = doadorDAO.listar();
            doadoresJuridicos = doadorJuridicoDAO.listar();
        
        } catch (SQLException ex) {
            Logger.getLogger(GestaoDoacao.class.getName()).log(Level.SEVERE, null, ex);
            // Trate a exceção de alguma forma apropriada aqui (por exemplo, exibir uma mensagem de erro).
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestaoDoacao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
