package dataAccess;

//import com.mysql.jdbc.Connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Carlos J. Garcia Carmona <carlos.garciacarmona@edu.sait.ca>
 */
public class Authentication {
	
	public boolean validateLogin(String username, String password) {
		
		// Initial values
		boolean isValid = false;
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		
		String sqlQuery = "SELECT * "
					+ "FROM users "
					+ "WHERE username=? AND password=?;";
		
		try {
			Connection connection = connectionPool.getConnection();
			
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				isValid = true;
			}
			
			resultSet.close();
			preparedStatement.close();
			connectionPool.freeConnection(connection);
		} catch (SQLException ex) {
			Logger.getLogger(Authentication.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return isValid;
	}
}
