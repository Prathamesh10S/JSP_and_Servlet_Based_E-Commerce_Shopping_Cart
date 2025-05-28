package shop_cart_Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class db_con {
	private static Connection connection;

	public static Connection getConnection() {
		if (connection == null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url = "jdbc:mysql://tramway.proxy.rlwy.net:17831/railway";
				String user = "root";
				String pass = "zOazkzJAQXWEpPBleqxgFzrlhRDbhYDE";
				connection = DriverManager.getConnection(url, user, pass);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return connection;
	}
}
