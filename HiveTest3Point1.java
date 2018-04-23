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
 * Test 3.1: Test to ensure that "Continue" button does not 
 * hold functionality when no input is given
 * @author - Aaron Kranzler
 */
public class HiveTest3Point1  {
    public static void main(String[] args) {
        //setup Chrome Driver
      	System.setProperty("webdriver.chrome.driver", "/Users/aaronkranzler/Downloads/chromedriver");
     	WebDriver driver = new ChromeDriver();
        
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        //access staging website
        driver.get("https:staging.hive.com");
       
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        
        WebElement joinLink = driver.findElement(By.id("join-hive"));
        
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        //click join link to get to next page
        joinLink.click();

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        
        WebElement continueButton = driver.findElement(By.cssSelector(".hv.btn.btn-primary.js-ob-video-continue"));

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        //click continueButton to get to next page
        continueButton.click();

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        //no input is given whatsoever
        boolean properFunctionality = true;
        try{ 
            WebElement continueWithOutInputButton = driver.findElement(By.cssSelector(".hv.btn.btn-primary.ladda-button.disabled"));//the button should still be disabled and have this class name
        }catch(NoSuchElementException e){
            System.out.println("Test 3.1 failed, the \"Continue\" button is enabled even though there is not any input");
            properFunctionality = false;
        }

        if(properFunctionality)
        {
            System.out.println("Test 3.1 passed, the \"Continue\" button is disabled because there is no input");
        }
        //Close the browser
        driver.quit();
    }
}