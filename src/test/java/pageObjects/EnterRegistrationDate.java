package pageObjects;

import lombok.Data;
import services.Driver;

@Data
public class EnterRegistrationDate{
	
	Driver driver;
	final static String wizardTitle = "//div[contains(.,'Wann war die Erstzulassung?')]";
	String monthYearFirstRegistered = "//*[@id=\"root\"]/div/div[3]/div/div[2]/div/div/form/div/div[2]/div/div/input";
	String weiterButton = "//button[contains(.,'Weiter')]";												

	public EnterRegistrationDate(Driver driver) {
		this.driver = driver;
		this.driver.waitForElement(wizardTitle, 2);
	}
	
	public void typeRegisterationDate() {
		driver.clearTextbox(monthYearFirstRegistered);
		driver.insertText(monthYearFirstRegistered, "02.2020");
		
	}
	
	public void clickOnWeiter() {
		driver.click(weiterButton);
	}
	
}
