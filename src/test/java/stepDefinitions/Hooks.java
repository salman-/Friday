package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import services.Driver;

public class Hooks extends Driver{

	Driver driver;
	
	public Hooks(Driver driver) {
		this.driver = driver;
	}
	
	public Hooks() {}
	
	@Before
	public void testInitializer(){
		
			
		/*WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver(); */
		
		WebDriverManager.chromedriver().setup();
		WebDriver dr = driver.getDriver() ;
		dr = new ChromeDriver();
		
		driver.setDriver(dr);
		
		driver.maximizeWindow();
	
	}



	@After
	public void tearDownTest(Scenario scenario){
		
		if(scenario.isFailed())
			driver.takeScreenshot();
		driver.closeBrowser();

	}

}
