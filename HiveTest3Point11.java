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
 * Tests to ensure that continue button is disabled when no 
 * first and last name or phone number input are given
 * @author - Aaron Kranzler
 */
public class HiveTest3Point11  {
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
        
        WebElement passwordBox = driver.findElement(By.id("password"));

        WebElement emailBox = driver.findElement(By.id("email"));

        passwordBox.sendKeys("1234567");//valid password

        int randomEmailCode = (int)(Math.random() * 10000);
        String email = randomEmailCode + "@gmail.com";
        emailBox.sendKeys(email);//valid email
        //Note: No name or phone number input is given
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        boolean properFunctionality = true;
        try{ 
            WebElement continueWithOutInput = driver.findElement(By.cssSelector(".hv.btn.btn-primary.ladda-button.disabled"));
        } catch( NoSuchElementException e ){
            System.out.println("Test 3.11 failed, the \"Continue\" button is enabled even though there is no name or phone number input");
            properFunctionality = false;
        }

        if(properFunctionality)
        {
            System.out.println("Test 3.11 passed, the \"Continue\" button is disabled because there is no name or phone number input");
        }

       
        //Close the browser
        driver.quit();
    }
}
