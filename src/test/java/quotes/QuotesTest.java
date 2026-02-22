package quotes;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import genericUtility.ExcelUtility;
import objectRepository.GenericPage;

public class QuotesTest extends BaseClass{
	GenericPage gp;
	 ExcelUtility eUtil;
 @Test(priority =6,dependsOnGroups = "Products",groups = "Quotes")
	public void quoteFillDetails() throws InterruptedException, EncryptedDocumentException, IOException
	{
		 gp=new GenericPage(driver);
		 eUtil=new ExcelUtility();
		
		gp.headerModules_selection_campains_to_InvoiceModule("Quotes");
		 
		 
		Thread.sleep(1000);
		gp.create_option_campains_to_InvoiceModule();
		try {
		String SUB = eUtil.readDatafromExcelFile("QuotesPage", 0, 1);
		String QS = eUtil.readDatafromExcelFile("QuotesPage", 1, 1);
		String  BA= eUtil.readDatafromExcelFile("QuotesPage", 2, 1);
		String BPO = eUtil.readDatafromExcelFile("QuotesPage", 3, 1);
		String BCN = eUtil.readDatafromExcelFile("QuotesPage", 4, 1);
		String BS = eUtil.readDatafromExcelFile("QuotesPage", 5, 1);
		String BPC = eUtil.readDatafromExcelFile("QuotesPage", 6, 1);
		String BC = eUtil.readDatafromExcelFile("QuotesPage", 7, 1);
		String SA = eUtil.readDatafromExcelFile("QuotesPage", 8, 1);
		String SPB = eUtil.readDatafromExcelFile("QuotesPage", 9, 1);
		String SCTY = eUtil.readDatafromExcelFile("QuotesPage", 10, 1);
		String SS = eUtil.readDatafromExcelFile("QuotesPage", 11, 1);
		String SPC = eUtil.readDatafromExcelFile("QuotesPage", 12, 1);
		String SCNT = eUtil.readDatafromExcelFile("QuotesPage", 13, 1);
		gp.popup_page_DropdownSelection_searchCampaign_Select(1,"Opportunity Name", "OpportunitiesPage", 0, 1);
		gp.popup_page_DropdownSelection_searchCampaign_Select(2,"Contact Name", "ContactsPage", 4, 1);
		gp.popup_page_DropdownSelection_searchCampaign_Select(3,"Product Name", "ProductsPage", 0, 1);
		gp.findElementAndFillValue_String("subject", SUB);
		gp.findElementAndFillValue_String("quoteStage", QS);
		driver.findElement(By.xpath("//input[@name='validTill']")).sendKeys("12092027");
		try {
		gp.findElementXpathAndFillValue_String("(//textarea[@name='address'])[1]", BA);
		gp.findElementXpathAndFillValue_String("(//input[@name='poBox'])[1]", BPO);
		gp.findElementXpathAndFillValue_String("(//input[@name='state'])[1]", BS);
		}
		catch( Exception e)
		{
			e.printStackTrace();
		}
		gp.findElementXpathAndFillValue_String("(//input[@name='postalCode'])[1]", BPC);
		gp.findElementXpathAndFillValue_String("(//input[@name='country'])[1]", BCN);
		gp.findElementXpathAndFillValue_String("(//input[@name='city'])[1]", BC);
		gp.findElementXpathAndFillValue_String("(//textarea[@name='address'])[2]", SA);
		gp.findElementXpathAndFillValue_String("(//input[@name='poBox'])[2]", SPB);
		gp.findElementXpathAndFillValue_String("(//input[@name='city'])[2]", SCTY);
		gp.findElementXpathAndFillValue_String("(//input[@name='state'])[2]", SS);
		gp.findElementXpathAndFillValue_String("(//input[@name='postalCode'])[2]", SPC);
		gp.findElementXpathAndFillValue_String("(//input[@name='country'])[2]", SCNT);
		
		
		
		
		Thread.sleep(1000);
		
		
	}
		catch(Exception e)
		{
			System.out.println("issuecheck"+e);
		}
		gp.SubmitBtn_SubmitDetails();
		
	}
	@Test(priority=15,dependsOnGroups = "PurchaseOrderDelete",groups = "QuoteDelete")
 public void QuoteDelete() throws EncryptedDocumentException, InterruptedException, IOException
 {
	     gp=new GenericPage(driver);
		 eUtil=new ExcelUtility();
		gp.headerModules_selection_campains_to_InvoiceModule("Quotes");
		Thread.sleep(2000);
		gp.generic_FilterDropAndSearch("Search by Subject", "QuotesPage", 0, 1);
		Thread.sleep(2000);
		gp.genericPage_DleteSteps("QuotesPage", 0, 1);
		Thread.sleep(5000);
		
 }
	
}
