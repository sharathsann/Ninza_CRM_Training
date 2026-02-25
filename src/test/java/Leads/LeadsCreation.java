package Leads;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import genericUtility.ExcelUtility;
import genericUtility.SeleniumUtility;
import objectRepository.ContactPage;
import objectRepository.HomePage;
import objectRepository.LeadPage;

public class LeadsCreation extends BaseClass{
	HomePage hp;
	LeadPage lp;
	ExcelUtility eUtil;
	SeleniumUtility sUtil;
	
	
	public void createContact()  
	{
		 hp=new HomePage(driver);
		 lp=new LeadPage(driver);
		 eUtil= new ExcelUtility();
		 sUtil=new SeleniumUtility();
		 hp.getLeadPagelink().click();
		 String verifyContactPage = lp.getValidateLeadsPage().getText();
		 Reporter.log("verified = "+verifyContactPage,true);
		
	}
	@Test(priority=3,groups="Leads",dependsOnGroups = "Contact")
	public void fillCreateContactDetails() throws EncryptedDocumentException, IOException, InterruptedException  
	{
		hp=new HomePage(driver);
		 lp=new LeadPage(driver);
		 eUtil= new ExcelUtility();
		 sUtil=new SeleniumUtility();
		 String Lead_Name = eUtil.readDatafromExcelFile("LeadPage", 0, 1);
		 String Company = eUtil.readDatafromExcelFile("LeadPage", 1, 1);
		 String Lead_Source = eUtil.readDatafromExcelFile("LeadPage", 2, 1);
		 String Industry = eUtil.readDatafromExcelFile("LeadPage", 3, 1);
		 String Annual_revenue = eUtil.readDatafromExcelFile("LeadPage", 4, 1);
		 String Numberof_Employee = eUtil.readDatafromExcelFile("LeadPage", 5, 1);
		 String Phone = eUtil.readDatafromExcelFile("LeadPage", 6, 1);
		 String Email = eUtil.readDatafromExcelFile("LeadPage", 7, 1);
		 String Secondary_Email = eUtil.readDatafromExcelFile("LeadPage", 8, 1);
		 String Lead_Status = eUtil.readDatafromExcelFile("LeadPage", 9, 1);
		 String Rating = eUtil.readDatafromExcelFile("LeadPage", 10, 1);
		 String Assigned_to = eUtil.readDatafromExcelFile("LeadPage", 11, 1);
		 String Address = eUtil.readDatafromExcelFile("LeadPage", 12, 1);
		 String City = eUtil.readDatafromExcelFile("LeadPage", 13, 1);
		 String Country = eUtil.readDatafromExcelFile("LeadPage", 14, 1);
		 String Postal_code = eUtil.readDatafromExcelFile("LeadPage", 15, 1);
		 String Website = eUtil.readDatafromExcelFile("LeadPage", 16, 1);
		 String campaign = eUtil.readDatafromExcelFile("LeadPage", 17, 1);
		 String description = eUtil.readDatafromExcelFile("LeadPage", 18, 1);
	 
		 
		 hp.getLeadPagelink().click();
		 
		 String verifyContactPage = lp.getValidateLeadsPage().getText();
		 Reporter.log("verified = "+verifyContactPage,true);
		 sUtil.safeClick(driver,  lp.getCreateleadBTN());
		// lp.getCreateleadBTN().click();
		 
		 lp.getLeadName().sendKeys(Lead_Name);
		
		 lp.getCompany().sendKeys(Company);
		
		 lp.getLeadSource().sendKeys(Lead_Source);
		 
		 lp.getIndustry().sendKeys(Industry);
		 lp.getAnnualRevenue().clear();
		 lp.getAnnualRevenue().sendKeys(Annual_revenue);
		 lp.getAnnualRevenue().sendKeys(Keys.BACK_SPACE);
		 lp.getNoOfEmployees().clear();
		 lp.getNoOfEmployees().sendKeys(Numberof_Employee);
		 lp.getNoOfEmployees().sendKeys(Keys.BACK_SPACE);
		 
		 lp.getPhone().sendKeys(Phone);
		 lp.getEmail().sendKeys(Email);
		 lp.getSecondaryEmail().sendKeys(Secondary_Email);
		 lp.getLeadStatus().sendKeys(Lead_Status);
		 lp.getRating().sendKeys(Rating);
		 lp.getAssignedTo().sendKeys(Assigned_to);
		 lp.getAddress().sendKeys(Address);
		 Thread.sleep(2000);
		 lp.getCity().sendKeys(City);
		 lp.getCountry().sendKeys(Country);
		 Thread.sleep(2000);
		 lp.getPostalCode().sendKeys(Postal_code);
		 Thread.sleep(2000);
		 try {
		 lp.getWebsite().sendKeys(Website);
		 Thread.sleep(2000);
		 Thread.sleep(2000);
		 }
		 catch(Exception e) {
			 Reporter.log("true"+e,true);
		 }
		 
		
			 String parent = driver.getWindowHandle();
			 try {
				 lp.getSelect_campaign_icon().click(); 
			 }
			 catch(Exception e) {
				 Reporter.log("true"+e,true);
			 }
		 Thread.sleep(5000);
		for (String win : driver.getWindowHandles()) {

		    if (!win.equals(parent)) {
		        driver.switchTo().window(win);
		        break;
		    }
		}
		Thread.sleep(2000);
		sUtil.handleDropDownByVisibleText(lp.getSlectDropdown(),"Campaign Name");
		 String  CAMPAIGNNAME = eUtil.readDatafromExcelFile("Campaign", 0, 1);
		lp.getSearchField().sendKeys(CAMPAIGNNAME);
		Thread.sleep(2000);
		try {
		lp.getSelectSearchedCampaignName().click();
		}
		 catch(Exception e)
		 {
			 Reporter.log("check"+e,true);
		 }
		
		Thread.sleep(2000);
		driver.switchTo().window(parent);
		//lp.getDescription().sendKeys(description);

         lp.getLeadcreatesubBTN().click();
		 Thread.sleep(5000);
		 
		 
		 }
		@Test(priority=18,dependsOnGroups = "OpportunitiesDelete",groups = "deleteLeads")
	public void deleteLeads() throws EncryptedDocumentException, IOException, InterruptedException
	{
		lp=new LeadPage(driver);
		eUtil=new ExcelUtility();
		sUtil=new SeleniumUtility();
		hp=new HomePage(driver);
		try {
			
		
			String Lead_Name = eUtil.readDatafromExcelFile("LeadPage", 0, 1);
		//WebElement filter = cp.getContactsPageFilterDropdown();
		Thread.sleep(2000);
		hp.getLeadPagelink().click();
		sUtil.handleDropDownByVisibleText(lp.getLeadsPageFilterDropdown(),"Search by Lead Name");
		Thread.sleep(1000);
		lp.getLeadsPageSearchFilter().sendKeys(Lead_Name);
		
		lp.getLeadsDeleteIcon().click();
		Thread.sleep(2000);
		lp.getDeleteBtnConfirmationFromPopUp().click();
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
		String Lead_Name = eUtil.readDatafromExcelFile("LeadPage", 0, 1);
		if(msg.contains(Lead_Name))
		{
			Reporter.log(msg, true);
			
		}
		else
		{
			System.out.println("campaign is not deleted");
		}

}
}
