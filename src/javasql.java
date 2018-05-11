package expense_manager;
import java.sql.*;

public class javasql {
	private static Connection conn;
	
	public static Connection getConnection() {
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Connection Succesfull!");
		
		return conn;
	}
}
