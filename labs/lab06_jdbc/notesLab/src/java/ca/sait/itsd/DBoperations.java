package ca.sait.itsd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos J. Garcia Carmona
 */
public class DBoperations {

    private Connection getConnection() throws ClassNotFoundException {
        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String connectionString = "jdbc:mysql://localhost:3306/notes";
            String username = "root";
            String password = "password";

            connection = DriverManager.getConnection(connectionString, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(DBoperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }

    public ArrayList getNotes() throws ClassNotFoundException {
        String sqlQuery = "SELECT * FROM notes;";
        ArrayList list = new ArrayList();

        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            int idIndex = resultSet.findColumn("noteID");
            int textIndex = resultSet.findColumn("noteText");
            int dateTimeIndex = resultSet.findColumn("noteDateTime");

            while (resultSet.next()) {
                Map note = new HashMap();

                int id = resultSet.getInt(idIndex);
                note.put("id", id);

                String text = resultSet.getString(textIndex);
                note.put("text", text);

                Timestamp dateTime = resultSet.getTimestamp(dateTimeIndex);
                note.put("dateTime", dateTime);

                list.add(note);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBoperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public boolean addNote(String note) throws ClassNotFoundException {
        boolean isRowAffected = false;
        String sqlQuery = "INSERT INTO notes (noteText) VALUES ('" + note + "');";

        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();

            int numRowsAffected = statement.executeUpdate(sqlQuery);
            isRowAffected = (numRowsAffected > 0);

            statement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBoperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isRowAffected;
    }
    
    public boolean deleteNote(String noteId) throws ClassNotFoundException {
        boolean isRowAffected = false;
        String sqlQuery = "DELETE FROM notes WHERE noteID='" + noteId + "';";

        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();

            int numRowsAffected = statement.executeUpdate(sqlQuery);
            isRowAffected = (numRowsAffected > 0);

            statement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBoperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isRowAffected;
    }
}
