package pageObjects;

import lombok.Data;
import services.Driver;
import services.Utils;


public class SelectVehicle extends Utils {
		
	final static String wizardTitle = "//div[contains(.,'Wähle dein Auto aus')]";
	String autoBrand = "//button[contains(., 'brand')]";
	
	public SelectVehicle(Driver driver) {
		super(driver,wizardTitle);
	}
	
	public void selectCar(String brand) {
		autoBrand = autoBrand.replaceAll("brand", brand);
		driver.click(autoBrand);
	}
	

}
