package pageObjects;

import services.Driver;
import services.Utils;

public class SelectBodyType extends Utils{
	
	final static String bodyType = "//button[contains(., 'Cabrio')]";
	
	public SelectBodyType(Driver driver) {
		super(driver,bodyType);
	}
	
	public void selectBodyTypeOfTheCar() {
		driver.click(bodyType);
	}
	
	

}
