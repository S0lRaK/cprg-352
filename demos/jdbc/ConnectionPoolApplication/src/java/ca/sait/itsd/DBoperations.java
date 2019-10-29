package ca.sait.itsd;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos J. Garcia Carmona <carlos.garciacarmona@edu.sait.ca>
 */
public class DBoperations {

    public String getUsernames() {
        String usernames = "";
        ConnectionPool pool = ConnectionPool.getInstance();

        try {
            Connection connection = pool.getConnection();
            String sqlQuery = "SELECT * FROM users;";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {
                usernames += resultSet.getString(1) + ",";
            }

            resultSet.close();
            statement.close();

            pool.freeConnection(connection);

        } catch (SQLException ex) {
            Logger.getLogger(DBoperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usernames;
    }
}
