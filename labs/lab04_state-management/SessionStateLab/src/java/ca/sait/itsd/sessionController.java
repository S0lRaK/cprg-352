/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sait.itsd;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "sessionController", urlPatterns = {"/sessionController"})
public class sessionController extends HttpServlet {

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
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String logout = request.getParameter("logout");
        HttpSession httpSession = request.getSession();

        // Log out
        if (logout != null) {
            httpSession.invalidate();
            request.setAttribute("message", "Logged out");
            request.getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(request, response);
        } // Session exists
        else if (httpSession.getAttribute("username") != null) {
            request.getRequestDispatcher("/WEB-INF/mainpage.jsp")
                    .forward(request, response);
        } // No login data
        else if (username == null || password == null) {
            request.getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(request, response);
        } // Empty login data
        else if (username.equals("") || password.equals("")) {
            request.setAttribute("message", "Username and password are required");
            request.getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(request, response);
        } // Login data validation
        else {
            if (username.equals("user") && password.equals("pass")) {
                httpSession.setAttribute("username", "user");
                request.getRequestDispatcher("/WEB-INF/mainpage.jsp")
                        .forward(request, response);
            } else {
                request.setAttribute("message", "Invalid username or password");
                request.getRequestDispatcher("/WEB-INF/login.jsp")
                        .forward(request, response);
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
