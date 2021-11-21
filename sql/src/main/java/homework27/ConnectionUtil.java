package homework27;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/university";
    private static final String LOGIN = "root";
    private static final String PASS = "yarik150883";
    private static final Connection connection = buildConnection();

    private static Connection buildConnection() {
        try {
            return DriverManager.getConnection(URL, LOGIN, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Connection getConnection(){
        return connection;
    }

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
