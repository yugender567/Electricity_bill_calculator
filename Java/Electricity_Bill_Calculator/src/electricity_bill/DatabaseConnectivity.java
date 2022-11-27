package electricity_bill;

import java.sql.*;

public class DatabaseConnectivity
{
	public static Connection getConnection() throws SQLException, ClassNotFoundException 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/project";
		return DriverManager.getConnection(url, "root", "Hackerrank@18");
	}
}
