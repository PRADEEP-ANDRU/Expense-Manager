package expense_manager;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.*;

public class Observer {
		static Connection conn;
		
	public static void updateall() {
		conn=javasql.getConnection();
		
		try {
			JOptionPane.showMessageDialog(new JFrame(),"Created Succesfully!");
			PreparedStatement ps1=conn.prepareStatement("INSERT INTO manag VALUES (?,?,?,?,?,?)");
			ps1.setString(1, LogOn.ouser);
			ps1.setInt(2, 0);
			ps1.setInt(3, 0);
			ps1.setInt(4, 0);
			ps1.setInt(5, 0);
			ps1.setInt(6, 0);
			ps1.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
