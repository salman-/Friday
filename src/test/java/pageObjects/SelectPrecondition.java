package pageObjects;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Data;
import services.Driver;

@Data
public class SelectPrecondition {
	
	Driver driver;
	final  String precondition = "//button[contains(.,'Das Auto wird noch zugelassen oder umgemeldet')]";
	final  String inceptionDate = "//*[@id=\"root\"]/div/div[3]/div/div[2]/div/div/form/div[2]/div[2]/div/input";
	final  String weiterButton = "//button[contains(.,'Weiter')]";
										  
	
	public SelectPrecondition(Driver driver,String url) {
 		this.driver = driver; 		
		this.driver.laodPage(url);
	}
	
	public void selectInsuranceOption() {
		driver.click(precondition);
	}
	
	public void typeInsuranceStartingDate() {

		driver.clearTextbox(inceptionDate);
		String today = getTodayDate();
		driver.insertText(inceptionDate, today);
	}
	
	public void clickOnWeiter() {
		driver.click(weiterButton);
	}
	
	
	public String getTodayDate() {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");  
		LocalDateTime now = LocalDateTime.now(); 
		return dtf.format(now);
	}

	
	

}
