package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage 
{

	
		public  CampaignPage(WebDriver driver){
			PageFactory.initElements(driver, this);
		}
		
		
		@FindBy(name="campaignName")
		private WebElement campaignNameTF;
		
		@FindBy(name="campaignStatus")
		private WebElement statusTF;
		
		@FindBy(name="targetSize")
		private WebElement targetTF;
		@FindBy(name="targetAudience")
		private WebElement targetAudianceTF;
		
		


		@FindBy(name="expectedClosedDate")
		private WebElement dateTF;
		
		@FindBy(xpath="//button[.='Create Campaign']")
		private WebElement createCampaignSubmitBtn;
		
		@FindBy(xpath="//div[contains(text(),'Successfully Added')]|//div[role='alert']")
		private WebElement toastmsg;
		
		@FindBy(xpath="//button[@aria-label='closed']")
		private WebElement closemsg;
		
		@FindBy(xpath="//div[.='Description:']//textarea")
		private WebElement description;

		public WebElement getDescription() {
			return description;
		}

		public WebElement getCampaignNameTF() {
			return campaignNameTF;
		}

		public WebElement getStatusTF() {
			return statusTF;
		}

		public WebElement getTargetTF() {
			return targetTF;
		}

		public WebElement getDateTF() {
			return dateTF;
		}

		public WebElement getCreateCampaignSubmitBtn() {
			return createCampaignSubmitBtn;
		}

		public WebElement getToastmsg() {
			return toastmsg;
		}

		public WebElement getClosemsg() {
			return closemsg;
		}
		public WebElement getTargetAudianceTF() {
			return targetAudianceTF;
		}
		
		
		
		
		
		
	}
   
	

