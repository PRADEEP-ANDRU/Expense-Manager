package expense_manager;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.DefaultComboBoxModel;
public class Updat extends JFrame {

	private JPanel contentPane;
	private JTextField input;
	private JButton done;
	static Connection conn;
	private JButton button;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Updat frame = new Updat();
					frame.setVisible(true);
					frame.setTitle("Update");
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
	public Updat() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		input = new JTextField();
		input.setText("");
		input.setBounds(67, 114, 142, 20);
		contentPane.add(input);
		input.setColumns(10);
		
		
		String [] categ= {"Vehicle","Food","Enteratainment","Grocery","Misc"};
		JComboBox comboBox = new JComboBox(categ);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"vehicle", "food", "enteratainment", "grocery", "misc"}));
		comboBox.setBackground(new Color(255, 245, 238));
		comboBox.setFont(new Font("Lucida Console", Font.BOLD, 11));
		comboBox.setForeground(new Color(25, 25, 112));
		comboBox.setBounds(248, 114, 103, 20);
		contentPane.add(comboBox);
		
		done = new JButton("Done");
		done.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Statement st;
				try {
					st = conn.createStatement();
					String sql;
					String cat;
						cat=(String) comboBox.getItemAt(comboBox.getSelectedIndex());
						int v=Integer.parseInt(input.getText());
						sql= "update manag set "+cat+"="+v+" where user_name=\""+(expense_manager.user)+"\"";
						int i=st.executeUpdate(sql);
						if(i>0) JOptionPane.showMessageDialog(new JFrame(), "Updated!");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					catch(NumberFormatException e1) {
						JOptionPane.showMessageDialog(new JFrame(), "*Required");
					}
				
			}
		});
		done.setForeground(new Color(128, 0, 0));
		done.setFont(new Font("Lucida Console", Font.BOLD, 11));
		done.setBounds(248, 176, 89, 23);
		contentPane.add(done);
		
		button = new JButton("<");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Manager.main(null);
				dispose();
			}
		});
		button.setForeground(new Color(128, 0, 0));
		button.setFont(new Font("Lucida Console", Font.BOLD, 14));
		button.setBounds(10, 11, 43, 33);
		contentPane.add(button);
	}
}
