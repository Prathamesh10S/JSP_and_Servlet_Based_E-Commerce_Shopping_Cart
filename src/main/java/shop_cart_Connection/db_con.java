package shop_cart_Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class db_con {

    private static Connection connection = null;

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if (connection == null || connection.isClosed()) {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Fetch credentials from Railway environment variables
            String host = System.getenv("MYSQLHOST");
            String database = System.getenv("MYSQLDATABASE");
            String user = System.getenv("MYSQLUSER");
            String password = System.getenv("MYSQLPASSWORD");

            String url = "jdbc:mysql://" + host + ":3306/" + database + "?useSSL=false&serverTimezone=UTC";

            connection = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Connected to Railway MySQL");
        }
        return connection;
    }
}
