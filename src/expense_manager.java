package expense_manager;
import expense_manager.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class expense_manager extends JFrame {

	public static JPanel contentPane;
	public JTextField LI_user;
	public JPasswordField LI_pass;
	static Connection conn;
	public static String user;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					expense_manager frame = new expense_manager();
					frame.setVisible(true);
					
					conn=javasql.getConnection();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public expense_manager() {
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(85, 107, 47));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 585, 420);
		setSize(600,400);
		setTitle("EXPENSE MANGER");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, -13, 169, 394);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setIcon(new ImageIcon("images\\em2.png"));
		panel.add(lblNewLabel);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				int flag=0;
			try {
				Statement statement=conn.createStatement();
				ResultSet rs=statement.executeQuery("select * from login");
				
				while(rs.next()) {
					if(rs.getString(1).equals(LI_user.getText()) && rs.getString(2).equals(LI_pass.getText())) {
						user=LI_user.getText();
						flag=1;
						break;
					}
				}
				if(flag==1) {
					Manager.main(null);
					dispose();
				}
				else JOptionPane.showMessageDialog(new JFrame(), "Invalid Credentials!");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
		btnLogin.setForeground(new Color(139, 0, 0));
		btnLogin.setFont(new Font("Lucida Console", Font.BOLD, 12));
		btnLogin.setBackground(new Color(255, 255, 224));
		btnLogin.setBounds(266, 279, 89, 23);
		contentPane.add(btnLogin);
		
		LI_user = new JTextField();
		LI_user.setBounds(298, 111, 179, 23);
		contentPane.add(LI_user);
		LI_user.setColumns(10);
		
		LI_pass = new JPasswordField();
		LI_pass.setBounds(298, 189, 179, 23);
		contentPane.add(LI_pass);
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogOn.main(null);
				dispose();
				}
		});

		btnNewButton.setForeground(new Color(139, 0, 0));
		btnNewButton.setFont(new Font("Lucida Console", Font.BOLD, 12));
		btnNewButton.setBounds(398, 279, 98, 23);
		contentPane.add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(168, 246, 401, 2);
		contentPane.add(separator);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(new Color(253, 245, 230));
		lblUsername.setFont(new Font("Lucida Console", Font.PLAIN, 11));
		lblUsername.setBounds(227, 116, 61, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(253, 245, 230));
		lblPassword.setFont(new Font("Lucida Console", Font.PLAIN, 11));
		lblPassword.setBounds(227, 194, 61, 14);
		contentPane.add(lblPassword);
		
	}
	
}
