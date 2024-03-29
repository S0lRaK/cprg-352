package ca.sait.itsd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos J. Garcia Carmona <carlos.garciacarmona@edu.sait.ca>
 */
public class DBoperations {

	private Connection getConnection() throws ClassNotFoundException {
		Connection connection = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String connectionString = "jdbc:mysql://localhost:3306/assign2fall2019";
			String username = "root";
			String password = "password";

			connection = DriverManager.getConnection(connectionString, username, password);
		} catch (SQLException exception) {
			Logger.getLogger(DBoperations.class.getName()).log(Level.SEVERE, null, exception);
		}
		return connection;
	}

	public ArrayList getProducts() throws ClassNotFoundException {
		String sqlQuery = "SELECT * FROM product;";
		ArrayList list = new ArrayList();

		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
			ResultSet resultSet = preparedStatement.executeQuery();

			int idIndex = resultSet.findColumn("productID");
			int descriptionIndex = resultSet.findColumn("productDesc");
			int unitPriceIndex = resultSet.findColumn("productUnitPrice");
			int stockLevelIndex = resultSet.findColumn("productStockLevel");

			while (resultSet.next()) {
				Product product = new Product();

				int id = resultSet.getInt(idIndex);
				product.setProductID(id);

				String description = resultSet.getString(descriptionIndex);
				product.setProductDescription(description);

				float unitPrice = resultSet.getFloat(unitPriceIndex);
				product.setProductUnitPrice(unitPrice);

				int stockLevel = resultSet.getInt(stockLevelIndex);
				product.setProductStockLevel(stockLevel);

				list.add(product);
			}

			resultSet.close();
			preparedStatement.close();
			connection.close();
		} catch (SQLException exception) {
			Logger.getLogger(DBoperations.class.getName()).log(Level.SEVERE, null, exception);
		}
		return list;
	}

	public boolean addProduct(String description, float unitPrice, int stockLevel) throws ClassNotFoundException {
		boolean isRowAffected = false;
		String sqlQuery = "INSERT INTO product ("
				+ "productDesc, productUnitPrice, productStockLevel"
				+ ") "
				+ "VALUES (?, ?, ?);";

		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setString(1, description);
			preparedStatement.setFloat(2, unitPrice);
			preparedStatement.setInt(3, stockLevel);

			int numRowsAffected = preparedStatement.executeUpdate();
			isRowAffected = (numRowsAffected > 0);

			preparedStatement.close();
			connection.close();
		} catch (SQLException ex) {
			Logger.getLogger(DBoperations.class.getName()).log(Level.SEVERE, null, ex);
		}
		return isRowAffected;
	}

	public boolean deleteProduct(int productId) throws ClassNotFoundException {
		boolean isRowAffected = false;
		String sqlQuery = "DELETE FROM product "
				+ "WHERE productID=?;";

		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setInt(1, productId);

			int numRowsAffected = preparedStatement.executeUpdate();
			isRowAffected = (numRowsAffected > 0);

			preparedStatement.close();
			connection.close();
		} catch (SQLException ex) {
			Logger.getLogger(DBoperations.class.getName()).log(Level.SEVERE, null, ex);
		}
		return isRowAffected;
	}

	public boolean updateProduct(int productId, String description, float unitPrice, int stockLevel) throws ClassNotFoundException {
		boolean isRowAffected = false;
		String sqlQuery = "UPDATE product "
				+ "SET productDesc=?, productUnitPrice=?, productStockLevel=? "
				+ "WHERE productID=?;";
		
		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setString(1, description);
			preparedStatement.setFloat(2, unitPrice);
			preparedStatement.setInt(3, stockLevel);
			preparedStatement.setInt(4, productId);
			
			int numRowsAffected = preparedStatement.executeUpdate();
			isRowAffected = (numRowsAffected > 0);
			
			preparedStatement.close();
			connection.close();
		} catch (SQLException ex) {
			Logger.getLogger(DBoperations.class.getName()).log(Level.SEVERE, null, ex);
		}
		return isRowAffected;
	}
}
