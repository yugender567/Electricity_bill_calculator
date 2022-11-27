package electricity_bill;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Menu 
{

	public static void menu() throws SQLException, ClassNotFoundException, IOException
	{
		Scanner scan=new Scanner(System.in);
		int choice = 0;
		do 
		{
			System.out.println("Welcome to Electricty Bill Calculator!!");
			System.out.println("1. Consumer Registration");
			System.out.println("2. Insert bill for a specific consumer");
			System.out.println("3. All Consumer Report");
			System.out.println("4. Consumer Report for a specific city and area");
			System.out.println("5. Consumer Report for a specific year and month");
			System.out.println("6. Exit");
			System.out.print("Enter Choice: ");
			choice = scan.nextInt();
			switch (choice)
			{
			case 1: 
			{
		    	Consumer consumer = new Consumer();
		    	consumer.insertConsumerData();
			}
				break;
			case 2: 
			{
				Bill bill = new Bill();
				bill.insertBillData();
			}
				break;
			case 3: 
				//CALL THE FUNCTION- All Consumer report
				break;
			case 4: 
				Reports.consumerBillByCity();
				break;
			case 5: 
				Reports.consumerBillByYear();
				break;
			case 6:
				System.out.println("Exiting the Application");
				break;	    
			default: 
				System.out.println("Invalid Choice. Please choose from one of the given options");
			}
		}while(choice!=6);

	}

}

