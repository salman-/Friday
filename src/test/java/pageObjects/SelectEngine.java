package pageObjects;

import lombok.Data;
import services.Driver;

@Data
public class SelectEngine {
	
	Driver driver;
	final static String wizardTitle = "//div[contains(.,'Ist dein Auto dabei?')]";
	String autoEngine = "//button[contains(., 'engine')]";
	
	public SelectEngine(Driver driver) {
		this.driver = driver;
		this.driver.waitForElement(wizardTitle, 2);
	}

	public void selectEngine(String engineOfTheCar) {
		
		autoEngine = autoEngine.replaceAll("engine", engineOfTheCar);
		driver.click(autoEngine);
	}
}
