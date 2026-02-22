package Campaign;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.os.ExecutableFinder;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import genericUtility.ExcelUtility;
import genericUtility.JavaUtility;
import genericUtility.SeleniumUtility;
import objectRepository.CampaignPage;
import objectRepository.HomePage;
@Listeners
public class CampaignTest extends BaseClass {
	
	
	
	@Test(priority=1,groups = "Campaign")
	public void toCreateCampaignWithExpectedDateTest() throws EncryptedDocumentException, IOException, InterruptedException {
		
		
		
		ExcelUtility eutil=new ExcelUtility();
		JavaUtility jutil = new JavaUtility();
		SeleniumUtility sutil=new SeleniumUtility();
		
		Reporter.log("test is executed",true);
		/*
		 * Read TestData
		 */
		
		String  CAMPAIGNNAME = eutil.readDatafromExcelFile("Campaign", 0, 1);
		String  TARGETSIZE = eutil.readDatafromExcelFile("Campaign", 1, 1);
		String  CampaignStatus = eutil.readDatafromExcelFile("Campaign", 2, 1);
		String  TargetAudiance = eutil.readDatafromExcelFile("Campaign", 3, 1);
		String  Description = eutil.readDatafromExcelFile("Campaign", 4, 1);
		Reporter.log("readdata executed"+CAMPAIGNNAME,true);
		
		/*
		 * Picking FeatureDate
		 */
		//String datereq = jutil.dateAndTime(30);
		
		/*
		 * clikc and create campaign
		 */
		HomePage hp= new HomePage(driver);
		CampaignPage cp=new CampaignPage(driver);
		hp.getCreateCampaign().click();
		Reporter.log("readdata executed"+CAMPAIGNNAME,true);

		/*
		 * enter mandatorydetails
		 */
		
		cp.getCampaignNameTF().sendKeys(CAMPAIGNNAME);
		cp.getTargetTF().clear();
		cp.getTargetTF().sendKeys(TARGETSIZE);
		cp.getTargetTF().sendKeys(Keys.BACK_SPACE); 
		
	    /*CampaignStatus
	     * TargetAudiance
	     * Discription
	     * 
	     */
		try
		{
		cp.getStatusTF().sendKeys(CampaignStatus);
		cp.getTargetAudianceTF().sendKeys(TargetAudiance);
		cp.getDescription().sendKeys(Description);
		
		/*
		 * click on create campaign
		 */
		Reporter.log("true" + true, true);
		cp.getCreateCampaignSubmitBtn().click();
		Reporter.log("true"+true);
		}
		catch( Exception e)
		{
			System.out.println(e);
		}
		WebElement toastMsg = cp.getToastmsg();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(toastMsg));
		
		//sutil.waitForVisiblityofElement(driver);
		String msg =toastMsg.getText();
		Thread.sleep(5000);
		Thread.sleep(1000);
		Assert.assertTrue(msg.contains(CAMPAIGNNAME), "Campaign is not created");
		
	}
}
