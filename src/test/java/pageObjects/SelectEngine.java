package pageObjects;

import services.Driver;
import services.Utils;

public class SelectEngine extends Utils {
	
	final static String wizardTitle = "//div[contains(.,'Ist dein Auto dabei?')]";
	static String autoEngine = "//button[contains(., 'engine')]";
	
	public SelectEngine(Driver driver) {
		super(driver,wizardTitle);
	}

	public void selectEngine(String engineOfTheCar) {
		
		autoEngine = autoEngine.replaceAll("engine", engineOfTheCar);
		driver.click(autoEngine);
	}
}
