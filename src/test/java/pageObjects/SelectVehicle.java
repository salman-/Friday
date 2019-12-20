package pageObjects;

import lombok.Data;
import services.Driver;

@Data
public class SelectVehicle {
	
	Driver driver;
	
	final String list = "//*[@id=\"root\"]/div/div[3]/div/div[2]/div/div/div/form/div[2]/button[1]";
						 
						 
	final String BMWItem = "//*[@id=\"root\"]/div/div[3]/div/div[2]/div/div/div/form/div[3]/div[2]/div[1]/button[3]";
	
	
	public SelectVehicle(Driver driver) {
		this.driver = driver;
		driver.waitForElement(BMWItem, 2);
	}
	
	public void selectCar() {
		driver.click(BMWItem);
	}

	public void checkCurrentURL(String expectedURL) {
		driver.checkCurrentURL(expectedURL);
		
	}
	
	

}
