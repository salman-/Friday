package pageObjects;


import services.Driver;
import services.Utils;

public class SelectRegisteredOwner extends Utils {
	
	final static String registeredOwner = "//*[@id=\"root\"]/div/div[3]/div/div[2]/div/div/form/div[2]/button[2]";
	final static String newOrUsed = "//*[@id=\"root\"]/div/div[3]/div/div[2]/div/div/form/div[3]/div[2]/button[2]";
	final static String weiterButton = "//*[@id=\"root\"]/div/div[3]/div/div[2]/div/div/form/section/div/div/div/button[2]";
	
	public SelectRegisteredOwner( Driver driver) {
		super(driver,newOrUsed);
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
