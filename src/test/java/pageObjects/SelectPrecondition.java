package pageObjects;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import services.Utils;


public class SelectPrecondition extends Utils {
	
	final static String option = "//*[@id=\"root\"]/div/div[3]/div/div[2]/div/div/form/div[1]/button[2]";
	final static String insuranceStartingDate = "//*[@id=\"root\"]/div/div[3]/div/div[2]/div/div/form/div[2]/div[2]/div/input";
	final static String weiterButton = "//*[@id=\"root\"]/div/div[3]/div/div[2]/div/div/form/section/div/div/div/button";
										  
	
	public SelectPrecondition(String url) {
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
	
	
	public String getTodayDate() {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");  
		LocalDateTime now = LocalDateTime.now(); 
		return dtf.format(now);
	}

	
	

}
