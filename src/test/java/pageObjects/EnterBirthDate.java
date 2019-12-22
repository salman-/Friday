package pageObjects;

import services.Driver;
import services.Utils;

public class EnterBirthDate extends Utils{
	
	final static String wizardTitle = "//div[contains(.,'Wann wurdest du geboren?')]";
	
	public EnterBirthDate(Driver driver) {
		super(driver,wizardTitle);
	}

}
