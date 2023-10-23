/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.projeto4.javaweb;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "DoadorServlet", urlPatterns = {"/DoadorServlet"})

/**
 *
 * @author lucas
 */
public class ServletLogin extends HttpServlet {
        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                    response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) { 
            out.println("<p>" + request.getParameter("login") + "</p><br><p>" + request.getParameter("senha"));

        }

       }
}
