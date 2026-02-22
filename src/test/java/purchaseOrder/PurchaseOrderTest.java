package purchaseOrder;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import genericUtility.ExcelUtility;
import objectRepository.GenericPage;

public class PurchaseOrderTest  extends BaseClass{
	GenericPage gp;
	 ExcelUtility eUtil;
@Test(priority =7,dependsOnGroups = "Quotes",groups = "PurchaseOrder")
	public void PurchaseOrderFillDetails() throws InterruptedException, EncryptedDocumentException, IOException
	{
		 gp=new GenericPage(driver);
		 eUtil=new ExcelUtility();
		
		gp.headerModules_selection_campains_to_InvoiceModule("Purchase Order");
		 
		 
		Thread.sleep(1000);
		gp.create_option_campains_to_InvoiceModule();
		try {
		String SUB = eUtil.readDatafromExcelFile("PurchaseOrderPage", 0, 1);
		String QS = eUtil.readDatafromExcelFile("PurchaseOrderPage", 1, 1);
		String  BA= eUtil.readDatafromExcelFile("PurchaseOrderPage", 2, 1);
		String BPO = eUtil.readDatafromExcelFile("PurchaseOrderPage", 3, 1);
		String BCN = eUtil.readDatafromExcelFile("PurchaseOrderPage", 4, 1);
		String BS = eUtil.readDatafromExcelFile("PurchaseOrderPage", 5, 1);
		String BPC = eUtil.readDatafromExcelFile("PurchaseOrderPage", 6, 1);
		String BC = eUtil.readDatafromExcelFile("PurchaseOrderPage", 7, 1);
		String SA = eUtil.readDatafromExcelFile("PurchaseOrderPage", 8, 1);
		String SPB = eUtil.readDatafromExcelFile("PurchaseOrderPage", 9, 1);
		String SCTY = eUtil.readDatafromExcelFile("PurchaseOrderPage", 10, 1);
		String SS = eUtil.readDatafromExcelFile("PurchaseOrderPage", 11, 1);
		String SPC = eUtil.readDatafromExcelFile("PurchaseOrderPage", 12, 1);
		String SCNT = eUtil.readDatafromExcelFile("PurchaseOrderPage", 13, 1);
		
		gp.popup_page_DropdownSelection_searchCampaign_Select(1,"Contact Name", "ContactsPage", 4, 1);
		gp.popup_page_DropdownSelection_searchCampaign_Select(2,"Product Name", "ProductsPage", 0, 1);
		gp.findElementAndFillValue_String("subject", SUB);
		gp.findElementAndFillValue_String("status", QS);
		driver.findElement(By.xpath("//input[@type='date']")).sendKeys("12092027");
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
		
			Thread.sleep(2000);
	}
		catch(Exception e)
		{
			System.out.println("issuecheck"+e);
		}
		gp.SubmitBtn_SubmitDetails();
		Thread.sleep(10000);
	}
	@Test(priority=14,dependsOnGroups = "SalesOrderDelete",groups = "PurchaseOrderDelete")
public void PurchaseOrderDelete() throws EncryptedDocumentException, InterruptedException, IOException
{
	     gp=new GenericPage(driver);
		 eUtil=new ExcelUtility();
		gp.headerModules_selection_campains_to_InvoiceModule("Purchase Order");
		Thread.sleep(2000);
		gp.generic_FilterDropAndSearch("Search by Subject", "PurchaseOrderPage", 0, 1);
		Thread.sleep(2000);
		gp.genericPage_DleteSteps("PurchaseOrderPage", 0, 1);
		Thread.sleep(5000);
		
}
	
}

