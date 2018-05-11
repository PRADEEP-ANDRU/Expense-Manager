package expense_manager;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JProgressBar;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.security.interfaces.RSAKey;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;



public class Manager extends JFrame {

	private JPanel contentPane;
	public static JProgressBar vprog;
	public static JProgressBar fprog;
	public static JProgressBar eprog;
	public static JProgressBar gprog;
	public static JProgressBar mprog;
	public static JLabel vcost;
	public static JLabel fcost;
	public static JLabel ecost;
	public static JLabel gcost;
	public static JLabel mcost;
	public static JLabel total;
	static Connection conn;
	public String exuser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manager frame = new Manager();
					frame.setVisible(true);
					frame.setTitle("EXPENSE MANAGER");
					conn=javasql.getConnection();
					frame.fetch();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	void fetch() {
		try {
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery("select * from manag where user_name=\""+(expense_manager.user)+"\"");
			while(rs.next()) {
			int ve= Integer.parseInt(rs.getString(2));
			int fo=Integer.parseInt(rs.getString(3));
			int en=Integer.parseInt(rs.getString(4));
			int gr=Integer.parseInt(rs.getString(5));
			int mi=Integer.parseInt(rs.getString(6));
			vprog.setValue(ve/100);
			fprog.setValue(fo/100);
			eprog.setValue(en/100);
			gprog.setValue(gr/100);
			mprog.setValue(mi/100);
			
			vcost.setText("Rs: "+ve);
			fcost.setText("Rs: "+fo);
			ecost.setText("Rs: "+en);
			gcost.setText("Rs: "+gr);
			mcost.setText("Rs: "+mi);
			total.setText("Rs: "+(ve+fo+en+gr+mi));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	/**
	 * Create the frame.
	 */
	public Manager() {
		
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(600,400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		vprog = new JProgressBar();
		vprog.setForeground(Color.BLUE);
		vprog.setBounds(178, 77, 231, 14);
		contentPane.add(vprog);
		
		JLabel lblVehicle = new JLabel("Vehicle");
		lblVehicle.setForeground(new Color(128, 0, 0));
		lblVehicle.setFont(new Font("Lucida Console", Font.BOLD, 12));
		lblVehicle.setBounds(58, 77, 56, 14);
		contentPane.add(lblVehicle);
		
		JLabel lblNewLabel = new JLabel("Food");
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Lucida Console", Font.BOLD, 12));
		lblNewLabel.setBounds(58, 126, 46, 14);
		contentPane.add(lblNewLabel);
		
		fprog = new JProgressBar();
		fprog.setForeground(new Color(0, 128, 0));
		fprog.setBounds(178, 126, 231, 14);
		contentPane.add(fprog);
		
		JLabel lblEntertainment = new JLabel("Entertainment");
		lblEntertainment.setForeground(new Color(128, 0, 0));
		lblEntertainment.setFont(new Font("Lucida Console", Font.BOLD, 12));
		lblEntertainment.setBounds(58, 177, 104, 13);
		contentPane.add(lblEntertainment);
		
		eprog = new JProgressBar();
		eprog.setForeground(new Color(128, 0, 0));
		eprog.setBounds(178, 176, 231, 14);
		contentPane.add(eprog);
		
		JLabel lblGrocery = new JLabel("Grocery");
		lblGrocery.setForeground(new Color(128, 0, 0));
		lblGrocery.setFont(new Font("Lucida Console", Font.BOLD, 12));
		lblGrocery.setBounds(58, 231, 56, 13);
		contentPane.add(lblGrocery);
		
		gprog = new JProgressBar();
		gprog.setForeground(new Color(192, 192, 192));
		gprog.setBounds(178, 230, 231, 14);
		contentPane.add(gprog);
		
		JLabel lblMiscellaneous = new JLabel("Miscellaneous");
		lblMiscellaneous.setForeground(new Color(128, 0, 0));
		lblMiscellaneous.setFont(new Font("Lucida Console", Font.BOLD, 12));
		lblMiscellaneous.setBounds(58, 283, 104, 13);
		contentPane.add(lblMiscellaneous);
		
		mprog = new JProgressBar();
		mprog.setForeground(new Color(128, 0, 128));
		mprog.setBounds(178, 282, 231, 14);
		contentPane.add(mprog);
		
		JButton update = new JButton("Update");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Updat.main(null);
				dispose();
			}
		});
		update.setFont(new Font("Lucida Console", Font.BOLD, 11));
		update.setForeground(new Color(128, 0, 0));
		update.setBounds(320, 327, 89, 23);
		contentPane.add(update);
		
		JButton refresh = new JButton("Refresh");
		refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fetch();
			}
		});
		refresh.setForeground(new Color(128, 0, 0));
		refresh.setFont(new Font("Lucida Console", Font.BOLD, 11));
		refresh.setBounds(434, 327, 95, 21);
		contentPane.add(refresh);
		
		vcost = new JLabel("Rs. 0");
		vcost.setForeground(new Color(255, 255, 255));
		vcost.setFont(new Font("Lucida Console", Font.BOLD, 12));
		vcost.setBounds(434, 77, 95, 14);
		contentPane.add(vcost);
		
		fcost = new JLabel("Rs. 0");
		fcost.setForeground(new Color(255, 255, 255));
		fcost.setFont(new Font("Lucida Console", Font.BOLD, 12));
		fcost.setBounds(434, 126, 95, 14);
		contentPane.add(fcost);
		
		ecost = new JLabel("Rs. 0");
		ecost.setForeground(new Color(255, 255, 255));
		ecost.setFont(new Font("Lucida Console", Font.BOLD, 12));
		ecost.setBounds(434, 176, 95, 14);
		contentPane.add(ecost);
		
		gcost = new JLabel("Rs. 0");
		gcost.setForeground(new Color(255, 255, 255));
		gcost.setFont(new Font("Lucida Console", Font.BOLD, 12));
		gcost.setBounds(434, 230, 95, 14);
		contentPane.add(gcost);
		
		mcost = new JLabel("Rs. 0");
		mcost.setForeground(new Color(255, 255, 255));
		mcost.setFont(new Font("Lucida Console", Font.BOLD, 12));
		mcost.setBounds(434, 282, 95, 14);
		contentPane.add(mcost);
		
		JLabel userdisp = new JLabel("User : ");
		userdisp.setForeground(new Color(139, 0, 0));
		userdisp.setFont(new Font("Lucida Console", Font.BOLD, 11));
		userdisp.setBounds(10, 11, 56, 12);
		contentPane.add(userdisp);
		
		JLabel dispuser = new JLabel("null\r\n");
		dispuser.setForeground(new Color(255, 255, 255));
		dispuser.setFont(new Font("Lucida Console", Font.BOLD, 11));
		dispuser.setBounds(68, 9, 118, 14);
		contentPane.add(dispuser);
		dispuser.setText(expense_manager.user);
		
		JButton btnLogout = new JButton("Log Out");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				expense_manager.main(null);
				dispose();
			}
		});
		btnLogout.setForeground(new Color(255, 0, 0));
		btnLogout.setFont(new Font("Lucida Console", Font.BOLD, 11));
		btnLogout.setBounds(479, 11, 95, 21);
		contentPane.add(btnLogout);
		
		JLabel lblNewLabel_1 = new JLabel("Total :");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Lucida Console", Font.BOLD, 11));
		lblNewLabel_1.setBounds(353, 40, 56, 14);
		contentPane.add(lblNewLabel_1);
		
		total = new JLabel("Rs. 0");
		total.setForeground(Color.CYAN);
		total.setFont(new Font("Lucida Console", Font.BOLD, 11));
		total.setBounds(434, 39, 95, 14);
		contentPane.add(total);
	}
}
