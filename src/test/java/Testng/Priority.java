package Testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Priority 
{
  @Test(priority=1)
	public void add()
	{
		Reporter.log("add",true);
	}
  @Test(priority=2)
	public void sub()
	{
		Reporter.log("sub",true);
	}
  
  @Test(priority=-1)
	public void mul()
	{
		Reporter.log("mul",true);
	}
  
  /**
   * invocation means repetation of the test method
   */
  
  @Test(invocationCount =3)
	public void div()
	{
		Reporter.log("div11",true);
	}
	
  /*
   * threadPoolSize =2 means invocationCount=4 will open in 2 times
   * it is used to esecute the same testcasemultiple timesusing same data parellaly /simultaniously
   *
  
  @Test(invocationCount=4,threadPoolSize =2,enabled =true)
  public void login() throws InterruptedException
  {
	  WebDriver driver = new ChromeDriver();
	  Thread.sleep(2000);
	  driver.close();
	  
  } */
  
  /*
   * dependsonmethods
   */
  @Test(priority=5,enabled=true)
  public void createAccount()
  {
	  Reporter.log("account created",true);
  }
  @Test(priority=6,dependsOnMethods ="createAccount" )
  public void editAccount()
  {
	  Reporter.log("account edited",true);
  }
  @Test(priority=7,dependsOnMethods={"createAccount","editAccount"})
  public void deleteAccount()
  {
	  Reporter.log("account deleted",true);
  }
  
}
