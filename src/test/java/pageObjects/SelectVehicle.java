package pageObjects;

import lombok.Data;
import services.Driver;

@Data
public class SelectVehicle {
		
	Driver driver;
	final static String wizardTitle = "//div[contains(.,'Wähle dein Auto aus')]";
	String autoBrand = "//button[contains(., 'brand')]";
	
	public SelectVehicle(Driver driver) {
		this.driver = driver;
		driver.waitForElement(wizardTitle, 2);
	}
	
	public void selectCar(String brand) {
		autoBrand = autoBrand.replaceAll("brand", brand);
		driver.click(autoBrand);
	}
	

}
