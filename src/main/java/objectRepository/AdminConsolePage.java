package objectRepository;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import genericUtility.ExcelUtility;
import genericUtility.SeleniumUtility;

public class AdminConsolePage {
     WebDriver driver;
	public AdminConsolePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//li['Admin Console'][11]")
	private WebElement AdminConsole_Mouseover;
	
	@FindBy(xpath="//div[normalize-space()='Create User']")
	private WebElement createUser_btn;
	
	@FindBy(xpath="//div[normalize-space()='View Users']")
	private WebElement viewUsers_btn;
	
	@FindBy(xpath="//div[normalize-space()='Configure Email']")
	private WebElement configureEmail_btn;
	
	@FindBy(name ="empName")//li['Admin Console'][11]
	private WebElement userFullName;
	
	@FindBy(name="mobileNo")
	private WebElement mobileTextField;
	
	@FindBy(name="email")
	private WebElement emailTextField;
	
	@FindBy(name="username")
	private WebElement userNameTextField;
	
	@FindBy(name="password")
	private WebElement passwordTextField;
	
	@FindBy(name="dob")
	private WebElement dateOFBirthInput;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement createFinal_submitBtn;
	

	public WebElement getUserFullName() {
		return userFullName;
	}

	public WebElement getMobileTextField() {
		return mobileTextField;
	}

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getUserNameTextField() {
		return userNameTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getDateOFBirthInput() {
		return dateOFBirthInput;
	}

	public WebElement getcreateFinal_submitBtn() {
		return createFinal_submitBtn;
	}
	
	
	public WebElement getAdminConsile_Mouseover() {
		return AdminConsole_Mouseover;
	}

	public WebElement getCreateUser_btn() {
		return createUser_btn;
	}

	public WebElement getViewUsers_btn() {
		return viewUsers_btn;
	}

	public WebElement getConfigureEmail_btn() {
		return configureEmail_btn;
	}

	

	public void createUser() throws InterruptedException, EncryptedDocumentException, IOException
	{
		SeleniumUtility sUtil=new SeleniumUtility();
		ExcelUtility eUtil= new ExcelUtility();
		String userName = eUtil.readDatafromExcelFile("AdminConsolePage", 0, 1);
		String fullName = eUtil.readDatafromExcelFile("AdminConsolePage", 1, 1);
		String password = eUtil.readDatafromExcelFile("AdminConsolePage", 2, 1);
		String dob = eUtil.readDatafromExcelFile("AdminConsolePage", 3, 1);
		String email = eUtil.readDatafromExcelFile("AdminConsolePage", 4, 1);
		String mobileNo = eUtil.readDatafromExcelFile("AdminConsolePage", 5, 1);
        sUtil.waitForElementTobeVisible(driver, AdminConsole_Mouseover);
		
		sUtil.mouseHoverAction(driver,getAdminConsile_Mouseover());
		getCreateUser_btn().click();
		getUserNameTextField().sendKeys(userName);
		getUserFullName().sendKeys(fullName);
		getPasswordTextField().sendKeys(password);
		getDateOFBirthInput().sendKeys(dob);
		getEmailTextField().sendKeys(email);
		getMobileTextField().sendKeys(mobileNo);
		getcreateFinal_submitBtn().click();
		
		
		
	}
	
	public void deleteUser() throws InterruptedException, EncryptedDocumentException, IOException
	{
		SeleniumUtility sUtil=new SeleniumUtility();
		ExcelUtility eUtil= new ExcelUtility();
		GenericPage gp=new GenericPage(driver);
     sUtil.waitForElementTobeVisible(driver, AdminConsole_Mouseover);
		
		sUtil.mouseHoverAction(driver,getAdminConsile_Mouseover());
		getViewUsers_btn().click();
		gp.generic_FilterDropAndSearch("Search by username", "AdminConsolePage", 0, 1);
		gp.genericPage_DleteSteps("AdminConsolePage", 0, 1);
		Thread.sleep(3000);
		
		
	}
	
	
	

}

