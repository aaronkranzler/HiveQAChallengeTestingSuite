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
 * Tests to ensure appearance of error display when an email already in use 
 * is inputted
 * @author - Aaron Kranzler
 */
public class HiveTest3Point10  {
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
        
        emailBox.sendKeys("aaron.kranzler@gmail.com");//EXISITING EMAIL

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        WebElement continueButton2 = driver.findElement(By.cssSelector(".hv.btn.btn-primary.ladda-button"));//prompts the error message

        continueButton2.click();//clicked to prompt message

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        boolean properFunctionality = true;
        try{ 
            WebElement testElement = driver.findElement(By.cssSelector(".input.error"));//this is the reddening of the email box that occurs when an email is already in use
        } catch(Exception e ){
            System.out.println("Test 3.10 failed, the Invalid email error isn't displayed even though the email is already used");
            properFunctionality = false;
        }

        if(properFunctionality)
        {
            System.out.println("Test 3.10 passed, the Invalid email error is displayed because the email is already used");
        }

       
        //Close the browser
        driver.quit();
    }
}