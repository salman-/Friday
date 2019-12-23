package stepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import services.Driver;

public class Hooks{

	Driver driver;
	
	@Before
	public void testInitializer(){
		driver = new Driver();
		driver.maximizeWindow();
	
		System.out.println("========================== Before Scenario =======================");
	}



	@After
	public void tearDownTest(){
		driver.closeBrowser();
		System.out.println("========================== After Scenario =======================");
	}

	

}
