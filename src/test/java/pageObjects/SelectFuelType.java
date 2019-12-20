package pageObjects;


import services.Driver;
import services.Utils;

public class SelectFuelType extends Utils {
	
	
	final static String fuel = "//button[contains(., 'Benzin')]";  //Benzin
	
	public SelectFuelType(Driver driver) {
		
		super(driver,fuel);
	}
	
	public void selectFuel() {
		
		this.driver.click(fuel);
	}
	
}
