package personalfinancemanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseManager {
    // JDBC URL, username, and password of MySQL server
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/personalfinancemanagement";
    private static final String DB_USER = "";
    private static final String DB_PASSWORD = "";

    // Database table
    private static final String TABLE_NAME = "users";

    // Insert query
    private static final String INSERT_QUERY = "INSERT INTO " + TABLE_NAME + " (username, email, password) VALUES (?, ?, ?)";

    // Method to insert user data into the database
    public static void insertUserData(String username, String email, String password) {
              try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            try (
                // Establish a connection to the database
                Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
                // Create a PreparedStatement for the insert query
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY)
            ) {
                // Set the parameters for the PreparedStatement
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, email);
                preparedStatement.setString(3, password);

                // Execute the insert query
                int rowsInserted = preparedStatement.executeUpdate();

                if (rowsInserted > 0) {
                    System.out.println("User data inserted successfully.");
                } else {
                    System.out.println("User data insertion failed.");
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC driver not found.");
        } catch (SQLException e) {
            System.out.println("Error inserting user data: " + e.getMessage());
        }
    }
}
