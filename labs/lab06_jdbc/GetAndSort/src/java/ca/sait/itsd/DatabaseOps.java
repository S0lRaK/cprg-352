package ca.sait.itsd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos J. Garcia Carmona
 */
public class DatabaseOps {

    private Connection getConnection() throws ClassNotFoundException {
        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String connectionString = "jdbc:mysql://localhost:3306/users1";
            String username = "root";
            String password = "password";

            connection = DriverManager.getConnection(connectionString, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseOps.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }

    public String getUsers(String order) throws ClassNotFoundException {
        String result = "";
        String sqlQuery = "";

        if (order.equals("asc")) {
            sqlQuery = "select * FROM users ORDER BY username ASC;";
        } else if (order.equals("desc")) {
            sqlQuery = "select * FROM users ORDER BY username DESC;";
        }

        try {
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                result += resultSet.getString(1) + ",";
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseOps.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
