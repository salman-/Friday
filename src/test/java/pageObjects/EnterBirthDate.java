package pageObjects;

import lombok.Data;
import services.Driver;

@Data
public class EnterBirthDate{
	
	Driver driver;
	final static String wizardTitle = "//div[contains(.,'Wann wurdest du geboren?')]";
	
	public EnterBirthDate(Driver driver) {
		driver.waitForElement(wizardTitle, 2);
	}

}
