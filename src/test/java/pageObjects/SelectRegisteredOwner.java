package pageObjects;


import lombok.Data;
import services.Driver;


@Data
public class SelectRegisteredOwner {
	
	Driver driver;
	final static String wizardTitle = "//div[contains(.,'Wird das Auto auf dich zugelassen?')]";
	final  String registeredOwner = "//button[contains(.,'Nein')]";
	final  String newOrUsed = "//button[contains(.,'bei Kauf neu')]";
	final  String weiterButton = "//button[contains(.,'Weiter')]";
	
	public SelectRegisteredOwner( Driver driver) {
		this.driver = driver;
		this.driver.waitForElement(wizardTitle, 2);
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
