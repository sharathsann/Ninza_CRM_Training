package Testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestngPracticeTest {
  @Test(invocationCount =4,threadPoolSize = 1)
  public void TestCase001() {
	  
	  WebDriver driver= new ChromeDriver();
	  driver.close();
	  Reporter.log("Tescase 001 validated ",true);
  }
  @BeforeMethod
  public void beforeMethod() {
	  Reporter.log("Login with valid creds ",true);
   }

  @AfterMethod
  public void afterMethod() {
	  Reporter.log("Logout is Success ",true);
   }

  @BeforeClass
  public void beforeClass() {
	  Reporter.log("launch the browser ",true);
  }

  @AfterClass
  public void afterClass() {
	  Reporter.log("close the browser ",true);
  }

  @BeforeTest
  public void beforeTest() {
	  Reporter.log("pre conditions ",true);
  }

  @AfterTest
  public void afterTest() {
	  Reporter.log("post conditions ",true);
  }

  @BeforeSuite
  public void beforeSuite() {
	  Reporter.log("DB open ",true);
  }

  @AfterSuite
  public void afterSuite() {
	  Reporter.log("DB close ",true);
  }

}
