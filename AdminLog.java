package minipro;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class AdminLog extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String args[]){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLog frame = new AdminLog();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminLog() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 656, 438);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setForeground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdmin = new JLabel("ADMIN");
		lblAdmin.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAdmin.setBounds(258, 32, 146, 51);
		contentPane.add(lblAdmin);
		
		JLabel lblUsername = new JLabel("username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsername.setBounds(57, 144, 119, 29);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(57, 245, 107, 29);
		contentPane.add(lblPassword);
		
		username = new JTextField();
		username.setBounds(232, 144, 190, 32);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(232, 245, 190, 29);
		contentPane.add(password);
		
		JButton btnLogin = new JButton("login");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLogin.addActionListener(new ActionListener() {
			private Component frame;

			public void actionPerformed(ActionEvent e) {
				try { Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mini?useTimezone=true&serverTimezone=UTC","aishwarya","aishwarya");
				Statement stmt=con.createStatement();
				ResultSet res=stmt.executeQuery("Select * from table1 ");
				while(res.next()) {
				
                  String uname=username.getText();
                  String s1=res.getString("username");
				
				String psd=password.getText();
				String s2=res.getString("password");
				
				
				if(uname.equals(s1)&& psd.equals(s2))
					
				{ JOptionPane.showMessageDialog(frame,"Succesfuuly logged in");dispose();
				
				    
				}
				else
					
					{ JOptionPane.showMessageDialog(frame,"Incorrect username or password ");}
			
				}}
				catch (Exception exc) { exc.printStackTrace(); } 
			}
		});
		btnLogin.setBounds(182, 323, 128, 44);
		contentPane.add(btnLogin);
	}

}
