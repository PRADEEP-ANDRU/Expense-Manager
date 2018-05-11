package expense_manager;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class LogOn extends JFrame {

	private JPanel contentPane;
	private JTextField SU_user;
	private JTextField SU_pass;
	private JTextField SU_age;
	private JTextField SU_salary;
	static Connection conn;
	public static String ouser;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogOn frame = new LogOn();
					frame.setVisible(true);
					frame.setTitle("Sign Up");
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
	public LogOn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 508, 369);
		setSize(600,400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(86, 57, 407, 231);
		panel.setLayout(null);
		panel.setBackground(new Color(165, 42, 42));
		contentPane.add(panel);
		
		SU_user = new JTextField();
		SU_user.setColumns(10);
		SU_user.setBounds(162, 41, 151, 20);
		panel.add(SU_user);
		
		SU_pass = new JTextField();
		SU_pass.setColumns(10);
		SU_pass.setBounds(162, 84, 151, 20);
		panel.add(SU_pass);
		
		SU_age = new JTextField();
		SU_age.setColumns(10);
		SU_age.setBounds(162, 130, 151, 20);
		panel.add(SU_age);
		
		SU_salary = new JTextField();
		SU_salary.setColumns(10);
		SU_salary.setBounds(162, 175, 151, 20);
		panel.add(SU_salary);
		
		JLabel label = new JLabel("User Name");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setBounds(48, 43, 59, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Password");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBounds(48, 86, 51, 15);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Age");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_2.setBounds(48, 132, 46, 14);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Salary");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_3.setBounds(48, 177, 46, 14);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("SIGN UP");
		label_4.setForeground(new Color(178, 34, 34));
		label_4.setFont(new Font("Lucida Console", Font.PLAIN, 16));
		label_4.setBackground(Color.WHITE);
		label_4.setBounds(87, 32, 76, 14);
		contentPane.add(label_4);
		
		JButton button = new JButton("Create");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Statement st = conn.createStatement();
					PreparedStatement ps=conn.prepareStatement("INSERT INTO login VALUES (?,?,?,?)");
					ps.setString(1,SU_user.getText());
					ps.setString(2, SU_pass.getText());
					ps.setInt(3, Integer.parseInt(SU_age.getText()));
					ps.setInt(4, Integer.parseInt(SU_salary.getText()));
					int i=ps.executeUpdate();
					if(i>0) 
						{
						ouser=SU_user.getText();
						Observer.updateall();
						}
					else JOptionPane.showMessageDialog(new JFrame(), "Try Again!");
				} 
				catch(MySQLIntegrityConstraintViolationException e) {
					JOptionPane.showMessageDialog(new JFrame(), "UserName already exists!");
				}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					
					e.printStackTrace();
				}
					catch(NumberFormatException e) {
						JOptionPane.showMessageDialog(new JFrame(), "Error!");
					}
				
				
			}
		});
		button.setForeground(new Color(178, 34, 34));
		button.setFont(new Font("Lucida Console", Font.BOLD, 12));
		button.setBounds(213, 314, 89, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Reset");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SU_user.setText(null);
				SU_pass.setText(null);
				SU_age.setText(null);
				SU_salary.setText(null);
			}
		});
		button_1.setForeground(new Color(178, 34, 34));
		button_1.setFont(new Font("Lucida Console", Font.BOLD, 12));
		button_1.setBounds(328, 314, 89, 23);
		contentPane.add(button_1);
		
		JButton SU_back = new JButton("<");
		SU_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				expense_manager.main(null);
				dispose();
			}
		});
		SU_back.setVerticalAlignment(SwingConstants.TOP);
		SU_back.setHorizontalAlignment(SwingConstants.LEADING);
		SU_back.setForeground(new Color(139, 0, 0));
		SU_back.setFont(new Font("Tahoma", Font.BOLD, 14));
		SU_back.setBounds(10, 11, 45, 29);
		contentPane.add(SU_back);
	}

}
