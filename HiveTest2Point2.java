package automationFramework;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
/*
 * Test to ensure that the "Continue" button 
 * works and takes user to next page
 * @author - AaronKranzler
 */
public class HiveTest2Point2  {
    public static void main(String[] args) {
        
      	System.setProperty("webdriver.chrome.driver", "/Users/aaronkranzler/Downloads/chromedriver");
     	WebDriver driver = new ChromeDriver();
        
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        
        driver.get("https://staging.hive.com/signin");
        
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
       
        WebElement joinLink = driver.findElement(By.id("join-hive"));
        
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        // click join link to get to next page
        joinLink.click();

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        String currentPage = driver.getPageSource();

        WebElement continueButton = driver.findElement(By.cssSelector(".hv.btn.btn-primary.js-ob-video-continue"));

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        continueButton.click();

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        String nextPage = driver.getPageSource();
        //comparing source code of each page to ensure that page has changed
        if(currentPage.equals(nextPage))
            System.out.println("Test 2.2 failed, the click of the Continue button did not redirect to proper page");
        else
            System.out.println("Test 2.2 passed");
        
       
     
        //Close the browser
        driver.quit();
    }
}
