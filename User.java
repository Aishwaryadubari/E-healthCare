package minipro;
import java.util.*;

 class User extends Expanding{
	Scanner sc=new Scanner(System.in);int i;
	void show() {
		do{System.out.println("\nWhat you want ? 1:Need appointment\t2:Need medicine ");
		int s=sc.nextInt();
		if(s==1)
		{ super.appointment();}
		else if(s==2)
		{  super.medicine();
		}
		 else
			{System.out.println("\nWrong input"); }
		
		System.out.println("\nTo continue 1 \t exit 0 ");
		i=sc.nextInt();
	if(i==0)
	{ feedback obj=new feedback(); obj.setVisible(true);
		} } while(i==1);
		
	
	
	}
	
	int bill(int c,int d)
{
	int sum=0;
	sum=c*d;
	System.out.println("\nYour total amount ="+sum+"\t to pay enter 1");
	int z=sc.nextInt();
	if(z==1)
	{System.out.println("\nBill paid successfully ");}
	
	return 0;
}
	
}
