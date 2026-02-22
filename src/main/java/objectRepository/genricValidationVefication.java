package objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import BaseTest.BaseClass;

public class genricValidationVefication 
{
    WebDriver driver;
	public genricValidationVefication(WebDriver driver) {
	this.driver=driver;
		PageFactory.initElements(driver,this);
	
		
	}
	
	
	@FindBy(xpath="(//tr)[1]")
	private List<WebElement> Headrs_validation;
	
	@FindBy(linkText ="Contacts")
	private WebElement Contact_Link_Btn;

	public  List<WebElement> getHeadrs_validation() {
		return Headrs_validation;
	}

	public WebElement getContact_Link_Btn() {
		return Contact_Link_Btn;
	}
	
	
	public void validateHeaders() throws InterruptedException
	{
		Contact_Link_Btn.click();
		Thread.sleep(2000);
		for(WebElement header : getHeadrs_validation())
		{
			System.out.println(header.getText());
		}
		
	}

}
