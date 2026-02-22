package Testng;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestNg 
{
   @Test()
	public void Apple()
	{
		System.out.println("apple");;
	}
   @Test()
	public void Mango()
	{
		Reporter.log("mango",true);
	}
   @Test()
	public void banana()
	{
		Reporter.log("banana",true);
	}
   @Test()
	public void Grapes()
	{
		Reporter.log("grapes",true);
	}
	
}
