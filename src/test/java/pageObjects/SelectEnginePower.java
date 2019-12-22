package pageObjects;

import services.Driver;
import services.Utils;

public class SelectEnginePower extends Utils {
	
	final static String wizardTitle = "//div[contains(.,'Wie viele PS hat dein Auto?')]";
	String autonEnginePower = "//button[contains(., 'enginer-power')]";
	
	public SelectEnginePower(Driver driver) {
		super(driver,wizardTitle);
	}
	
	public void selectHorsePower(String powerOfEngine) {
		
		autonEnginePower = autonEnginePower.replaceAll("enginer-power", powerOfEngine);
		driver.click(autonEnginePower);
	}
	

}
