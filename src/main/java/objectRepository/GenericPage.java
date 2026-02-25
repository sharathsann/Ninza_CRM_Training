package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import genericUtility.ExcelUtility;
import genericUtility.SeleniumUtility;

public class GenericPage {
 WebDriver driver;
	public GenericPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	/*
	 * Step 1:tap on Specific Required module just pass linkedText
	 * Note :If Step1 is not same just create own only for Step1
	 */
	public void headerModules_selection_campains_to_InvoiceModule(String value) {
	SeleniumUtility sUtil=new SeleniumUtility();
		WebElement id = driver.findElement(By.linkText(value));
		sUtil.safeClick(driver, id);
		//id.click();
	}
	
	/*
	 * Step2 :Tap on Create option from specific Module
	 */
	public void create_option_campains_to_InvoiceModule() {
		SeleniumUtility sUtil=new SeleniumUtility();
		
		WebElement create_button = driver.findElement(By.xpath("//button[@class='btn btn-info']"));
		//create_button.click();
		sUtil.safeClick(driver, create_button);
		
	}
	
	/*
	 *  Step 3:Idetify the element and pass into it and pass value.(input fields to fill data)
	 *  findElementAndFillValue_String(name)
	 *  findElementXpathAndFillValue_String
	 *  findElementAndFillValue_Int
	 */	
public void findElementAndFillValue_String(String ele,String value) {
		
		WebElement input_filed = driver.findElement(By.name(ele));
		
		
		input_filed.sendKeys(value);
	
	}
public void findElementXpathAndFillValue_String(String ele,String value) {
	
	WebElement input_filed = driver.findElement(By.xpath(ele));
	
	
	input_filed.sendKeys(value);

}

public void findElementAndFillValue_Int(String ele,String value) {
	
	WebElement input_filed = driver.findElement(By.name(ele));
	input_filed.sendKeys(Keys.CLEAR);
	input_filed.sendKeys(Keys.BACK_SPACE);
	input_filed.sendKeys(value);
	input_filed.sendKeys(Keys.BACK_SPACE);
}
/*
 * Directly call the Description into it
 */
public void fillDescription() {
	
	WebElement input_filed = driver.findElement(By.xpath("//div[.='Description:']//textarea"));
	input_filed.sendKeys("TestingDescriptions");
}



public void SubmitBtn_SubmitDetails() throws InterruptedException {
	SeleniumUtility sUtil=new SeleniumUtility();
	WebElement Final_Submit_Option_Btn = driver.findElement(By.xpath("//button[@type='submit']"));
	//Final_Submit_Option_Btn.click();
	sUtil.safeClick(driver, Final_Submit_Option_Btn);
	Thread.sleep(6000);
} 

public void generic_FilterDropAndSearch( String VisibleText,String SheetNametofindseachandDeletevalue,int row,int column) throws InterruptedException, EncryptedDocumentException, IOException
{    
	SeleniumUtility sUtil=new SeleniumUtility();
	
	ExcelUtility eUtil=new ExcelUtility();
	String  value = eUtil.readDatafromExcelFile(SheetNametofindseachandDeletevalue, row, column);
	
	WebElement sel = driver.findElement(By.xpath("//select[@class='form-control']"));
	sUtil.handleDropDownByVisibleText(sel, VisibleText);
	Thread.sleep(1000);
	
	 driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys(value);
}
	
public void popup_page_DropdownSelection_searchCampaign_Select(int  iconIndex,String Select_DropDownbyvisiText,String sheetNameForSearchValue,int row,int column) throws InterruptedException, EncryptedDocumentException, IOException
{
	
	ExcelUtility eUtil=new ExcelUtility();
	SeleniumUtility sUtil = new SeleniumUtility();
	LeadPage lp=new LeadPage(driver);
	 String parent = driver.getWindowHandle();
	 try {
		 WebElement taptoSelectcapaign_Option = driver.findElement(By.xpath("(//button[@type='button']/*[local-name()='svg'])[" + iconIndex + "]"));
			//taptoSelectcapaign_Option.click();
		 sUtil.safeClick(driver, taptoSelectcapaign_Option);
			
	 }
	 catch(Exception e) {
		 Reporter.log("true"+e,true);
	 }
 Thread.sleep(1000);
for (String win : driver.getWindowHandles()) {

    if (!win.equals(parent)) {
        driver.switchTo().window(win);
        break;
    }
}
Thread.sleep(1000);
sUtil.handleDropDownByVisibleText(lp.getSlectDropdown(),Select_DropDownbyvisiText);
 String  value = eUtil.readDatafromExcelFile(sheetNameForSearchValue, row, column);
lp.getSearchField().sendKeys(value);
Thread.sleep(1000);
try {
//lp.getSelectSearchedCampaignName().click();
sUtil.safeClick(driver, lp.getSelectSearchedCampaignName());
}
 catch(Exception e)
 {
	 Reporter.log("check"+e,true);
 }
driver.switchTo().window(parent);
//driver.findElement(By.xpath("//button[@type='submit']")).click();
}

public void genericPage_DleteSteps(String SheetNametofindseachandDeletevalue,int row,int column) throws InterruptedException, EncryptedDocumentException, IOException
{
	    HomePage hp=new HomePage(driver);
	    SeleniumUtility sUtil=new SeleniumUtility();
	    
	   WebElement ele = driver.findElement(By.xpath("(//a[@class='delete'])[1]"));
	    sUtil.safeClick(driver, ele);
	
	  // driver.findElement(By.xpath("(//a[@class='delete'])[1]")).click();
	   Thread.sleep(1000);
	   try {
		   
		   sUtil.safeClick(driver,  hp.getDeleteConfirmationPopupBtn());
	  // hp.getDeleteConfirmationPopupBtn().click();
	   }
	   catch(Exception e)
	   {
		   Reporter.log("confirmation popup issue"+e,true);
	   }
	   ExcelUtility eutil=new ExcelUtility();
	   String  value = eutil.readDatafromExcelFile(SheetNametofindseachandDeletevalue, row, column);
	   WebElement toastMsg = hp.getSuccess_deleted_popup();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(toastMsg));
		
		//sutil.waitForVisiblityofElement(driver);
		String msg =toastMsg.getText();
		Thread.sleep(5000);
		
		if(msg.contains(value))
		{
			Reporter.log(msg, true);
			
		}
		else
		{
			System.out.println(msg+"=is not deleted");
		}
		Thread.sleep(1000);
	
}
		
	}
	
	

