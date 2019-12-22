package pageObjects;

import services.Driver;
import services.Utils;

public class SelectBodyType extends Utils{
	
	final static String wizardTitle = "//div[contains(.,'Welche Form hat das Auto?')]";
	static String autoBodyType = "//button[contains(., 'type')]";
	
	public SelectBodyType(Driver driver) {
		super(driver,wizardTitle);
	}
	
	public void selectBodyTypeOfTheCar(String bodyType) {
		
		autoBodyType = autoBodyType.replaceAll("type", bodyType);
		driver.click(autoBodyType);
	}
	
	

}
