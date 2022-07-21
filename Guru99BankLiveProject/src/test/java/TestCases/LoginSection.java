package TestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Utilities.DataLoader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSection {
	
public WebDriver driver;
	
	@Parameters({"browserName"})
	@BeforeMethod
	public void OpenBrowser(String browserName) {

		switch(browserName){
		case "chrome":
			WebDriverManager.chromedriver().cachePath("src/test/resources/drivers").setup(); 
			driver = new ChromeDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().cachePath("src/test/resources/drivers").setup();
			driver = new EdgeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().cachePath("src/test/resources/drivers").setup();
			driver = new FirefoxDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().cachePath("src/test/resources/drivers").setup();
			driver = new InternetExplorerDriver();
			break;
		default:
			throw new IllegalStateException("Invalid browser name: ");
		}
		driver.manage().window().maximize();
		driver.get(new DataLoader().getUrl());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	@Parameters({"userName" , "password"})
	@Test(enabled = true)
	public void validCredentials(String username , String password) {
		
		new LoginPage(driver).setUserName(username);
		new LoginPage(driver).setPassword(password);
		new LoginPage(driver).clickLogin();
		
	}
	

	@AfterMethod
	public void closeBrowser()
	{
		//Close the Browser.
		 driver.close();
				
	}

}
