package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	

	
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="username")
	private WebElement UsernameTF;
	
	@FindBy(id="inputPassword")
	private WebElement PasswordTF;
	
	@FindBy(xpath="//button[.='Sign In']")
	private WebElement SigninBtn;
	
	public WebElement getUsernameTF() {
		return UsernameTF;
	}

	public WebElement getPasswordTF() {
		return PasswordTF;
	}

	public WebElement getSigninBtn() {
		return SigninBtn;
	}

	
	
	
}
