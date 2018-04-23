package automationFramework;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
/*
 * Test 1: Test to ensure the proper functionality
 * of the "Join Hive" link on the staging webpage
 * @author - AaronKranzer
 */
public class HiveTest1  {
    public static void main(String[] args) {
        
      	System.setProperty("webdriver.chrome.driver", "/Users/aaronkranzler/Downloads/chromedriver");
     	WebDriver driver = new ChromeDriver();
        
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
       
        driver.get("https:staging.hive.com");
       
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        //find the link
        WebElement element = driver.findElement(By.id("join-hive"));

        String currentPage = driver.getPageSource();
        
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        // click link
        element.click();

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        //nextPage will be used to test if button went to next page
        String nextPage = driver.getPageSource(); 

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);


        if(currentPage.equals(nextPage))
            System.out.println("The test failed, the click of the JoinHere button did not redirect to proper page");
        else
            System.out.println("Test 1 passed");
        
     
        
        //Close the browser
        driver.quit();
    }
}