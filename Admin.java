package minipro;

import java.sql.*;

public class Admin {
	
	void display(){

	
	try { Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mini?useTimezone=true&serverTimezone=UTC","aishwarya","aishwarya");
	
	Statement stmt=con.createStatement();
	System.out.println("ID       NAME       SPECIALIST       MOBILE NO        HOSPITAL NAME        ADDRESS of HOSPITAL      AVAILABILITY TIME");
	 ResultSet res=stmt.executeQuery("Select * from table2 order by id");
	while(res.next()) 
	{System.out.println(res.getInt("id")+"  "+res.getString("name")+"        "+res.getString("specialist")+"         "+ res.getString("mobile_no")+"         "+res.getString("hospital")+"         "+res.getString("address")+"         "+res.getInt("start")+" to "+res.getInt("end"));
	
		}}
	 
	 
	 
catch (Exception exc) { exc.printStackTrace(); } 
            
 }}
	
