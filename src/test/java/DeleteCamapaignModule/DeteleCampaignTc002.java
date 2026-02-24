package DeleteCamapaignModule;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import genericUtility.ExcelUtility;
import objectRepository.GenericPage;
import objectRepository.HomePage;

public class DeteleCampaignTc002 extends BaseClass
{ 
	//@Test(priority=20)
   public void deleteCampaign() throws InterruptedException, EncryptedDocumentException, IOException
   {
	   HomePage hp=new HomePage(driver);
	   hp.getDeleteCampaignBtn().click();
	   Thread.sleep(2000);
	   try {
	   hp.getDeleteConfirmationPopupBtn().click();
	   }
	   catch(Exception e)
	   {
		   Reporter.log("confirmation popup issue"+e,true);
	   }
	   ExcelUtility eutil=new ExcelUtility();
	   String  CAMPAIGNNAME = eutil.readDatafromExcelFile("Campaign", 0, 1);
	   WebElement toastMsg = hp.getSuccess_deleted_popup();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(toastMsg));
		
		//sutil.waitForVisiblityofElement(driver);
		String msg =toastMsg.getText();
		Thread.sleep(5000);
		
		if(msg.contains(CAMPAIGNNAME))
		{
			Reporter.log(msg, true);
			
		}
		else
		{
			System.out.println("campaign is not deleted");
		}
   }
	@Test(priority=20,dependsOnGroups = "deleteContact")
		public void campaignDelete() throws EncryptedDocumentException, InterruptedException, IOException
		  {
			     GenericPage gp = new GenericPage(driver);
				 ExcelUtility eUtil = new ExcelUtility();
				gp.headerModules_selection_campains_to_InvoiceModule("Campaigns");
				Thread.sleep(2000);
				gp.generic_FilterDropAndSearch("Search by Campaign Name", "Campaign", 0, 1);
				Thread.sleep(2000);
				gp.genericPage_DleteSteps("Campaign", 0, 1);
				Thread.sleep(5000);
				
		  }
		
	}

