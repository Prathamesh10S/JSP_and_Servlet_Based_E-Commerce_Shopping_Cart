package shop_cart_Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class db_con {
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Use environment variables (Render) for credentials
                String host = System.getenv("DB_HOST"); // gateway01.ap-southeast-1.prod.aws.tidbcloud.com
                String port = System.getenv("DB_PORT"); // 4000
                String db = System.getenv("DB_NAME");   // e_shopping_cart
                String user = System.getenv("DB_USER"); // 4M254KzevyVSPsk.root
                String pass = System.getenv("DB_PASS"); // Your TiDB password

                String url = "jdbc:mysql://" + host + ":" + port + "/" + db + "?useSSL=true&requireSSL=true";

                connection = DriverManager.getConnection(url, user, pass);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
