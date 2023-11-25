package br.cefetmg.projeto4.javaweb;

import br.cefetmg.projeto4.dao.DoadorDAO;
import br.cefetmg.projeto4.dao.DoadorJuridicoDAO;
import br.cefetmg.projeto4.dao.DonatarioDAO;
import br.cefetmg.projeto4.dao.EstagiarioDAO;
import br.cefetmg.projeto4.dao.ProfessorDAO;
import br.cefetmg.projeto4.dao.UsuarioDAO;
import br.cefetmg.projeto4.dto.DoadorDTO;
import br.cefetmg.projeto4.dto.DoadorJuridicoDTO;
import br.cefetmg.projeto4.dto.DonatarioDTO;
import br.cefetmg.projeto4.dto.EstagiarioDTO;
import br.cefetmg.projeto4.dto.ProfessorDTO;
import br.cefetmg.projeto4.dto.UsuarioDTO;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.sql.SQLException;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "ServletLogin", urlPatterns = {"/ServletLogin"})
public class ServletLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ServletLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ServletLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        try (
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            DonatarioDAO donatarioDAO = new DonatarioDAO();
            DoadorDAO doadorDAO = new DoadorDAO();
            ProfessorDAO professorDAO = new ProfessorDAO();
            DoadorJuridicoDAO doadorJuridicoDAO = new DoadorJuridicoDAO();
            EstagiarioDAO estagiarioDAO = new EstagiarioDAO()
        ) {

            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            String p = request.getParameter("p");

            if (p != null)
                response.sendRedirect(p);

            UsuarioDTO usuario = usuarioDAO.selecionar(email).orElseThrow();

            if (!usuarioDAO.autenticar(usuario, senha))
                throw new IllegalArgumentException("Senha errada");

            HttpSession session = request.getSession();
            UsuarioDTO safeUsuario;

            if (usuario.getTipo().equals("DONATARIO")) {
                DonatarioDTO donatario = (DonatarioDTO) donatarioDAO.selecionar(email).orElseThrow();
                safeUsuario = donatario.safe();

                if (p == null)
                    response.sendRedirect("agendamentoEntrega.jsp");
            } else if (usuario.getTipo().equals("DOADOR")) {
                if (usuario.getTipoCodigo().equals("CPF")) {
                    DoadorDTO doador = (DoadorDTO) doadorDAO.selecionar(email).orElseThrow();
                    safeUsuario = doador.safe();
                } else {
                    DoadorJuridicoDTO doadorJuridico = (DoadorJuridicoDTO) doadorJuridicoDAO.selecionar(email).orElseThrow();
                    safeUsuario = doadorJuridico.safe();
                }

                if (p == null)
                    response.sendRedirect("cadastroDoacao.jsp");
            } else {
                if (usuario.getTipo().equals("PROFESSOR")) {
                    ProfessorDTO professor = (ProfessorDTO) professorDAO.selecionar(email).orElseThrow();
                    safeUsuario = professor.safe();
                } else {
                    EstagiarioDTO estagiario = (EstagiarioDTO) estagiarioDAO.selecionar(email).orElseThrow();
                    safeUsuario = estagiario.safe();
                }

                if (p == null)
                    response.sendRedirect("MostrarDoacoes");
            }

            session.setAttribute("usuario", safeUsuario);
        } catch (NoSuchElementException e) {
            String p = request.getParameter("p");

            if (p != null)
                response.sendRedirect("cadastro.jsp?p=" + p);
            else
                response.sendRedirect("cadastro.jsp");
        } catch (IllegalArgumentException e) {
            response.sendRedirect("login.jsp?status=fail");
        } catch (SQLException e) {
            System.err.println("Error: " + e);
        }
    }
}
