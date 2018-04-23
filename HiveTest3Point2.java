package automationFramework;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
/*
 * Test 3.2 Test to ensure that "Continue" button does not hold functionality when first and last name 
 * and phone number are given, but no email or password are given
 * @author - Aaron Kranzler
 */

public class HiveTest3Point2  {
    public static void main(String[] args) {
        //create instance of ChromeDriver
     	System.setProperty("webdriver.chrome.driver", "/Users/aaronkranzler/Downloads/chromedriver");
     	WebDriver driver = new ChromeDriver();
        
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        //visit staging website
        driver.get("https:staging.hive.com");
        
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        //find sign up link on first page
        WebElement joinLink = driver.findElement(By.id("join-hive"));
        
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        // click joinLink
        joinLink.click();

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        //find continueButton on next page
        WebElement continueButton = driver.findElement(By.cssSelector(".hv.btn.btn-primary.js-ob-video-continue"));

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        //click continueButton to get to next page asking for email and name etc.
        continueButton.click();

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        WebElement firstNameBox = driver.findElement(By.id("firstName"));

        WebElement lastNameBox = driver.findElement(By.id("lastName"));

        WebElement phoneNumberBox = driver.findElement(By.id("phone"));

        firstNameBox.sendKeys("Aaron");

        lastNameBox.sendKeys("Kranzler");

        phoneNumberBox.sendKeys("9999999999");//all input besides email and password are inputted

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        boolean properFunctionality = true;
        try{ 
            WebElement continueWithOutInput = driver.findElement(By.cssSelector(".hv.btn.btn-primary.ladda-button.disabled"));//element should be disabled and have this class name
        } catch( NoSuchElementException e ){
            System.out.println("Test 3.2 failed, the \"Continue\" button is enabled even though there is no email or password input");
            properFunctionality = false;
        }

        if(properFunctionality)
        {
            System.out.println("Test 3.2 passed, the \"Continue\" button is disabled because there is no email or password input");
        }
        //Close the browser
        driver.quit();
    }
}