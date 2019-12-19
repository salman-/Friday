package pageObjects;

import lombok.Data;
import services.Driver;

@Data
public class SelectRegisteredOwner {
	
	//Bist du der Halter des Autos (zugelassen auf dich)?
	final String registeredOwner = "//*[@id=\"root\"]/div/div[3]/div/div[2]/div/div/form/div[2]/button[2]";

	//Das Auto war...
	final String newOrUsed = "//*[@id=\"root\"]/div/div[3]/div/div[2]/div/div/form/div[3]/div[2]/button[2]";
	
	final String weiterButton = "//*[@id=\"root\"]/div/div[3]/div/div[2]/div/div/form/section/div/div/div/button[2]";
	
	Driver driver;
	
	public SelectRegisteredOwner( Driver driver) {
		this.driver = driver;
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
	
	public void checkCurrentURL(String expectedURL) {
		driver.checkCurrentURL(expectedURL);
	}
	
}
