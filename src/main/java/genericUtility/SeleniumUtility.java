package genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.io.FileHandler;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtility {
	/**
	 * This method will maximize the window
	 * @param driver
	 */
	public void  maximizeWindow(WebDriver driver) {
	
		driver.manage().window().maximize();
	}

	/**
	 * This methos will minimize the Screen window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver) {
	
		driver.manage().window().minimize();
	}
	
	/**
	 * This method will make fullScreen
	 * @param driver
	 */
	public void fullScreenWindow(WebDriver driver) {
	
		driver.manage().window().fullscreen();
	}

	/**
	 * This method is used for the implicitlywait
	 * @param driver
	 */
	
	public void addImplicitlywait(WebDriver driver) {
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 * This method will wait for specified seconds
	 * @param seconds
	 */
	public void waitForSeconds(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method is used for the waituntilelement to be visible 'explicitly wait'
	 * @param driver
	 * @param element
	 */
	public void waitForElementTobeVisible(WebDriver driver,WebElement element) {
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
		/**
		 * This method is used for the waituntilelement to be Clickable 'explicitly wait'
		 * @param driver
		 * @param element
		 */
		public void waitForElementTobeClickable(WebDriver driver,WebElement element) {
			WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(element));
	}
		/**
		 * This method will handle dropdownbyindex
		 * @param eleement
		 * @param index
		 */
	public void handleDropdown(WebElement element,int index)
	{
		Select s= new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * This method will handle dropdown selection by visibleText
	 * @param element
	 * @param visibleText
	 */
    public void handleDropDownByVisibleText(WebElement element, String visibleText) {
        Select select = new Select(element);
        select.selectByVisibleText(visibleText);
    }
   /**
    * This method will handle dropdown selection by value
    * @param element
    * @param value
    */
    public void handleDropDownByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }
    /**
	 * This method will perform mouse overing action on web element
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	//Drag and drop , DoubleClick, context click , click and hold, release
	
	/**
	 * This method will perform drag and drop action on web element
	 * @param driver
	 * @param source element
	 * @param target element
	 */
	public void dragAndDropAction(WebDriver driver, WebElement srcEle, WebElement tarele)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(srcEle,tarele).perform();
	}
	/**
	 * This method will perform double click action on web element
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	/**
	 * This method will perform right click action on web element
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	/**
	 * This method will perform click and Hold action on web element
	 * @param driver
	 * @param element
	 */
	public void clickAndHoldAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.clickAndHold(element).perform();
	}
	/**
	 * This method will perform release action on web element
	 * @param driver
	 * @param element
	 */
	public void releaseAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.release(element).perform();
	}
	/**
	 * This method will perform Scroll action on web element
	 * @param driver
	 * @param element
	 */
	public void ScrollAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.scrollToElement(element).perform();
	}
	/**
	 * This method will switch to Frame based on index
	 * @param driver
	 * @param frameIndex
	 */
	public void switchToFrame(WebDriver driver, int frameIndex)
	{
		driver.switchTo().frame(frameIndex);
	}
	/**
	 * This method will switch to Frame based on Name or ID
	 * @param driver
	 * @param Name or ID
	 */
	public void switchToFrame(WebDriver driver, String frameNameorID)
	{
		driver.switchTo().frame(frameNameorID);
	}
	/**
	 * This method will switch to Frame based on WebElement
	 * @param driver
	 * @param WebElement
	 */
	public void switchToFrame(WebDriver driver, WebElement frameElement)
	{
		driver.switchTo().frame(frameElement);
	}
	/**
	 * This method will switch the control to immediate parent frame
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	/**
	 * This method will switch the control to main Page
	 * @param driver
	 */
	public void switchToDeafultContent(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	/**
	 * This method will switch to window
	 * @param driver
	 * @param windowID
	 */
	public void switchToWindow(WebDriver driver, String windowID)
	{
		driver.switchTo().window(windowID);
	}
	/**
	 * This method will accept alert pop-up
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * This method will dismiss alert pop-up
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * This method will capture text from alert pop-up and return to caller
	 * @param driver
	 * @return alert text
	 */
	public String getAlertText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	/**
	 * This method will enter data into alert pop-up
	 * @param driver
	 * @param Data
	 */
	public void EnterAlertData(WebDriver driver, String data)
	{
		driver.switchTo().alert().sendKeys(data);
	}
	/**
	 * This method will scroll down by 500 units
	 * @param driver
	 */
	public void scrollDown(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500);", "");
	}
	/**
	 * This method will capture screenshot and return the absolute path to
	 * caller
	 * @param driver
	 * @param screenshotName
	 * @return Path
	 * @throws IOException
	 */
	public String captureScreenShot(WebDriver driver, String screenshotName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\ScreenShots\\"+screenshotName+".png");
		FileHandler.copy(src,dst);
		return dst.getAbsolutePath(); //For extent Reports 
	}
	
	public void safeClick(WebDriver driver, WebElement element) {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(element));

	    try {
	        ((JavascriptExecutor) driver)
	                .executeScript("arguments[0].scrollIntoView({block:'center'});", element);

	        element.click();
	    } 
	    catch (Exception e) {
	        ((JavascriptExecutor) driver)
	                .executeScript("arguments[0].click();", element);
	    }
	}
	

}
