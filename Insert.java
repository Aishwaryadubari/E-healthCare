package minipro;
import java.util.*;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;

public class Insert extends Admin {
	Scanner sc = new Scanner(System.in);
	void display(){
	     super.display();
	insert();
	}
void insert()
	{  try { Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mini?useTimezone=true&serverTimezone=UTC","aishwarya","aishwarya");
	
	Statement stmt=con.createStatement();
	System.out.println("enter details of doctor to be added and enter id ");
	int a=sc.nextInt();
	
	System.out.println("enter name of doctor ");
	String n=sc.next();
	
	System.out.println("enter which specialist ");
	String sp=sc.next();
	System.out.println("enter mobile number ");
	String m=sc.next();
	
	System.out.println("enter hospital name ");
	String h=sc.next();
	System.out.println("enter address of hospital ");
	String ad=sc.next();
	System.out.println("enter availability time ");
	int st= sc.nextInt();
	int en= sc.nextInt();
	
	
	String mystmt= "insert into table2"+"(id,name,specialist,mobile_no,hospital,address,start,end,patient)"+" values('"+a+"','"+n+"','"+sp+"','"+m+"','"+h+"','"+ad+"','"+st+"','"+en+"','"+0+"')";
	
	
	stmt.executeUpdate(mystmt);
	
	System.out.println(" data inserted");
	super.display();
	}
	
	catch (Exception exp) {
		exp.printStackTrace();
	
	}
	

	}}
	











	
	
