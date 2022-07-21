package Pages;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilityClass {
	
    public WebDriver driver;
	
	
	public UtilityClass(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;	
	}
	
	
	public void click(WebElement element) {
		waitForElementVisibility(element);
		element.click();	
	}
	
	public void clear(WebElement element) {
		waitForElementVisibility(element);
		element.clear();	
	}
	
	public void enterText(WebElement element , String data) {
		waitForElementVisibility(element);
		element.sendKeys(data);	
	} 
	
	public void clickByJavascript(WebElement element) { //https://stackoverflow.com/questions/11947832/how-to-click-an-element-in-selenium-webdriver-using-javascript
		waitForElementVisibility(element);
		JavascriptExecutor jsexecutor = (JavascriptExecutor) driver;
		jsexecutor.executeScript("argument[0].click();", element);
	}
	
	public void scrollToElement(WebElement element) { //https://stackoverflow.com/questions/11947832/how-to-click-an-element-in-selenium-webdriver-using-javascript
		waitForElementVisibility(element);
		JavascriptExecutor jsexecutor = (JavascriptExecutor) driver;
		jsexecutor.executeScript("argument[0].scrollIntoView(true);", element);
	}
	
	public void switchToNewTab() {
		JavascriptExecutor jsexecutor = (JavascriptExecutor) driver;
		jsexecutor.executeScript("window.open()");
	}
	
	public void doubleClick(WebElement element) {
		Actions actions = new Actions(driver);
		waitForElementVisibility(element);
		actions.doubleClick().perform();
	}
	
	public void rightClick(WebElement element) {
		Actions actions = new Actions(driver);
		waitForElementVisibility(element);
		actions.contextClick().perform();
	}
	
	public void moveToElement(WebElement element) {
		Actions actions = new Actions(driver);
		waitForElementVisibility(element);
		actions.moveToElement(element).perform();
	}
	
	public void dragAndDrop(WebElement source ,WebElement target) {
		Actions actions =  new Actions(driver);
		actions.dragAndDrop(source, target).perform();
	}

	
	public void selectByValue(WebElement element, String value) {
		waitForElementVisibility(element);
		Select select = new Select(element);
		select.selectByValue(value);
	}
   
	public void selectByVisibleText(WebElement element, String text) {
		waitForElementVisibility(element);
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
   
	public void selectByIndex(WebElement element, int index) {
		waitForElementVisibility(element);
		Select select = new Select(element);
		select.selectByIndex(index);
	}
   
	
	public void waitForElementVisibility(WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		//wait.until(ExpectedConditions.visibilityOf(element));

	}
	
	public void sendKeys(WebElement element , String data) {
		   waitForElementVisibility(element);
		   element.clear();
		   element.sendKeys(data);   
	   }
	
	public String getText(WebElement e) {
		waitForElementVisibility(e);
		return e.getText();
	}
	
	public String getAttribute(WebElement e , String attribute) {
		waitForElementVisibility(e);
		return e.getAttribute(attribute);
	}

	public void switchToNextTab() {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
	}
	
	public void switchToPreviousTab() {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));
	}
	
	public void switchToParentWindow() {
		driver.switchTo().defaultContent();
	}
	
	public void fileUpload( WebElement element) {
		element.sendKeys("\"C:\\Users\\anura\\Desktop\\seleniumFileuploadfile.txt\"");
	}
	
	
	/*
	public void fileUpload(String filePath , WebElement element) {
		String path = System.getProperty("users.dir")+"\\testData\\"+"FilePaths";
		waitForElementVisibility(element);
		element.sendKeys(path);
	}
	*/
	
	public void submitKeys(WebElement element , Keys key) {
		waitForElementVisibility(element);
		element.sendKeys(key);
	}
	

}
