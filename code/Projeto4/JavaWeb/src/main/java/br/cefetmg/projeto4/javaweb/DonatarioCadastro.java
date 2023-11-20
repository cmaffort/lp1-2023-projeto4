package br.cefetmg.projeto4.javaweb;
import br.cefetmg.projeto4.dao.DonatarioDAO;
import br.cefetmg.projeto4.dto.DonatarioDTO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "DonatarioCadastro", urlPatterns = {"/DonatarioCadastro"})
public class DonatarioCadastro extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String nome = request.getParameter("nome");
            String CPF = request.getParameter("cpf");

            String escola = request.getParameter("escola");
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            String serie = request.getParameter("serie");
            String confirmarSenha = request.getParameter("confirmarSenha");
            try {
            DonatarioDTO donatario = new DonatarioDTO(nome, CPF, email, senha, escola, -1, Integer.parseInt(serie));
            out.println("<p>" + donatario.getCodigo() + "</p>");
            out.println("<p>" + donatario.getNome()+ "</p>");

            DonatarioDAO donatarioDAO = new DonatarioDAO();
                try {
                    if(donatarioDAO.inserir(donatario))
                    {
                        out.println("<p>inserido</p>");
                        
                        String p = request.getParameter("p");

                        if (p != null)
                            response.sendRedirect("login.jsp?p=" + p);
                        else
                            response.sendRedirect("login.jsp");
                    }
                    else
                        out.println("<p>erro</p>");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DonatarioCadastro.class.getName()).log(Level.SEVERE, null, ex);
                }
            }catch (SQLException e) {
                out.println("<p>SQLException</p>");
            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
