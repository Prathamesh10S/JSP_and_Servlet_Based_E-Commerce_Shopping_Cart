package shop_cart_Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class db_con {

	private static Connection connection=null;
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		if(connection==null) {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/e_shopping_cart","root","pratham@10PS");
			System.out.println("connected");
			
		}
		return connection;
	}
}
