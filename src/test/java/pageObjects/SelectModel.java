package pageObjects;

import services.Driver;
import services.Utils;

public class SelectModel extends Utils{

	final static String model = "//button[contains(., '1er')]";
	
	public SelectModel(Driver driver) {
		
		super(driver,model);
		
	}
	
	public void selectModelOfCar() {
		driver.click(model);
	}
	
	
}
