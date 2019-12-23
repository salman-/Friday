package pageObjects;

import lombok.Data;
import services.Driver;

@Data
public class SelectModel{
	
	Driver driver;
	final static String wizardTitle = "//div[contains(.,'Wähle dein Automodell')]";
	String autoModel = "//button[contains(., 'model')]";
	
	public SelectModel(Driver driver) {
		
		this.driver = driver;
		this.driver.waitForElement(wizardTitle, 2);	
	}
	
	public void selectModelOfCar(String model) {
		autoModel = autoModel.replaceAll("model", model);
		driver.click(autoModel);
	}
	
	
}
