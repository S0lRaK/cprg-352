package ca.sait.itsd;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Carlos J. Garcia Carmona
 */
public class DBoperationsCS {

    private Connection getConnection() throws ClassNotFoundException {
        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String connectionString = "jdbc:mysql://localhost:3306/users1";
            String username = "root";
            String password = "password";

            connection = DriverManager.getConnection(connectionString, username, password);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return connection;
    }

    public String getUsernames() throws ClassNotFoundException {
        String sql = "select * from users;";
        String result = "";

        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                result += resultSet.getString(1) + ",";
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return result;
    }

    public boolean addUsername(String username) throws ClassNotFoundException {
        boolean result = false;
        String sql = "call addUsername(?);";

        try {
            Connection connection = getConnection();
            CallableStatement statement = connection.prepareCall(sql);
            statement.setString(1, username);

            int rowsAffected = statement.executeUpdate();
            result = (rowsAffected > 0);

            statement.close();
            connection.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return result;
    }

    public boolean deleteUsername(String username) throws ClassNotFoundException {
        boolean result = false;
        String sql = "call deleteUsername(?);";

        try {
            Connection connection = getConnection();
            CallableStatement statement = connection.prepareCall(sql);
            statement.setString(1, username);

            int rowsAffected = statement.executeUpdate();
            result = (rowsAffected > 0);

            statement.close();
            connection.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return result;
    }
    
    public boolean updateUsername(String username, String newUsername) throws ClassNotFoundException {
        boolean result = false;
        String sql = "call updateUsername(?,?);";

        try {
            Connection connection = getConnection();
            CallableStatement statement = connection.prepareCall(sql);
            statement.setString(1, username);
            statement.setString(2, newUsername);

            int rowsAffected = statement.executeUpdate();
            result = (rowsAffected > 0);

            statement.close();
            connection.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return result;
    }
}
