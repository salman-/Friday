package services;

import lombok.Data;
import lombok.Getter;
import lombok.AccessLevel;

@Data
public class Utils {

	@Getter(AccessLevel.PUBLIC)
	protected Driver driver;
	
	public Utils() {
		this.driver = new Driver();
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
