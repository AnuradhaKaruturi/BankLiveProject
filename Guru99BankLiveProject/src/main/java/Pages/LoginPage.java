package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends UtilityClass {
	
public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;		
	}
 
	@FindBy(css = "input[name='uid']")
	private WebElement userName;
	
	@FindBy(name = "password")
	private WebElement password;
	
	@FindBy(css = "input[value='LOGIN']")
	private WebElement btnlogin;
	
	@FindBy(xpath = "//input[@name='btnReset']")
	private WebElement btnReset;

	
	public LoginPage setUserName(String username) {
		System.out.println(username);
		enterText(userName, username);
		//Utilities.Log.info("Entered UserName");
		return this;
	}
	
	public LoginPage setPassword(String pswd) {
	//	new UtilityClass(driver).waitForElementVisibility(password);
		password.sendKeys(pswd);
		//Utilities.Log.info("Entered password");
		return this;
	}
	
	public ManagerHomePage clickLogin() {
		btnlogin.click();
		//Utilities.Log.info("Login Button Clicked");
		return new ManagerHomePage(driver);
	}
	
    public void clickReset() {
		
	}
}
