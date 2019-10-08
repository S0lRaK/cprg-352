package ca.sait.itsd;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Carlos J. Garcia Carmona
 */
@WebServlet(name = "UserLogin", urlPatterns = {"/UserLogin"})
public class UserLogin extends HttpServlet {

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
        ArrayList<Product> products = new ArrayList<>();
        
        // Log out
        if (logout != null) {
            httpSession.invalidate();
            request.setAttribute("message", "Logged out");
            request.getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(request, response);
        } // Session exists
        else if (httpSession.getAttribute("username") != null) {
            request.getRequestDispatcher("/WEB-INF/products.jsp")
                    .forward(request, response);
        } // No login data
        else if (username == null || password == null) {
            request.getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(request, response);
        } // Empty login data
        else if (username.equals("") || password.equals("")) {
            request.setAttribute("message", "Both username and password are required!");
            request.getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(request, response);
        } // Login data validation
        else {
            if (username.equals("user") && password.equals("pass")) {
                httpSession.setAttribute("username", "user");
                httpSession.setAttribute("products", products);
                request.getRequestDispatcher("/WEB-INF/products.jsp")
                        .forward(request, response);
            } else {
                request.setAttribute("message", "Invalid username or password!");
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
