package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.ExcelUtility;

public class HomePage {
	
	public  HomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(linkText="Campaign")
	private WebElement campaignlink;
	
	@FindBy(linkText="Leads")
	private WebElement LeadPagelink;
	
	@FindBy(xpath="//button[.//span[text()='Create Campaign']]")
	private WebElement createCampaign;
	
	@FindBy(className="user-icon")
	private WebElement userIcon;
	
	@FindBy(xpath="(//div[@class='dropdown'])/div[3]")//(xpath="//div[@class='dropdown-item logout']")
	private WebElement logoutBtn;
	
	@FindBy(xpath="//tr[td[text()='BharathTestCampaign']]//a[@class='delete']")
	private WebElement deleteCampaignBtn;
	
	@FindBy(xpath="//div[@id='deleteProductModal']//input[@value='Delete']")
	private WebElement deleteConfirmationPopupBtn;
	
	@FindBy(xpath="//div[contains(text(),'Successfully Added')]|//div[role='alert']")
	private WebElement Success_added_popup;
	
	@FindBy(xpath="//div[contains(text(),'Successfully Deleted')]|//div[role='alert']")
	private WebElement Success_deleted_popup;
	
	@FindBy(linkText="Contacts")
	private WebElement Contacts_Btn_topicon;
	
	
	public WebElement getContacts_Btn_topicon() {
		return Contacts_Btn_topicon;
	}

	public WebElement getSuccess_added_popup() {
		return Success_added_popup;
	}

	public WebElement getSuccess_deleted_popup() {
		return Success_deleted_popup;
	}
	
	public WebElement getDeleteConfirmationPopupBtn() {
		return deleteConfirmationPopupBtn;
	}

	public WebElement getDeleteCampaignBtn() {
		return deleteCampaignBtn;
	}

	public WebElement getCampaignlink() {
		return campaignlink;
	}

	public WebElement getCreateCampaign() {
		return createCampaign;
	}

	public WebElement getUserIcon() {
		return userIcon;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

	public WebElement getLeadPagelink() {
		return LeadPagelink;
	}

}
