import java.sql.Connection;
import java.sql.DriverManager;

public class db_con {
	private static Connection connection;

	public static Connection getConnection() {
		if (connection == null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");

				String host = System.getenv("DB_HOST");
				String port = System.getenv("DB_PORT");
				String db = System.getenv("DB_NAME");
				String user = System.getenv("DB_USER");
				String pass = System.getenv("DB_PASS");

				// TEMPORARY: disable SSL
				String url = "jdbc:mysql://" + host + ":" + port + "/" + db + "?useSSL=false";

				System.out.println("Connecting to DB at: " + url);
				connection = DriverManager.getConnection(url, user, pass);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return connection;
	}
}
