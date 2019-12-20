package pageObjects;

import lombok.Data;
import services.Driver;
import services.Utils;


public class SelectVehicle extends Utils {
		
	final static String list = "//*[@id=\"root\"]/div/div[3]/div/div[2]/div/div/div/form/div[2]/button[1]";
						 
						 
	final static String BMWItem = "//*[@id=\"root\"]/div/div[3]/div/div[2]/div/div/div/form/div[3]/div[2]/div[1]/button[3]";
	
	
	public SelectVehicle(Driver driver) {
		super(driver,BMWItem);
	}
	
	public void selectCar() {
		driver.click(BMWItem);
	}
	

}
