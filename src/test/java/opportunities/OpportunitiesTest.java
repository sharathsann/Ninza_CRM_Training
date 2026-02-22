package opportunities;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Reporter;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import genericUtility.ExcelUtility;
import objectRepository.GenericPage;


public class OpportunitiesTest  extends BaseClass{
	GenericPage gp;
	 ExcelUtility eUtil;
  @Test(priority =4,dependsOnGroups = "Leads",groups = "Opportunities")
	public void OpportunitiesFillDetails() throws InterruptedException, EncryptedDocumentException, IOException
	{
		 gp=new GenericPage(driver);
		 eUtil=new ExcelUtility();
		
		gp.headerModules_selection_campains_to_InvoiceModule("Opportunities");
		 
		 
		Thread.sleep(1000);
		gp.create_option_campains_to_InvoiceModule();
		try {
		String Opportunity_Name = eUtil.readDatafromExcelFile("OpportunitiesPage", 0, 1);
		String Amount = eUtil.readDatafromExcelFile("OpportunitiesPage", 1, 1);
		String Business_type = eUtil.readDatafromExcelFile("OpportunitiesPage", 2, 1);
		String Assigned_To = eUtil.readDatafromExcelFile("OpportunitiesPage", 3, 1);
		String Next_Step = eUtil.readDatafromExcelFile("OpportunitiesPage", 4, 1);
		String Sales_Stage = eUtil.readDatafromExcelFile("OpportunitiesPage", 5, 1);
		String Probability = eUtil.readDatafromExcelFile("OpportunitiesPage", 6, 1);
		String Description = eUtil.readDatafromExcelFile("OpportunitiesPage", 7, 1);
		gp.findElementAndFillValue_String("opportunityName", Opportunity_Name);
		gp.findElementAndFillValue_String("amount", Amount);
		gp.findElementAndFillValue_String("businessType", Business_type);
		gp.findElementAndFillValue_String("assignedTo", Assigned_To);
		gp.findElementAndFillValue_String("nextStep", Next_Step);
		gp.findElementAndFillValue_String("salesStage", Sales_Stage);
		gp.findElementAndFillValue_String("probability", Probability);
		gp.fillDescription();
		}
		
		catch(Exception e)
		{
			System.out.println("issuecheck"+e);
		}
		Thread.sleep(1000);
		gp.popup_page_DropdownSelection_searchCampaign_Select(1,"Lead Name", "LeadPage", 0, 1);
			Thread.sleep(2000);
		gp.SubmitBtn_SubmitDetails();
		Thread.sleep(5000);
	}
	@Test(priority=17,dependsOnGroups = "productDelete",groups = "OpportunitiesDelete")
  public void OpportunitiesDelete() throws EncryptedDocumentException, InterruptedException, IOException
  {
	     gp=new GenericPage(driver);
		 eUtil=new ExcelUtility();
		gp.headerModules_selection_campains_to_InvoiceModule("Opportunities");
		Thread.sleep(2000);
		gp.generic_FilterDropAndSearch("Search by Opportunity Name", "OpportunitiesPage", 0, 1);
		Thread.sleep(2000);
		gp.genericPage_DleteSteps("OpportunitiesPage", 0, 1);
		Thread.sleep(5000);
		
  }
	
}
