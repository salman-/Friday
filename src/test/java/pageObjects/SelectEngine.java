package pageObjects;

import services.Driver;
import services.Utils;

public class SelectEngine extends Utils {
	
	final static String engine = "//button[contains(., '118I CABRIO')]";
	
	public SelectEngine(Driver driver) {
		super(driver,engine);
	}

	public void selectEngine() {
		driver.click(engine);
	}
}
