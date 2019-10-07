package ca.sait.itsd;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Carlos J. Garcia Carmona
 */
@WebServlet(name = "StudentController", urlPatterns = {"/StudentController"})
public class StudentController extends HttpServlet {

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

        final String MSG_INCOMPLETE = "All values are required";
        final String MSG_ADD = "Added new student";
        final String MSG_DELETE = "Deleted student";
        String add = request.getParameter("add");
        String delete = request.getParameter("delete");
        String report = request.getParameter("report");
        String back = request.getParameter("back");

        if (back != null) {
            request.getRequestDispatcher("/WEB-INF/studentList.jsp")
                    .forward(request, response);
        } else if (report != null) {
            request.getRequestDispatcher("/WEB-INF/studentReport.jsp")
                    .forward(request, response);
        } else if (add != null) {
            String name = request.getParameter("name");
            String id = request.getParameter("id");
            String email = request.getParameter("email");

            if (name.equals("") || id.equals("") || email.equals("")) {
                request.setAttribute("message", MSG_INCOMPLETE);
                request.getRequestDispatcher("/WEB-INF/studentList.jsp")
                        .forward(request, response);
            } else {
                request.setAttribute("message", MSG_ADD);
                request.getRequestDispatcher("/WEB-INF/studentList.jsp")
                        .forward(request, response);
            }
        } else if (delete != null) {
            request.setAttribute("message", MSG_DELETE);
            request.getRequestDispatcher("/WEB-INF/studentList.jsp")
                    .forward(request, response);
        } else {
            request.getRequestDispatcher("/WEB-INF/studentList.jsp")
                    .forward(request, response);
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
