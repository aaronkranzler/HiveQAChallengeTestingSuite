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
 * Test to ensure that continue button is disabled when no password is given 
 * @author - AaronKranzler
 */
public class HiveTest3Point5  {
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

        WebElement emailBox = driver.findElement(By.id("password"));

        firstNameBox.sendKeys("Aaron");

        lastNameBox.sendKeys("Kranzler");

        phoneNumberBox.sendKeys("9999999999");

        int randomEmailCode = (int)(Math.random() * 10000);
        String email = randomEmailCode + "@gmail.com";
        emailBox.sendKeys(email);//valid email
        //NOTE: no password input but all other input is there
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        boolean properFunctionality = true;
        try{ 
            WebElement continueButtonNoPassword = driver.findElement(By.cssSelector(".hv.btn.btn-primary.ladda-button.disabled"));//
        } catch( NoSuchElementException e ){
            System.out.println("Test 3.5 failed, the \"Continue\" button is enabled even though there is no passowrd input");
            properFunctionality = false;
        }

        if(properFunctionality)
        {
            System.out.println("Test 3.5 passed, the \"Continue\" button is disabled because there is no password input");
        }
        //Close the browser
        driver.quit();
    }
}
