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

@WebServlet(name = "GestaoGeralServlet", urlPatterns = {"/GestaoGeralServlet"})
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
        
        try {
                DoadorDAO doadorDAO = new DoadorDAO();
                DoadorJuridicoDAO doadorJuridicoDAO = new DoadorJuridicoDAO();
                MantecaoDAO manutencaoDAO = new MantecaoDAO();
                EstagiarioDAO estagiarioDAO = new EstagiarioDAO();
                ProfessorDAO professorDAO = new ProfessorDAO();
                DoacaoDAO doacaoDAO = new DoacaoDAO();
                
                List<DoadorDTO> doadoresFisicos = doadorDAO.listar();
                List<DoadorJuridicoDTO> doadoresJuridicos = doadorJuridicoDAO.listar();
                List<MantecaoDTO> manutencoes = manutencaoDAO.listar();
                List<EstagiarioDTO> estagiarios = estagiarioDAO.listar();
                List<ProfessorDTO> professoress = professorDAO.listar();
                List<DoacaoDTO> doacoes = doacaoDAO.listar();
                
                 
        } catch (SQLException ex) {
            Logger.getLogger(GestaoDoacao.class.getName()).log(Level.SEVERE, null, ex);
            // Trate a exceção de alguma forma apropriada aqui (por exemplo, exibir uma mensagem de erro).
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestaoDoacao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
        
    }

    
    

}
