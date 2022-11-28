package electricity_bill;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Scanner;

public class Menu 
{
	public static boolean check(HashMap<String, String> adminMap, String username, String password)
	{
		if(adminMap.get(username).equals(password)) 
			return true;

		return false;
	}
	
	public static boolean checkAdmin(HashMap<String, String> adminMap) 
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("Please Enter Your Admin UserName");
		String username=scan.next();
		if(adminMap.containsKey(username)) 
		{
			System.out.println("Please Enter Your Password");
			String password=scan.next();
			if(adminMap.get(username).equals(password)) 
				return true;
			else 
				System.out.println("Wrong Password");
		}
		else
			System.out.println("You are not authorized to access this feature");
		return false;
	}

	public static void menu() throws SQLException, ClassNotFoundException, IOException
	{
		Scanner scan=new Scanner(System.in);
		HashMap<String, String> adminMap = new HashMap<String, String>();
		adminMap.put("Team3", "1234");

		int choice = 0;
		do 
		{
			System.out.println("Welcome to Electricty Bill Calculator!!");
			System.out.println("1. Consumer Registration");
			System.out.println("2. Insert bill for a specific consumer");
			System.out.println("3. All Consumer Report");
			System.out.println("4. Consumer Report for a specific city and area");
			System.out.println("5. Consumer Report for a specific year and month");
			System.out.println("6. Change Consumer Name");
			System.out.println("7. Change Consumer Address");
			System.out.println("8. Fetch Consumer Bill");
			System.out.println("9. Fetch Consumer Bill By year");
			System.out.println("10. Get Rates");
			System.out.println("0. Exit");

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
			{
				if(checkAdmin(adminMap))
					Reports.AllConsumersBill();
			}
				
				break;
			case 4: 
			{
				if(checkAdmin(adminMap)) 
						Reports.consumerBillByCity();
				break;
			}
			case 5: 
			{
				if(checkAdmin(adminMap)) {
						Reports.consumerBillByYear();
					}
				}
				
			case 6:
				AdditionalFeatures.changeName();
				break;
			case 7:
				AdditionalFeatures.changeAddress();
				break;
			case 8:
				AdditionalFeatures.getBillforUser();
				break;
			case 9:
				AdditionalFeatures.getBillForYear();
				break;
			case 10:
				AdditionalFeatures.getRates();
				break;
				
			case 0:
				System.out.println("Exiting the Application");
				break;	    
			default: 
				System.out.println("Invalid Choice. Please choose from one of the given options");
			}
		}while(choice!=0);

	}

}



