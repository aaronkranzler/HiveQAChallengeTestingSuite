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
 * Test to ensure that "Continue" button does not hold functionality when first and last name, phone number, 
 * and proper password are given, but no email is given
 * @author - AaronKranzler
 */
public class HiveTest3Point3  {
    public static void main(String[] args) {
       
    	    System.setProperty("webdriver.chrome.driver", "/Users/aaronkranzler/Downloads/chromedriver");
     	WebDriver driver = new ChromeDriver();
        
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
       
        driver.get("https:staging.hive.com");
        
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
       
        WebElement joinLink = driver.findElement(By.id("join-hive"));
        
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        
        joinLink.click();

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        WebElement continueButton = driver.findElement(By.cssSelector(".hv.btn.btn-primary.js-ob-video-continue"));

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        continueButton.click();

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        WebElement firstNameBox = driver.findElement(By.id("firstName"));

        WebElement lastNameBox = driver.findElement(By.id("lastName"));

        WebElement phoneNumberBox = driver.findElement(By.id("phone"));

        WebElement passwordBox = driver.findElement(By.id("password"));

        firstNameBox.sendKeys("Aaron");

        lastNameBox.sendKeys("Kranzler");

        phoneNumberBox.sendKeys("9999999999");

        passwordBox.sendKeys("123456");//all field inputted EXCEPT email

        boolean properFunctionality = true;
        try{ 
            WebElement continueWithOutInput = driver.findElement(By.cssSelector(".hv.btn.btn-primary.ladda-button.disabled"));//button should still be disabled and have this class name
        } catch( NoSuchElementException e ){
            System.out.println("Test 3.3 failed, the \"Continue\" button is enabled even though there is no email input");
            properFunctionality = false;
        }

        if(properFunctionality)
        {
            System.out.println("Test 3.3 passed, the \"Continue\" button is disabled because there is no email input");
        }
        //Close the browser
        driver.quit();
    }
}