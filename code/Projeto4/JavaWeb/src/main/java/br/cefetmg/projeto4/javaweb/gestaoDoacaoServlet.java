package br.cefetmg.projeto4.javaweb;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import br.cefetmg.projeto4.dao.mysql.MySqlConnection;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "gestaoDoacaoServlet", urlPatterns = {"/gestaoDoacaoServlet"})
public class gestaoDoacaoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            MySqlConnection mySqlConnection = new MySqlConnection();
            // Criar uma declaração SQL
            try ( // Conectar ao banco de dados
                    Connection connection = mySqlConnection.getConexao()) {
                // Criar uma declaração SQL
                String sql1 = "SELECT quantidade, dataDeChegada, marca, modeloProcessador, , FROM doacao";
                Statement statement = connection.createStatement();
                String newSql = "SELECT id, nome_aluno FROM fila_espera";
                // Executar a consulta SQL
                ResultSet resultSet = statement.executeQuery(sql);
            }
        } catch (Exception e) {
            e.printStackTrace();
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
