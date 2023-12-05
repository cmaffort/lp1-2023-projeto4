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

public class GetManutencao {

    private List<MantecaoDTO> manutencoes;
    MantecaoDAO manutencaoDAO;


    public List<MantecaoDTO> getManutencoes() {
            try {

            manutencaoDAO = new MantecaoDAO();

            manutencoes = manutencaoDAO.listar();

        } catch (SQLException ex) {
            Logger.getLogger(GestaoDoacao.class.getName()).log(Level.SEVERE, null, ex);
            // Trate a exceção de alguma forma apropriada aqui (por exemplo, exibir uma mensagem de erro).
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestaoDoacao.class.getName()).log(Level.SEVERE, null, ex);
        }
            return manutencoes;        
    }


}
