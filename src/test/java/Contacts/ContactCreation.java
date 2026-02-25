package Contacts;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import genericUtility.ExcelUtility;
import genericUtility.SeleniumUtility;
import objectRepository.CampaignPage;
import objectRepository.ContactPage;
import objectRepository.HomePage;

@Listeners
public class ContactCreation extends BaseClass{
	
	HomePage hp;
	ContactPage cp;
	ExcelUtility eUtil;
	SeleniumUtility sUtil;
	
	
	
	public void createContact()  
	{
		 hp=new HomePage(driver);
		 cp=new ContactPage(driver);
		 eUtil= new ExcelUtility();
		 sUtil=new SeleniumUtility();
		 hp.getContacts_Btn_topicon().click();
		 String verifyContactPage = cp.getValidateContactPage().getText();
		 Reporter.log("verified = "+verifyContactPage,true);
		
	}
	
	
	
		
	
	
	@Test(groups="Contact",dependsOnGroups = "Campaign")
	public void fillCreateContactDetails() throws EncryptedDocumentException, IOException, InterruptedException  
	{
		try {
		 hp=new HomePage(driver);
		 cp=new ContactPage(driver);
		 eUtil= new ExcelUtility();
		 sUtil=new SeleniumUtility();
		 String ORGANIZATION = eUtil.readDatafromExcelFile("ContactsPage", 0, 1);
		 String TITLE = eUtil.readDatafromExcelFile("ContactsPage", 1, 1);
		 String DEPARTMENT = eUtil.readDatafromExcelFile("ContactsPage", 2, 1);
		 String OFFICEPHONE = eUtil.readDatafromExcelFile("ContactsPage", 3, 1);
		 String CONTACTNAME = eUtil.readDatafromExcelFile("ContactsPage", 4, 1);
		 String MOBILE = eUtil.readDatafromExcelFile("ContactsPage", 5, 1);
		 String EMAIL = eUtil.readDatafromExcelFile("ContactsPage", 6, 1);
		// hp.getContacts_Btn_topicon().click();
		 sUtil.safeClick(driver,  hp.getContacts_Btn_topicon());
		 String verifyContactPage = cp.getValidateContactPage().getText();
		 Reporter.log("verified = "+verifyContactPage,true);
		 sUtil.safeClick(driver,  cp.getCreateContactBtn());
		 //sUtil.safeClickWithRetry(driver,  cp.getCreateContactBtn());
		// cp.getCreateContactBtn().click();
		 Reporter.log("verified contact btn top icon = "+verifyContactPage,true);
		 cp.getOrgTF().sendKeys(ORGANIZATION);
		
		 cp.getTitleTF().sendKeys(TITLE);
		
		 
		 cp.getDeptTF().sendKeys(DEPARTMENT);
		 
		 cp.getOfficeNOTF().sendKeys(OFFICEPHONE);
		 
		 cp.getContactNameTF().sendKeys(CONTACTNAME);
		
		 cp.getMobileTF().sendKeys(MOBILE);
		 
		 cp.getEmailTf().sendKeys(EMAIL);}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		 
		
			 String parent = driver.getWindowHandle();
			 sUtil.safeClick(driver, cp.getSelect_campaign_icon());
		   // cp.getSelect_campaign_icon().click();
		    
		 Thread.sleep(5000);
		for (String win : driver.getWindowHandles()) {

		    if (!win.equals(parent)) {
		        driver.switchTo().window(win);
		        break;
		    }
		}
		//Thread.sleep(2000);
		driver.manage().window().setSize(new Dimension(1920, 1080));
		sUtil.handleDropDownByVisibleText(cp.getSlectDropdown(),"Campaign Name");
		System.out.println("dropdown slected successfully");
		//Thread.sleep(2000);
		 String  CAMPAIGNNAME = eUtil.readDatafromExcelFile("Campaign", 0, 1);
		cp.getSearchField().sendKeys(CAMPAIGNNAME);
		Thread.sleep(2000);
		try {
			//sUtil.safeClick(driver, cp.getSelectSearchedCampaignName());
		cp.getSelectSearchedCampaignName().click();
		}
		 catch(Exception e)
		 {
			 Reporter.log("check"+e,true);
		 }
		
		Thread.sleep(2000);
		driver.switchTo().window(parent);
         sUtil.safeClick(driver, cp.getContactcreatesubBTN());
        // cp.getContactcreatesubBTN().click();
		 Thread.sleep(5000);
		 
		 
		 }
		@Test(priority=19,dependsOnGroups = "deleteLeads",groups = "deleteContact")
	public void deleteContact() throws EncryptedDocumentException, IOException, InterruptedException
	{
		cp=new ContactPage(driver);
		eUtil=new ExcelUtility();
		sUtil=new SeleniumUtility();
		hp=new HomePage(driver);
		try {
			
		
		String CONTACTNAME = eUtil.readDatafromExcelFile("ContactsPage", 4, 1);
		//WebElement filter = cp.getContactsPageFilterDropdown();
		Thread.sleep(2000);
		hp.getContacts_Btn_topicon().click();
		sUtil.handleDropDownByVisibleText(cp.getContactsPageFilterDropdown(),"Search by Contact Name");
		Thread.sleep(1000);
		cp.getContactsPageSearchFilter().sendKeys(CONTACTNAME);
		
		cp.getContactsDeleteIcon().click();
		Thread.sleep(2000);
		cp.getDeleteBtnConfirmationFromPopUp().click();
		}
		catch(Exception e)
		{
			Reporter.log("print ="+e,true);
		}
		WebElement toastMsg = hp.getSuccess_deleted_popup();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(toastMsg));
		
		//sutil.waitForVisiblityofElement(driver);
		String msg =toastMsg.getText();
		Thread.sleep(5000);
		String CONTACTNAME = eUtil.readDatafromExcelFile("ContactsPage", 4, 1);
		if(msg.contains(CONTACTNAME))
		{
			Reporter.log(msg, true);
			
		}
		else
		{
			System.out.println("campaign is not deleted");
		}
		
	}
		 
		
	}
	


