package minipro;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class feedback extends JFrame {
static int c=0;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					feedback frame = new feedback();
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
	public feedback() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 388);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JTextArea textArea = new JTextArea();
		textArea.setBounds(61, 57, 424, 221);
		contentPane.add(textArea);
		
		JLabel lblEnterReviewHere = new JLabel("Enter review here");
		lblEnterReviewHere.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEnterReviewHere.setBounds(50, 10, 198, 37);
		contentPane.add(lblEnterReviewHere);
		
		JButton btnSubmit = new JButton("submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				 Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mini?useTimezone=true&serverTimezone=UTC","aishwarya","aishwarya");
					 String contents = textArea.getText();
					Statement stmt=con.createStatement(); 
					String mystmt= "insert into feedback"+"(review)"+"values('"+contents+"')";
					
					
					stmt.executeUpdate(mystmt);       }
					catch (Exception exp) {
						exp.printStackTrace(); }
				dispose();}
		});
		
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSubmit.setBounds(318, 303, 113, 26);
		contentPane.add(btnSubmit);
		
	}}
		
		
	

