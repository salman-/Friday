package pageObjects;

import services.Driver;
import services.Utils;

public class EnterRegistrationDate extends Utils{
	
	final static String wizardTitle = "//div[contains(.,'Wann war die Erstzulassung?')]";
	String monthYearFirstRegistered = "//*[@id=\"root\"]/div/div[3]/div/div[2]/div/div/form/div/div[2]/div/div/input";
	String weiterButton = "//button[contains(.,'Weiter')]";												

	public EnterRegistrationDate(Driver driver) {
		super(driver,wizardTitle);
	}
	
	public void typeRegisterationDate() {
		driver.clearTextbox(monthYearFirstRegistered);
		driver.insertText(monthYearFirstRegistered, "02.2020");
		
	}
	
	public void clickOnWeiter() {
		driver.click(weiterButton);
	}
	
}
