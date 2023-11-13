package br.cefetmg.projeto4.javaweb;


import br.cefetmg.projeto4.dao.VerificarTipoUsuarioDAO;
import br.cefetmg.projeto4.dao.mysql.MySqlConnection;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    private boolean verificarTabela(Connection conexao, String tabela, String login, String senha) throws SQLException
    {
        try {
            PreparedStatement statement = conexao.prepareStatement("SELECT * FROM " + tabela + " WHERE email = ? AND senha = ?");
            statement.setString(1, login);
            statement.setString(2, senha);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch(SQLException e)
        {
                System.out.println(e.getMessage());
                return false;
        }
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String salvando = "nao salvo";
            String email = request.getParameter("login");
            String senha = request.getParameter("senha");
            VerificarTipoUsuarioDAO verificar = new VerificarTipoUsuarioDAO();
            salvando = verificar.getTipoUsuario(email, senha);
            if(salvando.equals("doadorFisica") || salvando.equals("doadorJuridica"))
                response.sendRedirect("cadastroDoacao.jsp");
            if(salvando.equals("estagiarios") || salvando.equals("professores"))
                response.sendRedirect("MostrarDoacoes");
        }
    }
}
