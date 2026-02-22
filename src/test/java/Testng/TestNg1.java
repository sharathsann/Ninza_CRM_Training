package Testng;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtility.SeleniumUtility;

public class TestNg1 {

    WebDriver driver = new ChromeDriver();
    SeleniumUtility sUtil;

    @Test
    public void getLowestMobiles() throws InterruptedException {

        sUtil = new SeleniumUtility();
        sUtil.addImplicitlywait(driver);

        driver.get("https://www.amazon.in/s?k=mobiles");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        List<WebElement> products = driver.findElements(
                By.xpath("//div[@data-component-type='s-search-result']")
        );

        // ✅ Use TreeMap (Price as Key → Sorted automatically)
        TreeMap<Integer, String> priceMap = new TreeMap<>();

        for (WebElement product : products) {

            try {
                String name = product.findElement(
                        By.xpath(".//h2//span")
                ).getText();

                String priceText = product.findElement(
                        By.xpath(".//span[@class='a-price-whole']")
                ).getText();

                int price = Integer.parseInt(priceText.replace(",", ""));

                priceMap.put(price, name);

            } catch (Exception e) {
                // skip if no price
            }
        }

        System.out.println("Top 5 Strict Lowest Price Mobiles:\n");

        int count = 0;

        for (Map.Entry<Integer, String> entry : priceMap.entrySet()) {

            System.out.println("Price : ₹" + entry.getKey());
            System.out.println("Mobile: " + entry.getValue());
            System.out.println("---------------------");

            count++;

            if (count == 5)
                break;
        }

        driver.quit();
    }
    @Test
    public void validateMRPRange() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/s?k=mobiles&sort=price-asc-rank");
        driver.manage().window().maximize();

        Thread.sleep(5000); // wait for page load

        List<WebElement> products = driver.findElements(
                By.xpath("//div[@data-component-type='s-search-result']")
        );

        System.out.println("Total products found: " + products.size());

        long minRange = 1L;
        long maxRange = 100000000000L;

        for (WebElement product : products) {

            try {

                String mobileName = product.findElement(By.xpath(".//h2//span")).getText();

                List<WebElement> priceElements =
                        product.findElements(By.xpath(".//span[@class='a-price-whole']"));

                if (priceElements.isEmpty())
                    continue;

                String priceText = priceElements.get(0).getText();

                if (priceText.trim().isEmpty())
                    continue;

                long price = Long.parseLong(priceText.replace(",", ""));

                if (price == 0)
                    continue;

                // ✅ Filter only touchscreen smartphones
                String nameLower = mobileName.toLowerCase();

                boolean isSmartphone =
                        (mobileName.contains("GB") ||
                         
                         nameLower.contains("5g") ||
                         nameLower.contains("4g")) &&

                        !nameLower.contains("keypad") &&
                        !nameLower.contains("screen protector") &&
                        !nameLower.contains("earbuds") &&
                        !nameLower.contains("cover") &&
                        !nameLower.contains("case") &&
                        !nameLower.contains("pouch") &&
                        !nameLower.contains("ring") &&
                        !nameLower.contains("guard") &&
                        !nameLower.contains("compatible") &&
                        !nameLower.contains("dialer");

                if (!isSmartphone)
                    continue;

                // ✅ PRINT HERE
                System.out.println("Mobile: " + mobileName);
                System.out.println("Price : ₹" + price);
                System.out.println("---------------------------");

                Assert.assertTrue(
                        price >= minRange && price <= maxRange,
                        "Invalid price found for " + mobileName
                );

            } catch (Exception e) {
                // skip invalid blocks
            }
        }

        driver.quit();
    }
}




