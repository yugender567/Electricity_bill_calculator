package electricity_bill;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class Bill 
{
	private int billId;
	private int year;
	private int month;
	private double unitsConsumed;
	private double totalBill;
	private int consumerId;
	
	public Bill() {}
	public Bill(int billId, int year, int month, double unitsConsumed, double totalBill, int consumerId) {
		super();
		this.billId = billId;
		this.year = year;
		this.month = month;
		this.unitsConsumed = unitsConsumed;
		this.totalBill = totalBill;
		this.consumerId = consumerId;
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public double getUnitsConsumed() {
		return unitsConsumed;
	}

	public void setUnitsConsumed(double unitsConsumed) {
		this.unitsConsumed = unitsConsumed;
	}

	public double getTotalBill() {
		return totalBill;
	}

	public void setTotalBill(double rate) 
	{
		this.totalBill = this.unitsConsumed*rate;
	}

	public int getConsumerId() {
		return consumerId;
	}

	public void setConsumerId(int consumerId) {
		this.consumerId = consumerId;
	}

	
    void register() throws IOException, ClassNotFoundException, SQLException 
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
//        System.out.print("Enter consumer Id:");
//        this.consumerId=Integer.parseInt(br.readLine());
        System.out.print("Enter Year:");
        this.year = Integer.parseInt(br.readLine());
        System.out.print("Enter Month:");
        this.month = Integer.parseInt(br.readLine());
        System.out.print("Enter Units Consumed:");
        this.unitsConsumed = Double.parseDouble(br.readLine());
        System.out.print("Enter Consumer ID:");
        this.consumerId = Integer.parseInt(br.readLine());
        
        this.setTotalBill(Consumer.getRate(consumerId));
    }
    
    void display()
    {
    	System.out.println("--------------------------------------");
    	System.out.println("Bill ID:" + this.getBillId());
    	System.out.println("Consumer ID:" + this.getConsumerId());
    	System.out.println("Year:" + this.getYear());
    	System.out.println("Month:" + this.getMonth());
    	System.out.println("Units Consumed:" + this.getUnitsConsumed());
    	System.out.println("Bill Total:" + this.getTotalBill());
    	System.out.println("--------------------------------------");
    }
    
    void insertBillData() throws ClassNotFoundException, SQLException, IOException
    {
    	Connection con = DatabaseConnectivity.getConnection();
    	CallableStatement callable = con.prepareCall("{ call insert_bill(?, ?, ?, ?, ?) }");
    	this.register();
    	callable.setInt(1, this.getYear());
    	callable.setInt(2, this.getMonth());
    	callable.setDouble(3, this.getUnitsConsumed());
    	callable.setDouble(4, this.getTotalBill());
    	callable.setInt(5, this.getConsumerId());
    	callable.executeUpdate();
    	con.close();
    }		
}


