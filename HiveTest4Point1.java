package automationFramework;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
/*
 * Test to ensure that "Continue" button is disabled when no 
 * organization name is inputted
 * @author - Aaron Kranzler
 */
public class HiveTest4Point1  {
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
        
        passwordBox.sendKeys("1234567");//valid password

        int randomEmailCode = (int)(Math.random() * 10000);
        String email = randomEmailCode + "@gmail.com";
        emailBox.sendKeys(email);//valid email
        
        WebElement continueButton2 = driver.findElement(By.cssSelector(".hv.btn.btn-primary.ladda-button"));

        continueButton2.click();

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        
        WebElement continueButton3 = driver.findElement(By.cssSelector(".hv.btn.btn-primary.js-complete-step.ladda-button"));
        //Note: there is no organization name input 
        if(continueButton3.isEnabled())
        {
            System.out.println("Test 4.1 failed, the continue button is enabled even though there is no organization name inputted");
        }
        else
        {
            System.out.println("Test 4.1 passed, the continue button is disabled because there is no organization name inputted");
        }
        //Close the browser
        driver.quit();
    }
}
        
        
