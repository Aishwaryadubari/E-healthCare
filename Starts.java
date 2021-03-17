package minipro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Starts
{
public static void main(String[] args) {
	// TODO Auto-generated method stub
	System.out.println("\t\tWElCOME TO THE ONLINE HOSPITAL\t\t");
	try { Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mini?useTimezone=true&serverTimezone=UTC","aishwarya","aishwarya");
	Statement stmt=con.createStatement();
	Scanner sc = new Scanner(System.in);
	int ac,b;
	
	Welcome obj1 = new Welcome(); obj1.setVisible(true);
	
	ResultSet res=stmt.executeQuery("Select * from table1 ");
	 while(res.next()) 
     {  do { 
    	 System.out.println("\nWho are you?");
     	System.out.println("1:ADMIN\n2:USER\n");
     	b=sc.nextInt();
     	if(b==1)
            { 
     		AdminLog obj=new AdminLog(); obj.setVisible(true);
	do {
			System.out.println("WHAT YOU WANT TO DO  ?  1:insert\t2:delete\t3:modify");
			int c=sc.nextInt();
			if(c==1)
			{Insert ab=new Insert();
			     ab.display();
			}
			else if(c==2) {
			Delete sb = new Delete();
			sb.display();
	          }
			else if(c==3) {
			Modify sb = new Modify();
			sb.display();
			
			}
			else
				{System.out.println("\nWrong input ");}
			System.out.println("\nPress 1 to continue as admin \t exit 0 ");
			ac=sc.nextInt();
			
			} while(ac==1);
 
		 } 
   else if(b==2)
{ User abc=new User();
abc.show();}
	System.out.println("\nPress 1 to continue \t exit 0 ");
	ac=sc.nextInt();
}while(ac==1);

sc.close();
System.out.println(" \nTHANK   YOU  ");}}
		
	
catch (Exception exc) { exc.printStackTrace(); } 



}
}
