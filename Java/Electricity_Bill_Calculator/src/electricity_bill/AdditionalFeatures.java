package electricity_bill;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AdditionalFeatures{
	
	public static void changeName() throws ClassNotFoundException, SQLException{
		Connection con=DatabaseConnectivity.getConnection();
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter New Name:");
		String name = in.nextLine();

		System.out.print("Enter Consumer ID:");
		int id = in.nextInt();
		
		String sqlUpdate2="UPDATE consumer SET Name=? WHERE id=?";
		PreparedStatement pst2 = con.prepareStatement(sqlUpdate2);


		
		pst2.setString(1,name);
		pst2.setInt(2,id);
		pst2.executeUpdate();
		pst2.clearParameters();
		con.close();
	}
	
	public static void changeAddress() throws ClassNotFoundException, SQLException{
		Connection con=DatabaseConnectivity.getConnection();
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter City:");
		String city = in.nextLine();
		System.out.print("Enter Area:");
		String area = in.nextLine();
		System.out.print("Enter Consumer ID:");
		int id = in.nextInt();
		
		String sqlUpdate="UPDATE consumer SET CITY=?, AREA=? WHERE id=?";
		PreparedStatement pst = con.prepareStatement(sqlUpdate);

		pst.setString(1,city);
		pst.setString(2,area);
		pst.setInt(3,id);
		pst.executeUpdate();
		pst.clearParameters();

		con.close();
	}
	
	public static void getBillforUser() throws ClassNotFoundException, SQLException
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter Consumer ID:");
		int id = in.nextInt();
		Connection con=DatabaseConnectivity.getConnection();
		String query = "SELECT * FROM consumer inner join bill WHERE id=?";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1,id);
	      
	    ResultSet rs = pst.executeQuery();
	      
	      
	      while (rs.next())
	      {
	        int consumer_id = rs.getInt("id");
	        String NAME = rs.getString("NAME");
	        String CITY = rs.getString("CITY");
	        String AREA = rs.getString("AREA");
	        String TYPE_NAME = rs.getString("TYPE_NAME");
	        int  BILL_ID = rs.getInt("BILL_ID");
	        int  YEAR = rs.getInt("YEAR");
	        int  MONTH = rs.getInt("MONTH");
	        double   UNITS_CONSUMED = rs.getInt("UNITS_CONSUMED");
	        int  CONSUMER_ID= rs.getInt("CONSUMER_ID");
	        
	        System.out.format("%s, %s, %s, %s, %s, %s\n", consumer_id, NAME, CITY, AREA, TYPE_NAME,BILL_ID,YEAR,MONTH,UNITS_CONSUMED,CONSUMER_ID);
	      }
	}
	
	public static void getRates() throws ClassNotFoundException, SQLException{
		Connection con=DatabaseConnectivity.getConnection();
		String query = "SELECT * FROM RATES";
		Statement st = con.prepareStatement(query);
	      
	    ResultSet rs = st.executeQuery(query);
	      
	      
	      while (rs.next())
	      {
	    	String TYPE_NAME = rs.getString("TYPE_NAME");
	        int price = rs.getInt("price");
	        
	        System.out.format("%s, %s\n", TYPE_NAME,price);
	      }
	}
	
	public static void getBillForYear() throws ClassNotFoundException, SQLException{
		Connection con=DatabaseConnectivity.getConnection();
		
		Scanner in = new Scanner(System.in);

		System.out.print("Enter Consumer ID:");
		int id = in.nextInt();
		
		System.out.print("Enter year:");
		int year = in.nextInt();
		
		String query = "SELECT * FROM all_consumer_bill WHERE id=? AND YEAR=?";
		PreparedStatement pst = con.prepareStatement(query);

		pst.setInt(1,id);
		pst.setInt(2,year);
	    ResultSet rs = pst.executeQuery();
	      
	      
	      while (rs.next())
	      {
	        int consumer_id = rs.getInt("id");
	        String NAME = rs.getString("NAME");
	        String CITY = rs.getString("CITY");
	        String AREA = rs.getString("AREA");
	        String TYPE_NAME = rs.getString("TYPE_NAME");
	        int  BILL_ID = rs.getInt("BILL_ID");
	        int  YEAR = rs.getInt("YEAR");
	        int  MONTH = rs.getInt("MONTH");
	        double   UNITS_CONSUMED = rs.getInt("UNITS_CONSUMED");
	        int  CONSUMER_ID= rs.getInt("CONSUMER_ID");
	        
	        System.out.format("%s, %s, %s, %s, %s, %s\n", consumer_id, NAME, CITY, AREA, TYPE_NAME,BILL_ID,YEAR,MONTH,UNITS_CONSUMED,CONSUMER_ID);
	      }
	}
	
	
	
}
