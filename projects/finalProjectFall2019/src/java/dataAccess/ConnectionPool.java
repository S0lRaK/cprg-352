package dataAccess;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Carlos J. Garcia Carmona <carlos.garciacarmona@edu.sait.ca>
 */
public class ConnectionPool {
	
	private static final String CONNECTION_POOL = "java:/comp/env/jdbc/finalProjectFall2019";
	private static ConnectionPool connectionPool = null;
	private static DataSource dataSource = null;
	
	private ConnectionPool() {
		try {
			InitialContext initialContext = new InitialContext();
			dataSource = (DataSource) initialContext.lookup(CONNECTION_POOL);
		} catch (NamingException ex) {
			Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public static synchronized ConnectionPool getInstance() {
		if (connectionPool == null) {
			connectionPool = new ConnectionPool();
		}
		return connectionPool;
	}
	
	public Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException ex) {
			Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}
	
	public void freeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException ex) {
			Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
