package BaseTest;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import genericUtility.PropertiesFileUtility;
import genericUtility.SeleniumUtility;
import objectRepository.HomePage;
import objectRepository.LoginPage;
@Listeners(listnerUtility.ListnerImplementation.class)
public class BaseClass {

    public  WebDriver driver=null;
    public static WebDriver sDriver=null;
    public PropertiesFileUtility plib = new PropertiesFileUtility();
    public SeleniumUtility sUtil = new SeleniumUtility();

    // ✅ Runs ONLY ONCE before all classes
    @BeforeSuite
    public void beforeSuite() throws IOException {

        System.out.println("establish database connectivity");

        String BROWSER = plib.togetDataFromPropertiesFile("Browser");

        if (BROWSER.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        }
        else if (BROWSER.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        }
        else if (BROWSER.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        }
        else {
            throw new RuntimeException("Invalid Browser Name");
        }

        System.out.println("Launching browser = " + BROWSER);
        sDriver=driver;  //listner purpouse
        sUtil.maximizeWindow(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    // ✅ Runs before each test method
    @BeforeMethod
    public void login() throws IOException {

        String URL = plib.togetDataFromPropertiesFile("Url");
        String USERNAME = plib.togetDataFromPropertiesFile("UserName");
        String PASSWORD = plib.togetDataFromPropertiesFile("Password");

        driver.get(URL);

        LoginPage lp = new LoginPage(driver);
        lp.getUsernameTF().sendKeys(USERNAME);
        lp.getPasswordTF().sendKeys(PASSWORD);
        lp.getSigninBtn().click();

        System.out.println("Login done");

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

            WebElement popupOkBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[text()='OK']")
                )
            );

            popupOkBtn.click();

        } catch (Exception e) {
            System.out.println("Password popup not displayed");
        }
    }

    // ✅ Runs after each test method
    @AfterMethod
    public void logout() {

        HomePage hp = new HomePage(driver);
        hp.getUserIcon().click();
        hp.getLogoutBtn().click();

        System.out.println("Logout done");
    }

    // ✅ Runs ONLY ONCE after all execution
    @AfterSuite
    public void afterSuite() {

        driver.quit();

        System.out.println("Browser closed");
        System.out.println("close database connection");
        
    }
}
