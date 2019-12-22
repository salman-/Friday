package pageObjects;


import services.Driver;
import services.Utils;

public class SelectRegisteredOwner extends Utils {
	
	final static String wizardTitle = "//div[contains(.,'Wird das Auto auf dich zugelassen?')]";
	final static String registeredOwner = "//button[contains(.,'Nein')]";
	final static String newOrUsed = "//button[contains(.,'bei Kauf neu')]";
	final static String weiterButton = "//button[contains(.,'Weiter')]";
	
	public SelectRegisteredOwner( Driver driver) {
		super(driver,wizardTitle);
	}
	
	public void specifyTheCarOwner() {
		driver.click(registeredOwner);
	}
	
	public void specifyTheNewOrUsed() {
		driver.click(newOrUsed);
	}
	
	public void clickOnWeiter() {
		driver.click(weiterButton);
	}
	
	
}
