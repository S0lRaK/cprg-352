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
 * @author Carlos J. Garcia Carmona <carlos.garciacarmona@edu.sait.ca>
 */
@WebServlet(name = "ProductController", urlPatterns = {"/ProductController"})
public class ProductController extends HttpServlet {

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
	 * methods.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 * @throws java.lang.ClassNotFoundException
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException {
		final String MSG_INCOMPLETE = "All values are required!";
		final String MSG_ADD = "New product added";
		final String MSG_ADD_ERROR = "Error adding product!";
		final String MSG_DELETE = "Product deleted";
		final String MSG_DELETE_ERROR = "Error deleting product!";
		final String MSG_UPDATE = "Product updated";
		final String MSG_UPDATE_ERROR = "Error updating product!";
		String report = request.getParameter("report");
		String description = request.getParameter("description");
		String unitPrice = request.getParameter("unitPrice");
		String stockLevel = request.getParameter("stockLevel");
		String action = request.getParameter("action");
		String id = request.getParameter("id");

		DBoperations dBoperations = new DBoperations();

		if (report != null) {
			request.getRequestDispatcher("/WEB-INF/inventoryReport.jsp")
					.forward(request, response);
		} else if (action != null && !action.equals("")) {
			switch (action) {
				case "add":
					if (description != null && !description.equals("")
							&& unitPrice != null && !unitPrice.equals("")
							&& stockLevel != null && !stockLevel.equals("")) {
						if (dBoperations.addProduct(description, Float.parseFloat(unitPrice), Integer.parseInt(stockLevel))) {
							request.setAttribute("message", MSG_ADD);
						} else {
							request.setAttribute("message", MSG_ADD_ERROR);
						}
					} else {
						request.setAttribute("message", MSG_INCOMPLETE);
					}
					break;
				case "delete":
					if (dBoperations.deleteProduct(Integer.parseInt(id))) {
						request.setAttribute("message", MSG_DELETE);
					} else {
						request.setAttribute("message", MSG_DELETE_ERROR);
					}
					break;
				case "update":
					request.getRequestDispatcher("/WEB-INF/update.jsp")
							.forward(request, response);
					break;
				case "save":
//					if (dBoperations.updateUsername(username, newUsername)) {
//						request.setAttribute("message", "Username updated");
//					} else {
//						request.setAttribute("message", "Error updating username!");
//					}
					break;
				default:
					break;
			}
		}
//		else {
//			
//		}
		request.setAttribute("productList", dBoperations.getProducts());
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
			Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
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
			Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
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
