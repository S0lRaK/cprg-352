package ca.sait.itsd;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "JDBCcontroller", urlPatterns = {"/JDBCcontroller"})
public class JDBCcontroller extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException {
        String action = request.getParameter("action");
        String username = request.getParameter("username");
        String newUsername = request.getParameter("newUsername");
        
        DBoperationsCS dbOps = new DBoperationsCS();
        
        if (action != null && !action.equals("")) {
            switch (action) {
                case "add":
                    if (dbOps.addUsername(username)) {
                        request.setAttribute("message", "New username added");
                    } else {
                        request.setAttribute("message", "Error adding username!");
                    }   break;
                case "delete":
                    if (dbOps.deleteUsername(username)) {
                        request.setAttribute("message", "Username deleted");
                    } else {
                        request.setAttribute("message", "Error deleting username!");
                    }   break;
                case "update":
                    if (dbOps.updateUsername(username, newUsername)) {
                        request.setAttribute("message", "Username updated");
                    } else {
                        request.setAttribute("message", "Error updating username!");
                    }   break;
                default:
                    break;
            }
        }
        request.setAttribute("namesList", dbOps.getUsernames());
        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JDBCcontroller.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JDBCcontroller.class.getName()).log(Level.SEVERE, null, ex);
        }
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
