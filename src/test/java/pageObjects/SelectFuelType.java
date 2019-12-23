package pageObjects;


import lombok.Data;
import services.Driver;

@Data
public class SelectFuelType {
	
	Driver driver;
	final static String wizardTitle = "//div[contains(.,'Was tankst du?')]";
	String autoFuel = "//button[contains(., 'fuel')]";  
	
	public SelectFuelType(Driver driver) {
		
		this.driver = driver;
		driver.waitForElement(wizardTitle, 2);
	}
	
	public void selectFuel(String fuel) {
		
		autoFuel = autoFuel.replaceAll("fuel", fuel);
		this.driver.click(autoFuel);
	}
	
}
