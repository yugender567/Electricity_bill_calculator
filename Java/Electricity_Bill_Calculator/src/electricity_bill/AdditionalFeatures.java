package electricity_bill;
import java.sql.Statement;

import features.MyConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AdditionalFeatures{
	
	public void changeName(String name, int x) throws ClassNotFoundException, SQLException{
		Connection con=MyConnection.getConnection();
		String sqlUpdate1="UPDATE all_consumer_bill SET Name=? WHERE id=?";
		String sqlUpdate2="UPDATE consumer SET Name=? WHERE id=?";
		PreparedStatement pst1 = con.prepareStatement(sqlUpdate1);
		PreparedStatement pst2 = con.prepareStatement(sqlUpdate2);
		String id=""+x;
		pst1.setString(1,name);
		pst1.setString(2,id);
		pst1.executeUpdate();
		pst1.clearParameters();
		
		pst2.setString(1,name);
		pst2.setString(2,id);
		pst2.executeUpdate();
		pst2.clearParameters();
		con.close();
	}
	public void changeAddress(String city,String area, int x) throws ClassNotFoundException, SQLException{
		Connection con=MyConnection.getConnection();
		String sqlUpdate="UPDATE consumer SET CITY=?, AREA=? WHERE id=?";
		String sqlUpdate2="UPDATE all_consumer_bill SET Name=? WHERE id=?";
		PreparedStatement pst = con.prepareStatement(sqlUpdate);
		PreparedStatement pst2 = con.prepareStatement(sqlUpdate2);
		String id=""+x;
		pst.setString(1,city);
		pst.setString(2,area);
		pst.setString(3,id);
		pst.executeUpdate();
		pst.clearParameters();
		
		pst2.setString(1,city);
		pst2.setString(2,area);
		pst2.setString(3,id);
		pst2.executeUpdate();
		pst2.clearParameters();
		con.close();
	}
	public void getBillforUser(int id) throws ClassNotFoundException, SQLException{
		Connection con=MyConnection.getConnection();
		String query = "SELECT * FROM all_consumer_bill WHERE id=?";
		PreparedStatement pst = con.prepareStatement(query);
		String x=""+id;
		pst.setString(1,x);
	      
	      ResultSet rs = pst.executeQuery(query);
	      
	      
	      while (rs.next())
	      {
	        int id = rs.getInt("id");
	        String NAME = rs.getString("NAME");
	        String CITY = rs.getString("CITY");
	        String AREA = rs.getString("AREA");
	        String TYPE_NAME = rs.getString("TYPE_NAME");
	        int  BILL_ID = rs.getint("BILL_ID");
	        int  YEAR = rs.getint("YEAR");
	        int  MONTH = rs.getint("MONTH");
	        double   UNITS_CONSUMED = rs.getint("UNITS_CONSUMED");
	        int  CONSUMER_ID= rs.getint("CONSUMER_ID");
	        
	        System.out.format("%s, %s, %s, %s, %s, %s\n", id, NAME, CITY, AREA, TYPE_NAME,BILL_ID,YEAR,MONTH,UNITS_CONSUMED,CONSUMER_ID);
	      }
	}
	public void getRates() throws ClassNotFoundException, SQLException{
		Connection con=MyConnection.getConnection();
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
	public void getBillForYear(int id, int year) throws ClassNotFoundException, SQLException{
		Connection con=MyConnection.getConnection();
		String query = "SELECT * FROM all_consumer_bill WHERE id=? AND YEAR=?";
		PreparedStatement pst = con.prepareStatement(query);
		String x=""+id;
		String y=""+year;
		pst.setString(1,x);
		pst.setString(2,y);
	    ResultSet rs = pst.executeQuery(query);
	      
	      
	      while (rs.next())
	      {
	        int id = rs.getInt("id");
	        String NAME = rs.getString("NAME");
	        String CITY = rs.getString("CITY");
	        String AREA = rs.getString("AREA");
	        String TYPE_NAME = rs.getString("TYPE_NAME");
	        int  BILL_ID = rs.getint("BILL_ID");
	        int  YEAR = rs.getint("YEAR");
	        int  MONTH = rs.getint("MONTH");
	        double   UNITS_CONSUMED = rs.getint("UNITS_CONSUMED");
	        int  CONSUMER_ID= rs.getint("CONSUMER_ID");
	        
	        System.out.format("%s, %s, %s, %s, %s, %s\n", id, NAME, CITY, AREA, TYPE_NAME,BILL_ID,YEAR,MONTH,UNITS_CONSUMED,CONSUMER_ID);
	      }
	}
	
}
