package pageObjects;

import services.Driver;

public class SelectFuelType {
	
	Driver driver;
	
	final String fuel = "//*[@id=\"root\"]/div/div[3]/div/div[2]/div/div/form/div[2]/div[2]/button[1]";  //Benzin
	  //final String fuel = "//*[@id=\"root\"]/div/div[3]/div/div[2]/div/div/form/div[2]/div[2]/button[2]";  //Diesel
	
	public SelectFuelType(Driver driver) {
		this.driver = driver;
		this.driver.waitForElement(fuel, 2);
	}
	
	public void selectFuel() {
		this.driver.click(fuel);
		System.out.println( "Should be clicked !!!!" );
	}
	
	public void checkCurrentURL(String expectedURL) {
		driver.checkCurrentURL(expectedURL);	
	}
	
}
