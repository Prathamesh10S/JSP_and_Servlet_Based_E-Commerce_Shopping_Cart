package shop_cart_Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class db_con {
	private static Connection connection;

	public static Connection getConnection() {
		if (connection == null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/e_shopping_cart";
				String user = "root";
				String pass = "Pratham@10";
				connection = DriverManager.getConnection(url, user, pass);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return connection;
	}
}
