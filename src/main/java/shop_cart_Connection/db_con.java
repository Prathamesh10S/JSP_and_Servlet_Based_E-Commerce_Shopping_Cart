package shop_cart_Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class db_con {

    private static Connection connection = null;

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if (connection == null || connection.isClosed()) {
            Class.forName("com.mysql.cj.jdbc.Driver"); // ✅ Updated driver name
            connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/e_shopping_cart", "root", "Pratham@10");
            System.out.println("connected");
        }
        return connection;
    }
}
