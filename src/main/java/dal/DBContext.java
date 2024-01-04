package dal;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBContext {
	protected Connection connection;

	public DBContext() {
		String name = "root";
		String pass = "kinhvanhoa0";
		String url = "jdbc:mariadb://cloud.joverse.me:3001/occupationdb";
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			connection = DriverManager.getConnection(url, name, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
