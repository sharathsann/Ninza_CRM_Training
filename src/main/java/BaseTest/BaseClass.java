package BaseTest;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import genericUtility.PropertiesFileUtility;
import genericUtility.SeleniumUtility;
import objectRepository.HomePage;
import objectRepository.LoginPage;
@Listeners(listnerUtility.ListnerImplementation.class)

/**
 * 
 */
public class BaseClass {
//Note: jenkins or headless mode don'tuse (maximize) use window size  options.addArguments("--window-size=1920,1080");

	/*
	 * ಸಮಸ್ಯೆ ಏನೆಂದರೆ driver non-static ಆಗಿದ್ದರಿಂದ TestNG ಪ್ರತಿ class ಗೆ ಹೊಸ BaseClass object ಸೃಷ್ಟಿಸಿ 
	 * Contact class ನಲ್ಲಿ driver null ಆಗಿತ್ತು; static ಮಾಡಿದ ನಂತರ ಎಲ್ಲಾ classes ಒಂದೇ
	 *  WebDriver instance share ಮಾಡುತ್ತಿವೆ.
	 */
	/**
	 * If driver is static:
       All tests share same browser
    	If one test closes driver → all tests fail
		Parallel execution ನಲ್ಲಿ problem ಆಗಬಹುದು
		So static = shared browser for whole suite.
	 */
    public  static WebDriver driver; // above Kannada comment Note :static is use when driver.quit or close suite level ,bcz of static key not mensioned multiple driver created so   
    public static WebDriver sDriver; // dont use static driver.quit is in class level. 
    public PropertiesFileUtility plib = new PropertiesFileUtility();
    public SeleniumUtility sUtil = new SeleniumUtility();

    // ✅ Runs ONLY ONCE before all classes
    @BeforeSuite
    public void beforeSuite() throws IOException {

        System.out.println("establish database connectivity");

        String BROWSER = plib.togetDataFromPropertiesFile("Browser");
        // Read headless flag from Maven
        String headless = System.getProperty("headless");//only this one is fine?
        
        		

        if (BROWSER.equalsIgnoreCase("Edge")) {
        	//ChromeOptions options = new ChromeOptions();

           
        	

            
            driver = new EdgeDriver();
        }
        else if (BROWSER.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        }
        else if (BROWSER.equalsIgnoreCase("Chrome")) {
        	ChromeOptions options = new ChromeOptions();
        	if ("true".equalsIgnoreCase(headless)) {
        	    options.addArguments("--headless=new");
        	    options.addArguments("--disable-gpu");
        	    options.addArguments("--window-size=1920,1080");
        	    options.addArguments("--no-sandbox");
        	    options.addArguments("--disable-dev-shm-usage");
        	}
        	HashMap<String, Object> prefs = new HashMap<>();
            prefs.put("profile.password_manager_leak_detection", false);
            prefs.put("credentials_enable_service", false);
            options.setExperimentalOption("prefs", prefs);
            driver = new ChromeDriver(options);
        }
        else {
            throw new RuntimeException("Invalid Browser Name");
        }

        System.out.println("Launching browser = " + BROWSER);
        sDriver=driver;  //listner purpouse
       // sUtil.maximizeWindow(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
   
    // ✅ Runs before each test method
    @BeforeMethod
    public void login() throws IOException {
try {
        String URL = plib.togetDataFromPropertiesFile("Url");
        String USERNAME = plib.togetDataFromPropertiesFile("UserName");
        String PASSWORD = plib.togetDataFromPropertiesFile("Password");

        driver.get(URL);

        LoginPage lp = new LoginPage(driver);
        lp.getUsernameTF().sendKeys(USERNAME);
        lp.getPasswordTF().sendKeys(PASSWORD);
        lp.getSigninBtn().click();

        System.out.println("Login done");
     driver.manage().window().setSize(new Dimension(1920, 1080));
      
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
    public void logout()  {

        HomePage hp = new HomePage(driver);
        SeleniumUtility sUtil=new SeleniumUtility();
     // hp.getUserIcon().click();
       // sUtil.safeClick(driver, hp.getUserIcon());
        //sUtil.mouseHoverAction(driver, hp.getUserIcon());
       // hp.getLogoutBtn().click();
       // sUtil.safeClick(driver,  hp.getLogoutBtn());
        sUtil.hoverAndSafeClick(driver, hp.getUserIcon(), hp.getLogoutBtn());

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
