package pageObjects;

import lombok.Data;
import services.Driver;

@Data
public class SelectModel {

	Driver driver;
	
	final String model = "//*[@id=\"root\"]/div/div[3]/div/div[2]/div/div/form/div[2]/div[2]/div[1]/button[1]";
	
	public SelectModel(Driver driver) {
		
		this.driver = driver;
		driver.waitForElement(model, 2);
	}
	
	public void selectModelOfCar() {
		driver.click(model);
	}
	
	public void checkCurrentURL(String expectedURL) {
		driver.checkCurrentURL(expectedURL);
		
	}
	
}
