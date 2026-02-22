package Invoice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import genericUtility.ExcelUtility;
import objectRepository.GenericPage;

public class InvoiceTest  extends BaseClass{
	GenericPage gp;
	 ExcelUtility eUtil;
@Test(priority =9,dependsOnGroups = "SalesOrder",groups = "Invoice")
	public void PurchaseOrderFillDetails() throws InterruptedException, EncryptedDocumentException, IOException
	{
		 gp=new GenericPage(driver);
		 eUtil=new ExcelUtility();
		
		gp.headerModules_selection_campains_to_InvoiceModule("Invoice");
		 
		 
		Thread.sleep(1000);
		gp.create_option_campains_to_InvoiceModule();
		try {
		String SUB = eUtil.readDatafromExcelFile("SalesOrderPage", 0, 1);
		String QS = eUtil.readDatafromExcelFile("SalesOrderPage", 1, 1);
		String  BA= eUtil.readDatafromExcelFile("SalesOrderPage", 2, 1);
		String BPO = eUtil.readDatafromExcelFile("SalesOrderPage", 3, 1);
		String BCN = eUtil.readDatafromExcelFile("SalesOrderPage", 4, 1);
		String BS = eUtil.readDatafromExcelFile("SalesOrderPage", 5, 1);
		String BPC = eUtil.readDatafromExcelFile("SalesOrderPage", 6, 1);
		String BC = eUtil.readDatafromExcelFile("SalesOrderPage", 7, 1);
		String SA = eUtil.readDatafromExcelFile("SalesOrderPage", 8, 1);
		String SPB = eUtil.readDatafromExcelFile("SalesOrderPage", 9, 1);
		String SCTY = eUtil.readDatafromExcelFile("SalesOrderPage", 10, 1);
		String SS = eUtil.readDatafromExcelFile("SalesOrderPage", 11, 1);
		String SPC = eUtil.readDatafromExcelFile("SalesOrderPage", 12, 1);
		String SCNT = eUtil.readDatafromExcelFile("SalesOrderPage", 13, 1);
		gp.popup_page_DropdownSelection_searchCampaign_Select(1,"Contact Name", "ContactsPage", 4, 1);
		try {
		gp.popup_page_DropdownSelection_searchCampaign_Select(2,"Subject", "QuotesPage", 0, 1);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		gp.popup_page_DropdownSelection_searchCampaign_Select(3,"Product Name", "ProductsPage", 0, 1);
		
		gp.findElementAndFillValue_String("subject", SUB);
		gp.findElementAndFillValue_String("status", QS);
		driver.findElement(By.xpath("//input[@name='validTill']")).sendKeys("12092027");
		driver.findElement(By.xpath("//input[@name='dueDate']")).sendKeys("12012028");
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
	@Test(priority=12,dependsOnGroups = "deleteAdminUser",groups = "InvoiceOrderDelete")
public void InvoiceOrderDelete() throws EncryptedDocumentException, InterruptedException, IOException
{
		try {
	     gp=new GenericPage(driver);
		 eUtil=new ExcelUtility();
		gp.headerModules_selection_campains_to_InvoiceModule("Invoice");
		Thread.sleep(1000);
		gp.generic_FilterDropAndSearch("Search by Subject", "SalesOrderPage", 0, 1);
		Thread.sleep(1000);
		gp.genericPage_DleteSteps("SalesOrderPage", 0, 1);
		Thread.sleep(1000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
}
	
}
