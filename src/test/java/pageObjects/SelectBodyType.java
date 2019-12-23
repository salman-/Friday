package pageObjects;

import lombok.Data;
import services.Driver;

@Data
public class SelectBodyType{
	
	Driver driver;
	final static String wizardTitle = "//div[contains(.,'Welche Form hat das Auto?')]";
	String autoBodyType = "//button[contains(., 'type')]";
	
	public SelectBodyType(Driver driver) {
		this.driver = driver;
		driver.waitForElement(wizardTitle, 2);
	}
	
	public void selectBodyTypeOfTheCar(String bodyType) {
		
		autoBodyType = autoBodyType.replaceAll("type", bodyType);
		driver.click(autoBodyType);
	}
	
	

}
