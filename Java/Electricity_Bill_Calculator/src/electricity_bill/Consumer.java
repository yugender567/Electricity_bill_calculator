package electricity_bill;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class Consumer 
{
    private int consumerId;
    private String consumerName;
    private String city;
    private String area;
    private String type;
    
    public Consumer()
    {
    	
    }

    public Consumer(int consumerId, String consumerName, String city, String area, String type) {
		super();
		this.consumerId = consumerId;
		this.consumerName = consumerName;
		this.city = city;
		this.area = area;
		this.type = type;
	}

	public int getConsumerId() 
    {
        return this.consumerId;
    }

    public String getConsumerName() 
    {
        return consumerName;
    }

    public String getCity() 
    {
        return city;
    }
    public String getArea() {
        return area;
    }

    public String getType() 
    {
        return type;
    }

    public void setType(String type) 
    {
        this.type = type;
    }

    void register() throws IOException 
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
//        System.out.print("Enter consumer Id:");
//        this.consumerId=Integer.parseInt(br.readLine());
        System.out.print("Enter consumer name:");
        this.consumerName=br.readLine();
        System.out.print("Enter consumer city:");
        this.city=br.readLine();
        System.out.print("Enter consumer area:");
        this.area=br.readLine();
        System.out.print("Enter consumer type (Commercial or Domestic):");
        this.type=br.readLine();
    }
    
    void insertConsumerData() throws ClassNotFoundException, SQLException, IOException
    {
    	Connection con = DatabaseConnectivity.getConnection();
    	CallableStatement callable = con.prepareCall("{ call insert_consumer(?, ?, ?, ?) }");
    	this.register();
    	callable.setString(1, this.getConsumerName());
    	callable.setString(2, this.getCity());
    	callable.setString(3, this.getArea());
    	callable.setString(4, this.getType());
    	callable.executeUpdate();
    	con.close();
    }
    
    //TODO: Get plan_type from consumer id
    public static double getRate(int consumerId) throws ClassNotFoundException, SQLException
    {
    	Connection con = DatabaseConnectivity.getConnection();
    	PreparedStatement pst = con.prepareStatement("select type_name from consumer where id=?");
    	pst.setInt(1, consumerId);
    	ResultSet rs = pst.executeQuery();
    	rs.next();
    	String type = rs.getString(1);
    	CallableStatement callable = con.prepareCall("{ ? = call get_rate(?) }");
    	callable.registerOutParameter(1, Types.DOUBLE);
    	callable.setString(2, type);
    	callable.execute();
    	
    	
    	return callable.getDouble(1);
    }

}
    
 

