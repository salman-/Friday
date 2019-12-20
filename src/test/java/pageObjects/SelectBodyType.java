package pageObjects;

import lombok.Data;
import services.Driver;

@Data
public class SelectBodyType {
	
	Driver driver;
	
	final String bodyType = "//*[@id=\"root\"]/div/div[3]/div/div[2]/div/div/form/div[2]/div[2]/button[1]";
	
	public SelectBodyType(Driver driver) {
		this.driver = driver;
		this.driver.waitForElement(bodyType, 2);
	}
	
	public void selectBodyTypeOfTheCar() {
		driver.click(bodyType);
	}
	
	public void checkCurrentURL(String expectedURL) {
		driver.checkCurrentURL(expectedURL);
		
	}
	

}
