package pageObjects;

import services.Driver;
import services.Utils;

public class EnterRegistrationDate extends Utils{
	
	final static String monthYearFirstRegistered = "//*[@id=\"root\"]/div/div[3]/div/div[2]/div/div/form/div/div[2]/div/div/input";
	final static String weiterButton = "//*[@id=\"root\"]/div/div[3]/div/div[2]/div/div/form/section/div/div/div/button[2]";												

	public EnterRegistrationDate(Driver driver) {
		super(driver,monthYearFirstRegistered);
	}
	
	public void typeRegisterationDate() {
		driver.clearTextbox(monthYearFirstRegistered);
		driver.insertText(monthYearFirstRegistered, "01.2020");
		
	}
	
	public void clickOnWeiter() {
		driver.click(weiterButton);
	}
	
}
