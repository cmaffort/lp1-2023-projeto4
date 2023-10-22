package br.cefetmg.projeto4.javaweb;

import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello ";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        String nome = request.getParameter("login");

        String senha = request.getParameter("senha");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1> Bem vindo" + nome + "</h1>");
        out.println("<p> Senha: " + senha + "</p>");

        out.println("</body></html>");
    }

    public void destroy() {
    }
}