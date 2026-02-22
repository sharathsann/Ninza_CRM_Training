package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadPage 
{

	public LeadPage(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//h2[.='Leads']")
	private WebElement validateLeadsPage;
	
	@FindBy(xpath="//button[@class='btn btn-info']")
	private WebElement createleadBTN;
	
	@FindBy(xpath = "//select[@class='form-control']")
	private WebElement leadsPageFilterDropdown;
	
	@FindBy(xpath="//input[@placeholder='Search by Lead Name']")
	private WebElement leadsPageSearchFilter;
	
	@FindBy(xpath="//i[@title='Delete']")
	private WebElement LeadsDeleteIcon;
	
	@FindBy(xpath="//input[@value='Delete']")
	private WebElement deleteBtnConfirmationFromPopUp;
	
	@FindBy(name="name")
	private WebElement leadName;
	
	@FindBy(name="company")
	private WebElement company;
	
	@FindBy(name="leadSource")
	private WebElement leadSource;
	
	@FindBy(name="industry")
	private WebElement industry;
	
	@FindBy(name="annualRevenue")
	private WebElement annualRevenue;
	
	@FindBy(name="noOfEmployees")
	private WebElement noOfEmployees;
	
	@FindBy(name="phone")
	private WebElement phone;
	
	@FindBy(name="email")
	private WebElement email;
	
	@FindBy(name="secondaryEmail")
	private WebElement secondaryEmail;
	
	@FindBy(name="leadStatus")
	private WebElement leadStatus;
	
	@FindBy(name="rating")
	private WebElement rating;
	
	@FindBy(name="assignedTo")
	private WebElement assignedTo;
	
	@FindBy(name="address")
	private WebElement address;
	
	@FindBy(name="city")
	private WebElement city;
	
	@FindBy(name="country")
	private WebElement country;
	
	@FindBy(name="postalCode")
	private WebElement postalCode;
	
	@FindBy(name="website")
	private WebElement website;
	
	@FindBy(xpath="//button[@type='button']/*[local-name()='svg']")
	private WebElement select_campaign_icon;
	
	@FindBy(name="description")
	private WebElement description;
	
	@FindBy(xpath="//button[.='Create Lead']")
	private WebElement LeadcreatesubBTN;

	/*
	 * below elements are the popup page elements
	 */
	@FindAll({
        @FindBy(id="search-criteria"),
        @FindBy(id="search-field")
    })
	private WebElement slectDropdown;
	
	@FindBy(id="search-input")
	private WebElement searchField;
	
	@FindBy(xpath="//tbody/tr[1]/td/button[.='Select']")
	private WebElement selectSearchedLeadName;
	
	public WebElement getCreateleadBTN() {
		return createleadBTN;
	}

	public WebElement getLeadsPageFilterDropdown() {
		return leadsPageFilterDropdown;
	}

	public WebElement getLeadsPageSearchFilter() {
		return leadsPageSearchFilter;
	}

	public WebElement getLeadName() {
		return leadName;
	}

	public WebElement getCompany() {
		return company;
	}

	public WebElement getLeadSource() {
		return leadSource;
	}

	public WebElement getIndustry() {
		return industry;
	}

	public WebElement getAnnualRevenue() {
		return annualRevenue;
	}

	public WebElement getNoOfEmployees() {
		return noOfEmployees;
	}

	public WebElement getPhone() {
		return phone;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getSecondaryEmail() {
		return secondaryEmail;
	}

	public WebElement getLeadStatus() {
		return leadStatus;
	}

	public WebElement getRating() {
		return rating;
	}

	public WebElement getAssignedTo() {
		return assignedTo;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getCity() {
		return city;
	}

	public WebElement getCountry() {
		return country;
	}

	public WebElement getPostalCode() {
		return postalCode;
	}

	public WebElement getWebsite() {
		return website;
	}

	public WebElement getSelect_campaign_icon() {
		return select_campaign_icon;
	}

	public WebElement getDescription() {
		return description;
	}

	public WebElement getLeadcreatesubBTN() {
		return LeadcreatesubBTN;
	}

	public WebElement getValidateLeadPage() {
		return validateLeadsPage;
	}

	public WebElement getValidateLeadsPage() {
		return validateLeadsPage;
	}


	public WebElement getSlectDropdown() {
		return slectDropdown;
	}

	public WebElement getSearchField() {
		return searchField;
	}

	public WebElement getSelectSearchedCampaignName() {
		return selectSearchedLeadName;
	}


	public WebElement getSelectSearchedLeadName() {
		return selectSearchedLeadName;
	}
	public WebElement getLeadsDeleteIcon() {
		return LeadsDeleteIcon;
	}

	public WebElement getDeleteBtnConfirmationFromPopUp() {
		return deleteBtnConfirmationFromPopUp;
	}
	

}
