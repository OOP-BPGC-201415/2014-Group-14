package backend;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseManager {
	public static final String url = "jdbc:mysql://localhost:3306/";
	public static final String dbName = "MessManagement";
	public static final String driver = "com.mysql.jdbc.Driver";
	public static final String userName = "messmgt_user";
	public static final String password = "plsdonthack";
	public static Connection dbConn;

	public static Connection getConnection() {
		Connection conn = null;

		try {
			// Include The Driver

			Class.forName(driver).newInstance();

			// Making a connection Object.

			conn = DriverManager
					.getConnection(url + dbName, userName, password);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;

	}

}
