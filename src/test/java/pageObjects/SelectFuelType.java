package pageObjects;


import services.Driver;
import services.Utils;

public class SelectFuelType extends Utils {
	
	
	final static String wizardTitle = "//div[contains(.,'Was tankst du?')]";
	static String autoFuel = "//button[contains(., 'fuel')]";  
	
	public SelectFuelType(Driver driver) {
		
		super(driver,wizardTitle);
	}
	
	public void selectFuel(String fuel) {
		
		autoFuel = autoFuel.replaceAll("fuel", fuel);
		this.driver.click(autoFuel);
	}
	
}
