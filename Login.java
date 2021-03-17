package minipro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;
	private JTextField username;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	void login() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		

	/**
	 * Initialize the contents of the frame.
	 */
	
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setBounds(100, 100, 668, 417);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAdmin = new JLabel("ADMIN");
		lblAdmin.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAdmin.setBounds(256, 51, 119, 33);
		frame.getContentPane().add(lblAdmin);
		
		JLabel lblUsername = new JLabel("username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsername.setBounds(85, 140, 85, 26);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(85, 195, 85, 26);
		frame.getContentPane().add(lblPassword);
		
		username = new JTextField();
		username.setBounds(228, 137, 147, 29);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(228, 195, 147, 26);
		frame.getContentPane().add(password);
		
		JButton btnLogin = new JButton("login");
		btnLogin.addActionListener(new ActionListener() {
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
					
				{ JOptionPane.showMessageDialog(frame,"Succesfuuly logged in");
				frame.dispose();
				  
				}
				else
					
					{ JOptionPane.showMessageDialog(frame,"incorrect username or password ");}
			
				}}
				catch (Exception exc) { exc.printStackTrace(); } 

			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLogin.setBounds(292, 293, 119, 39);
		frame.getContentPane().add(btnLogin);
	}
}
