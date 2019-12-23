package services;

import java.io.File;
import java.io.IOException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.vimalselvam.cucumber.listener.Reporter;
import com.google.common.io.Files;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Data;


@Data
public class Driver  {

	private WebDriver driver;
	private WebDriverWait wait;
	private String driverPath;
	private File file;


	public Driver(String browserName) {

		if(browserName.equals("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}else if (browserName.equals("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		
		} else if(browserName.equals("edge")) {
			
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} 

	}


	public void laodPage(String url) {
 
		driver.get(url);
	}

	public void insertText(String xPath,String value) {
		driver.findElement(By.xpath(xPath)).sendKeys(value);
	}
	
	public void clearTextbox(String xPath) {
		driver.findElement(By.xpath(xPath)).clear();
	}

	public void click(String xPath) {
		 driver.findElement(By.xpath(xPath)).click();
	}

	public void waitForElement(String xPath, int seconds) {
		wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)));
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
		driver.quit();

	}


	public void checkCurrentURL(String expectedURL) {

		String realURL = driver.getCurrentUrl();
		Assert.assertTrue(realURL.equals(expectedURL));
		
	}

}