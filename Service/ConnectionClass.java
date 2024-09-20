package Service;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClass {
	
	public static Connection  getcon() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/b182","root","root");
		return con;
	}
}
