package adminConsole;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import objectRepository.AdminConsolePage;

public class AdminConsoleTest extends BaseClass{

	
	@Test(priority=10,dependsOnGroups = "Invoice",groups = "AdminConsoleTest")
	public void createUser() throws InterruptedException, EncryptedDocumentException, IOException
	{
		AdminConsolePage aConsole=new AdminConsolePage(driver);
		aConsole.createUser();
		Thread.sleep(5000);
		
	}
	@Test(priority=11, groups = "deleteAdminUser",dependsOnGroups ="AdminConsoleTest" )
	public void deleteUser() throws InterruptedException, EncryptedDocumentException, IOException
	{
		AdminConsolePage aConsole=new AdminConsolePage(driver);
		aConsole.deleteUser();
		
	}
	
}
