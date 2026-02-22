package products;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import genericUtility.ExcelUtility;
import genericUtility.SeleniumUtility;
import objectRepository.GenericPage;


public class ProductsTest  extends BaseClass{
	GenericPage gp;
	 ExcelUtility eUtil;
	 SeleniumUtility sUtil;
  @Test(priority =5,groups = "Products",dependsOnGroups = "Opportunities")
	public void productFillDetails() throws InterruptedException, EncryptedDocumentException, IOException
	{
		 gp=new GenericPage(driver);
		 eUtil=new ExcelUtility();
		  sUtil=new SeleniumUtility();
		
		gp.headerModules_selection_campains_to_InvoiceModule("Products");
		 
		 
		Thread.sleep(1000);
		gp.create_option_campains_to_InvoiceModule();
		try {
		String Product_Name = eUtil.readDatafromExcelFile("ProductsPage", 0, 1);
		String Qty = eUtil.readDatafromExcelFile("ProductsPage", 1, 1);
		String price = eUtil.readDatafromExcelFile("ProductsPage", 2, 1);
		
		gp.findElementAndFillValue_String("productName", Product_Name);
		gp.findElementAndFillValue_Int("quantity", Qty);
		gp.findElementAndFillValue_Int("price",price);
		WebElement selectCat = driver.findElement(By.xpath("(//select)[1]"));
		sUtil.handleDropDownByVisibleText(selectCat, "Others");
		WebElement selectVendor = driver.findElement(By.xpath("(//select)[2]"));
		sUtil.handleDropDownByVisibleText(selectVendor, "vendor1 - (Electronics)");
		gp.SubmitBtn_SubmitDetails();
		
		
		}
		
		catch(Exception e)
		{
			System.out.println("issuecheck"+e);
		}
		
	
		Thread.sleep(5000);
	}
	@Test(priority=16,dependsOnGroups = "QuoteDelete",groups = "productDelete")
  public void productDelete() throws EncryptedDocumentException, InterruptedException, IOException
  {
	     gp=new GenericPage(driver);
		 eUtil=new ExcelUtility();
		gp.headerModules_selection_campains_to_InvoiceModule("Products");
		
		gp.generic_FilterDropAndSearch("Search by Product Name", "ProductsPage", 0, 1);
		
		gp.genericPage_DleteSteps("ProductsPage", 0, 1);
		
  }
	
}

