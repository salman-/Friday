package services;

import lombok.Data;
import lombok.Getter;
import lombok.AccessLevel;

@Data
public class Utils {

	@Getter(AccessLevel.PUBLIC)
	protected Driver driver;
	
	final static String logo = "//*[@id=\"root\"]/div/div[1]/div[1]/a";
	
	
	public Utils() {
		this.driver = new Driver("chrome");
		
	}
	
	public Utils(Driver driver,String xPath) {
		this.driver = driver;
		this.driver.waitForElement(xPath, 2);
	}
	
	
	public void checkCurrentURL(String expectedURL) {
		driver.checkCurrentURL(expectedURL);
	}
	
	public void closeBrowser() {
		driver.closeBrowser();
	}
	
}
