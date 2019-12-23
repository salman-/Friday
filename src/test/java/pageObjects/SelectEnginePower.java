package pageObjects;

import lombok.Data;
import services.Driver;

@Data
public class SelectEnginePower {
	
	Driver driver;
	final static String wizardTitle = "//div[contains(.,'Wie viele PS hat dein Auto?')]";
	String autonEnginePower = "//button[contains(., 'enginer-power')]";
	
	public SelectEnginePower(Driver driver) {
		this.driver = driver;
		driver.waitForElement(wizardTitle, 2);
	}
	
	public void selectHorsePower(String powerOfEngine) {
		
		autonEnginePower = autonEnginePower.replaceAll("enginer-power", powerOfEngine);
		driver.click(autonEnginePower);
	}
	

}
