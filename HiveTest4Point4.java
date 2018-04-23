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
 * Test to ensure that "Continue" button holds functionality
 * and routes to new page when clicked
 * @author - Aaron Kranzler
 */
public class HiveTest4Point4  {
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
        
        WebElement companyNameBox = driver.findElement(By.cssSelector(".js-workspace-input.input__field"));

        companyNameBox.sendKeys("CompanyName");//input company name
        
        String currentPage = driver.getPageSource();//current page source code to be compared
        
        WebElement continueButton3 = driver.findElement(By.cssSelector(".hv.btn.btn-primary.js-complete-step.ladda-button"));
        
        continueButton3.click();//click to go to next page
        
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        
        String nextPage = driver.getPageSource();
        
        if(currentPage.equals(nextPage))
        {
        		System.out.println("Test 4.4 failed, the Continue button did not route to a new page");
        }
        else
        {
        		System.out.println("Test 4.4 passed, the Continue button routed to a new page");
        }
        //Close the browser
        driver.quit();
    }
}