package services;

import java.io.File;
import java.io.IOException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import lombok.Data;


@Data
public class Driver  {

	private WebDriver driver;
	private WebDriverWait wait;


	public Driver() {

		File file = new File("src/test/resources/driver/chromedriver.exe");

		String driverPath=file.getAbsolutePath();
		System.out.println("Webdriver is in path: "+driverPath);
		System.setProperty("webdriver.chrome.driver",driverPath); 
	}


	public void laodPage(String url) {
		driver=new ChromeDriver();
		driver.get(url);
	}

	public void insertText(String xPath,String value) {
		driver.findElement(By.xpath(xPath)).sendKeys(value);
	}
	
	public void clearTextbox(String xPath) {
		driver.findElement(By.xpath(xPath)).clear();
	}

	public String getText(String xPath) {	
		return driver.findElement(By.xpath(xPath)).getAttribute("value");
	}

	public String getTextFromDiv(String xPath) {	
		return driver.findElement(By.xpath(xPath)).getText();
	}

	public void click(String xPath) {
		 driver.findElement(By.xpath(xPath)).click();
	}

	public void waitForElement(String xPath, int seconds) {
		wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)));
	}


	public void scrollDown() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("document-content")));
		// Select last child of content div
		WebElement element = driver.findElement(By.xpath("//div[@id='document-content']/*[last()]")); 
		// Scroll to last child node
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

	}


	public void takeScreenshot() {
			
			try {
				//This takes a screenshot from the driver and save it to the specified location
				 TakesScreenshot ts = (TakesScreenshot) driver;

				 File src = ts.getScreenshotAs(OutputType.FILE); 
				String path = System.getProperty("user.dir") + "\\target\\screenshots\\" + System.currentTimeMillis()+".png";
				File destinationPath = new File( path );
				System.out.println("The Path for Screenshot is: "+ path );

				//Copy taken screenshot from source location to destination location
				Files.copy(src, destinationPath);   

				//This attach the specified screenshot to the test
				Reporter.addScreenCaptureFromPath(path);
			} catch (IOException e) {
				System.out.println(" Exception is: "+ e.getMessage() );
			} 
	}

	public void closeBrowser() {
		driver.close();

	}


	

	public void checkCurrentURL(String expectedURL) {
	
		new WebDriverWait(driver, 5).until(
			    new ExpectedCondition<Boolean>() {
			        public Boolean apply(WebDriver d) {
			        	JavascriptExecutor jse = (JavascriptExecutor)d;
			            return jse.executeScript("return document.readyState").equals("complete");
			        }   
			    }
			);
		
		String realURL = driver.getCurrentUrl();
		System.out.println("------------------------------------URL is: "+realURL);
		Assert.assertTrue(realURL.equals(expectedURL));
		
	}





}