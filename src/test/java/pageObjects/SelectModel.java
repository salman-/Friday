package pageObjects;

import services.Driver;
import services.Utils;

public class SelectModel extends Utils{
	
	
	final static String wizardTitle = "//div[contains(.,'Wähle dein Automodell')]";
	String autoModel = "//button[contains(., 'model')]";
	
	public SelectModel(Driver driver) {
		
		super(driver,wizardTitle);
		
	}
	
	public void selectModelOfCar(String model) {
		autoModel = autoModel.replaceAll("model", model);
		driver.click(autoModel);
	}
	
	
}
