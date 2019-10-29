package ca.sait.itsd;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Carlos J. Garcia Carmona <carlos.garciacarmona@edu.sait.ca>
 */
@WebServlet(name = "JPAcontroller", urlPatterns = {"/JPAcontroller"})
public class JPAcontroller extends HttpServlet {

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
        DBoperations dBoperations = new DBoperations();

        String action = request.getParameter("action");
        String username = request.getParameter("username");
        String newUsername = request.getParameter("newUsername");

        if (action != null && !action.equals("")) {
            switch (action) {
                case "add":
                    if (dBoperations.addUsername(username)) {
                        request.setAttribute("message", "Username added");
                    } else {
                        request.setAttribute("message", "Error adding username!");
                    }
                    break;
                case "delete":
                    if (dBoperations.deleteUsername(username)) {
                        request.setAttribute("message", "Username deleted");
                    } else {
                        request.setAttribute("message", "Error deleting username!");
                    }
                    break;
                case "update":
                    if (dBoperations.updateUsername(username, newUsername)) {
                        request.setAttribute("message", "Username updated");
                    } else {
                        request.setAttribute("message", "Error updating username!");
                    }
                    break;
            }
        }

        request.setAttribute("namesList", dBoperations.getUsernames());
        request.getRequestDispatcher("/WEB-INF/index.jsp")
                .forward(request, response);
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
