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
 * Test to ensure tests to ensure that the error message appears when an improper email
 * is given
 * @author - AaronKranzler
 */
public class HiveTest3Point4  {
    public static void main(String[] args) {
        
      	//setup Chrome Driver
      	System.setProperty("webdriver.chrome.driver", "/Users/aaronkranzler/Downloads/chromedriver");
     	WebDriver driver = new ChromeDriver();
        
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        
        driver.get("https:staging.hive.com");
       
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
      
        WebElement joinLink = driver.findElement(By.id("join-hive"));
       
        joinLink.click();

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        WebElement continueButton = driver.findElement(By.cssSelector(".hv.btn.btn-primary.js-ob-video-continue"));

        continueButton.click();

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        WebElement firstNameBox = driver.findElement(By.id("firstName"));

        WebElement lastNameBox = driver.findElement(By.id("lastName"));

        WebElement phoneNumberBox = driver.findElement(By.id("phone"));

        WebElement passwordBox = driver.findElement(By.id("password"));

        WebElement emailBox = driver.findElement(By.id("email"));

        firstNameBox.sendKeys("Aaron");

        lastNameBox.sendKeys("Kranzler");

        phoneNumberBox.sendKeys("9999999999");

        passwordBox.sendKeys("123456");

        emailBox.sendKeys("notvalidemail");//invalid email, this should keep the button disabled

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        
        WebElement continueButtonWithBadInput = driver.findElement(By.cssSelector(".hv.btn.btn-primary.ladda-button"));
        		
        continueButtonWithBadInput.click();
        
        boolean properFunctionality = true;
        try{ 
            WebElement errorDisplay = driver.findElement(By.cssSelector(".input.error"));//this error message should display (the reddening of email box) 
        } catch( NoSuchElementException e ){
            System.out.println("Test 3.4 failed, the \"Continue\" button is enabled and there is no error even though there is invalid email input");
            properFunctionality = false;
        }

        if(properFunctionality)
        {
            System.out.println("Test 3.4 passed, the \"Continue\" button is disabled and there is an error displayed because there is invalid email input");
        }
        //Close the browser
        driver.quit();
    }
}