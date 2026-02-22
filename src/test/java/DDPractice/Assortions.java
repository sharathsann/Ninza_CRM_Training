package DDPractice;

import java.io.IOException;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericUtility.SeleniumUtility;

public class Assortions {
	

@Test
public void hardassort()
{
	String exp = "Google ";
	WebDriver driver=new EdgeDriver();
	driver.get("https://google.com");
	
	
	String actualtitle = driver.getTitle();
	
	
	Assert.assertEquals(actualtitle, exp);
	
	System.out.println(actualtitle);
	driver.quit();
}
@Test
public void softassort()
{
	String exp = "Google ";
	WebDriver driver=new EdgeDriver();
	driver.get("https://google.com");
	
	
	String actualtitle = driver.getTitle();
	
	SoftAssert soft=new SoftAssert();
	soft.assertEquals(actualtitle, exp);
	
	System.out.println(actualtitle);
	
	driver.quit();
	soft.assertAll();
	
}
@Test
public void screenShots() throws IOException
{
	SeleniumUtility sUtil=new SeleniumUtility();
	WebDriver driver=new EdgeDriver();
	driver.get("https://facebook.com");
	
	sUtil.captureScreenShot(driver, "webpagefacebook1");
	driver.quit();
}

  
}
