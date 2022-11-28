package electricity_bill;

import static org.junit.Assert.assertEquals;



import org.junit.Test;


public class MenuTest {
	@Test
	public void checkAdmin()
	{
		assertEquals(true, Menu.checkAdmin());
	}	

}
