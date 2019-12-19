package pageObjects;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Data;
import services.Driver;

@Data
public class SelectPrecondition {
	
	Driver driver;
	
	final String option = "//*[@id=\"root\"]/div/div[3]/div/div[2]/div/div/form/div[1]/button[2]";
	final String insuranceStartingDate = "//*[@id=\"root\"]/div/div[3]/div/div[2]/div/div/form/div[2]/div[2]/div/input";
	final String weiterButton = "//*[@id=\"root\"]/div/div[3]/div/div[2]/div/div/form/section/div/div/div/button";
										  
	
	
	public SelectPrecondition(String url) {
		driver= new Driver();
		driver.laodPage(url);
	}
	
	public void selectInsuranceOption() {
		driver.click(option);
	}
	
	public void typeInsuranceStartingDate() {

		driver.clearTextbox(insuranceStartingDate);
		String today = getTodayDate();
		driver.insertText(insuranceStartingDate, today);
	}
	
	public void clickOnWeiter() {
		driver.click(weiterButton);
	}
	
	public void checkCurrentURL(String expectedURL) {
		driver.checkCurrentURL(expectedURL);
	}
	
	public String getTodayDate() {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");  
		LocalDateTime now = LocalDateTime.now(); 
		return dtf.format(now);
	}

	
	

}
