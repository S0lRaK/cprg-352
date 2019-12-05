package controller;

import dataAccess.Authentication;
import dataAccess.DBoperations;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Carlos J. Garcia Carmona <carlos.garciacarmona@edu.sait.ca>
 */
@WebServlet(name = "UserServices", urlPatterns = {"/UserServices"})
public class UserServices extends HttpServlet {

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
		// Paths
		final String PUBLIC_PATH = "/WEB-INF/";
		final String PAGE_LOGIN = "Login.jsp";
		final String PAGE_REGISTRATION = "Registration.jsp";
		final String PAGE_ORDER = "Order.jsp";
		// Messages
		final String MSG_INCOMPLETE_CREDENTIALS = "Both username and password are required!";
		final String MSG_INVALID_CREDENTIALS = "Invalid username or password!";
		final String MSG_LOGOUT = "Logged out";
		
		// Parameters
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String registration = request.getParameter("register");
		String logout = request.getParameter("logout");
		
		DBoperations dBoperations = new DBoperations();
		
		// Selected to register a new account
		if (registration != null) {
			request.getRequestDispatcher(PUBLIC_PATH + PAGE_REGISTRATION).forward(request, response);
		} 
		// Logging out
		else if (logout != null) {
			HttpSession httpSession = request.getSession();
			httpSession.invalidate();
			
			request.setAttribute("message", MSG_LOGOUT);
			request.getRequestDispatcher(PUBLIC_PATH + PAGE_LOGIN).forward(request, response);
		}
		// Logging in
		else if (username != null && !username.isEmpty() && password != null && !password.isEmpty()) {
			Authentication authentication = new Authentication();
			
			if (authentication.validateLogin(username, password)) {
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("username", username);
				request.getRequestDispatcher(PUBLIC_PATH + PAGE_ORDER).forward(request, response);
			} else {
				request.setAttribute("message", MSG_INVALID_CREDENTIALS);
				request.getRequestDispatcher(PUBLIC_PATH + PAGE_LOGIN).forward(request, response);
			}
		} 
		// Missing login credentials
		else if ((username != null && password != null) && (username.isEmpty() || password.isEmpty())) {
			request.setAttribute("message", MSG_INCOMPLETE_CREDENTIALS);
			request.getRequestDispatcher(PUBLIC_PATH + PAGE_LOGIN).forward(request, response);
		} else {
			request.getRequestDispatcher(PUBLIC_PATH + PAGE_LOGIN).forward(request, response);
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
