package homework27;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * An util singleton for creating connection to database server.
 * Uses system environment variables {@code SQL_LOGIN} and {@code SQL_PASS}
 * for access to MySQL server.
 */
public class ConnectionUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/university";
    private static final String LOGIN = System.getenv("SQL_LOGIN");
    private static final String PASS = System.getenv("SQL_PASS");
    private static final Connection connection = buildConnection();

    private static Connection buildConnection() {
        try {
            return DriverManager.getConnection(URL, LOGIN, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Returns connection
    public static Connection getConnection(){
        return connection;
    }

    // Connection close
    public static void shutdown(){
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
