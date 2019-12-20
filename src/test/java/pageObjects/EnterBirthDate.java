package pageObjects;

import services.Driver;
import services.Utils;

public class EnterBirthDate extends Utils{
	
	final static String birthDate = "//*[@id=\"root\"]/div/div[3]/div/div[2]/div/div/form/div[2]/div[1]/input";
	
	public EnterBirthDate(Driver driver) {
		super(driver,birthDate);
	}

}
