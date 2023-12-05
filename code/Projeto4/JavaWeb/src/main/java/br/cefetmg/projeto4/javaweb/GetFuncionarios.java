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
import java.util.Scanner;

public class GetFuncionarios {

    private List<EstagiarioDTO> estagiarios;
    private List<ProfessorDTO> professores;
    EstagiarioDAO estagiarioDAO;
    ProfessorDAO professorDAO;


    public List<EstagiarioDTO> getEstagiario() {

        try {

            estagiarioDAO = new EstagiarioDAO();


            estagiarios = estagiarioDAO.listar();

        } catch (SQLException ex) {
            Logger.getLogger(GestaoDoacao.class.getName()).log(Level.SEVERE, null, ex);
            // Trate a exceção de alguma forma apropriada aqui (por exemplo, exibir uma mensagem de erro).
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestaoDoacao.class.getName()).log(Level.SEVERE, null, ex);
        } 
            return estagiarios;

    }

    public List<ProfessorDTO> getProfessor() {

        try {

            professorDAO = new ProfessorDAO();


            professores = professorDAO.listar();

        } catch (SQLException ex) {
            Logger.getLogger(GestaoDoacao.class.getName()).log(Level.SEVERE, null, ex);
            // Trate a exceção de alguma forma apropriada aqui (por exemplo, exibir uma mensagem de erro).
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestaoDoacao.class.getName()).log(Level.SEVERE, null, ex);
        } 
            return professores;

    }




}