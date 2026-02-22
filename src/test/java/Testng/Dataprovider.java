package Testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataprovider 

{
	@Test(dataProvider = "loginDetails")
    public void dataprovider(String un,String pwd)
    {
    	System.out.println(un+"="+pwd);
    }
	
	@DataProvider
	public Object[][] loginDetails()
	{
		Object[][] object =new Object[2][2];
		object[0][0]="sharath";
		object[0][1]="sd";
		object[1][0]="karthik";
		object[1][1]="dr";
		return object;
	}
}
