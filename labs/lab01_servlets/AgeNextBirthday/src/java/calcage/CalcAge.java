/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Carlos J. Garcia Carmona
 */
@WebServlet(name = "CalcAge", urlPatterns = {"/CalcAge"})
public class CalcAge extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String age = request.getParameter("age");

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CalcAge</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Age next birthday</h1>");
            out.println("<form action='CalcAge' method='GET'>");
            out.println("<div>");
            out.println("<label>Enter your current age:</label>");
            out.println("<input type=text name='age' style='border: 3px inset'>");
            out.println("<button type=submit style='border: 3px outset'>Age next birthday</button>");
            out.println("</div>");

            if (request.getQueryString() != null) {
                if (age == null || age == "") {
                    out.println("<div>");
                    out.println("<p style='color: red'>You must give your current age</p>");
                    out.println("</div>");
                } else {
                    out.println("<div>");
                    out.println("<p>Your age next birthday will be " + (Integer.parseInt(age) + 1) + "</p>");
                    out.println("</div>");
                }
            }

            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
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
