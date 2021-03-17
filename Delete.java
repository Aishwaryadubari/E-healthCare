package minipro;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Delete extends Admin{
	Scanner sc=new Scanner(System.in);

	void display(){
		 
		super.display();
        delete();
	}
		void delete()
		{
			try { Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mini?useTimezone=true&serverTimezone=UTC","aishwarya","aishwarya");
			
			Statement stmt=con.createStatement();
			System.out.println("\nEnter id of doctor to be removed");
			int a=sc.nextInt();
			String mystmt="delete from table2 where id=" + a;
			stmt.executeUpdate(mystmt);
			System.out.println("\nData deleted");
			super.display();
			}
			catch (Exception exp) {
				exp.printStackTrace();}
			
			
		}

}
