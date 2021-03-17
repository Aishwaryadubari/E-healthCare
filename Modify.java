package minipro;
import java.util.*;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.Statement;

public class Modify extends Admin{
	
Scanner sc = new Scanner(System.in);
	void display(){
		 
	super.display();
	modify();
	
}void modify()
	{ try { Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mini?useTimezone=true&serverTimezone=UTC","aishwarya","aishwarya");
	
	Statement stmt=con.createStatement();
	System.out.println("enter the id of doctor need to be updated");
	int a=sc.nextInt();
	
	System.out.println("enter new specialist  ");
	String sp=sc.next();
	System.out.println("enter new mobile number ");
	String m=sc.next();
	
	System.out.println("enter new hospital name ");
	String h=sc.next();
	System.out.println("enter new address of hospital ");
	String ad=sc.next();
	
	
	String mystmt = "UPDATE table2 set specialist = '" + sp +
            "' WHERE id = '" + a+ "'";
	String stmt1 = "UPDATE table2 set mobile_no = '" + m +
            "' WHERE id = '" + a+ "'";
	String stmt2 = "UPDATE table2 set hospital = '" + h +
            "' WHERE id = '" + a+ "'";
	String stmt3 = "UPDATE table2 set address = '" + ad +
            "' WHERE id = '" + a+ "'";
    
	stmt.executeUpdate(mystmt);
	stmt.executeUpdate(stmt1);
	stmt.executeUpdate(stmt2);
	stmt.executeUpdate(stmt3);
	
	System.out.println("\nData updated");
	super.display();

	}
	catch (Exception exp) {
		exp.printStackTrace();
	
	}
}
}	
