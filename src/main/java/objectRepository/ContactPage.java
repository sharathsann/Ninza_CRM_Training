package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage 
{

	
	public ContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//h2[.='Contacts']")
	private WebElement validateContactPage;
	
	@FindBy(xpath="//button[.//span[text()='Create Contact']]")
	private WebElement createContactBtn;
	
	@FindBy(xpath = "//select[@class='form-control']")
	private WebElement contactsPageFilterDropdown;
	
	@FindBy(xpath="//input[@placeholder='Search by Contact Name']")
	private WebElement contactsPageSearchFilter;
	
	@FindBy(xpath="//i[@title='Delete']")
	private WebElement contactsDeleteIcon;
	
	@FindBy(xpath="//input[@value='Delete']")
	private WebElement deleteBtnConfirmationFromPopUp;
	

	@FindBy(name="organizationName")
	private WebElement orgTF;
	
	@FindBy(name="title")
	private WebElement titleTF;
	
	@FindBy(name="department")
	private WebElement deptTF;
	
	@FindBy(name="officePhone")
	private WebElement officeNOTF;
	
	@FindBy(name="contactName")
	private WebElement contactNameTF;
	
	@FindBy(name="mobile")
	private WebElement mobileTF;
	
	@FindBy(name="email")
	private WebElement emailTf;
	
	@FindBy(xpath="//button[@type='button']/*[local-name()='svg']") //(xpath="(//button[@type='button'])[2]")
	private WebElement select_campaign_icon;
	
	@FindBy(xpath="//button[.='Create Contact']")
	private WebElement contactcreatesubBTN;
	
	/*
	 * below elements are the popup page elements
	 */
	@FindBy(id="search-criteria")
	private WebElement slectDropdown;
	
	@FindBy(id="search-input")
	private WebElement searchField;
	
	@FindBy(xpath="//tbody/tr[1]/td/button[.='Select']")
	private WebElement selectSearchedCampaignName;
	
	

	public WebElement getValidateContactPage() {
		return validateContactPage;
	}

	
	public WebElement getCreateContactBtn() {
		return createContactBtn;
	}


	public WebElement getContactcreatesubBTN() {
		return contactcreatesubBTN;
	}

	public WebElement getOrgTF() {
		return orgTF;
	}

	public WebElement getTitleTF() {
		return titleTF;
	}

	public WebElement getDeptTF() {
		return deptTF;
	}

	public WebElement getOfficeNOTF() {
		return officeNOTF;
	}

	public WebElement getContactNameTF() {
		return contactNameTF;
	}

	public WebElement getMobileTF() {
		return mobileTF;
	}

	public WebElement getEmailTf() {
		return emailTf;
	}

	public WebElement getSelect_campaign_icon() {
		return select_campaign_icon;
	}


	public WebElement getSlectDropdown() {
		return slectDropdown;
	}


	public WebElement getSearchField() {
		return searchField;
	}


	public WebElement getSelectSearchedCampaignName() {
		return selectSearchedCampaignName;
	}


	public WebElement getContactsPageFilterDropdown() {
		return contactsPageFilterDropdown;
	}


	public WebElement getContactsPageSearchFilter() {
		return contactsPageSearchFilter;
	}


	public WebElement getContactsDeleteIcon() {
		return contactsDeleteIcon;
	}


	public WebElement getDeleteBtnConfirmationFromPopUp() {
		return deleteBtnConfirmationFromPopUp;
	}
	
	
	
}
