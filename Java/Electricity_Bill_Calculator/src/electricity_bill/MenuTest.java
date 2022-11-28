package electricity_bill;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;


public class MenuTest {
	@Test
	public void checkAdmin(HashMap<String, String> adminMap)
	{
		assertEquals(true, Menu.check(adminMap, "admin", "1234"));
	}
	

}
