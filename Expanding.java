package minipro;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Expanding implements Appointment,Medicine 
{Scanner sc=new Scanner(System.in);
int count;

	
	public void appointment() {
	 
		try { 
			Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mini?useTimezone=true&serverTimezone=UTC","aishwarya","aishwarya");
		Statement stmt=con.createStatement();
	System.out.println("the appointment fee for is 200 per doctor ");
	
	 ResultSet re=stmt.executeQuery("Select * from table2 order by id ");
	while(re.next()) {
	 System.out.println(re.getInt("id")+" "+re.getString("specialist"));}
	 System.out.println(" \n These are avaialable specialist whom you want enter name ");
	 String s=sc.next();
	 ResultSet res=stmt.executeQuery("Select * from table2 "+"where specialist like'"+s+"'");
		 System.out.println("ID       NAME       SPECIALIST       MOBILE NO        HOSPITAL NAME        ADDRESS of HOSPITAL      AVAILABILITY TIME");
	 while(res.next()) 
	{System.out.println(res.getInt("id")+"  "+res.getString("name")+"        "+res.getString("specialist")+"         "+ res.getString("mobile_no")+"         "+res.getString("hospital")+"         "+res.getString("address")+"         "+res.getInt("start")+" to "+res.getInt("end"));
	              }
	System.out.println(" \nEnter id of specialist whom you need based on availability time ");
	
	 int sb=sc.nextInt();
	 System.out.println("enter your name");
	 String a=sc.next();
	 
	 System.out.println("enter your mobile no ");
	 String b=sc.next();
	 System.out.println("enter your problem ");
	 String d=sc.next();
	 System.out.println("enter address");
	 String ad=sc.next();
	 String mystmt= "insert into user"+"(name,mobile_no,disease,address)"+" values('"+a+"','"+b+"','"+d+"','"+ad+"')";
		stmt.executeUpdate(mystmt);
		 ResultSet rest=stmt.executeQuery("Select * from user "+"where name like'"+a+"'");
		 while(rest.next()) 
		{count=rest.getInt("id");}
		String stmt1 = "UPDATE table2 set patient = '" + count +
	            "' WHERE id = '" + sb+ "'";
		stmt.executeUpdate(stmt1);
		System.out.println("Amount to be paid=200 confirm payment then press 1");int i =sc.nextInt();
	if(i==1)	{System.out.println("bill paid successfully");}
		
	}
		catch (Exception exc) { exc.printStackTrace(); } 
	}

	public void medicine() {
	int b=0;;	// TODO Auto-generated method stub
		try
		{Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mini?useTimezone=true&serverTimezone=UTC","aishwarya","aishwarya");
		Statement stmt=con.createStatement();
		 ResultSet re=stmt.executeQuery("Select * from medicine ");
		 
			while(re.next()) {
				System.out.println(re.getInt("id")+"  "+re.getString("name")+"              "+re.getInt("cost")+"             "+re.getString("used_for"));  
			}
		System.out.println("\n Which medicine you need enter no ");int i=sc.nextInt();
		ResultSet res=stmt.executeQuery("Select * from medicine where id =" +i);
		 
		while(res.next()) {
			System.out.println(res.getInt("id")+"  "+res.getString("name")+"              "+res.getInt("cost")+"             "+res.getString("used_for"));  
		b =res.getInt("cost");
		} 
		System.out.println("\nHow much you need ");int j=sc.nextInt();
		User sb=new User(); 
		sb.bill(b,j);
		
	}
		catch (Exception exc) { exc.printStackTrace(); } 
	}



}
