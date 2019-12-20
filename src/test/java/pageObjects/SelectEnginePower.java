package pageObjects;

import services.Driver;
import services.Utils;

public class SelectEnginePower extends Utils {
	
	final static String horsePower = "//button[contains(., '105 kW / 143 PS')]";
	
	public SelectEnginePower(Driver driver) {
		super(driver,horsePower);
	}
	
	public void selectHorsePower() {
		driver.click(horsePower);
	}
	

}
