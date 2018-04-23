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
 * Test to ensure that "Continue" button attains functionality and routes to new page
 * with input
 * @author - Aaron Kranzler
 */
public class HiveTest5Point2  {
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
        
        WebElement continueButton3 = driver.findElement(By.cssSelector(".hv.btn.btn-primary.js-complete-step.ladda-button"));
        
        continueButton3.click();//click to go to next page
        
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        
        WebElement firstItemBox = driver.findElement(By.cssSelector("[data-index='0']"));

        firstItemBox.sendKeys("make coffee");

        WebElement secondItemBox = driver.findElement(By.cssSelector("[data-index='1']"));

        secondItemBox.sendKeys("read email");

        WebElement thirdItemBox = driver.findElement(By.cssSelector("[data-index='2']"));

        thirdItemBox.sendKeys("Do weekly report");
        
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        
        String currentPage = driver.getPageSource();//to be compared to test if page changes
        
        int size = driver.findElements(By.xpath("//button[@form='onboardingCardActionsForm']")).size();//ElementNotVisibleException thrown otherwise
        
        WebElement continueButton4 = driver.findElements(By.xpath("//button[@form='onboardingCardActionsForm']")).get(size-1);
      	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("ERROR");
		}
        continueButton4.click();
        
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
        String nextPage = driver.getPageSource();
        
        if(!nextPage.equals(currentPage))
        {
            System.out.println("Test 5.2 passed, the continue button routed to a new page with input");
        }
        else
        {
            System.out.println("Test 5.2 failed, the continue button did not route to a new page, with input");
        }

        driver.quit();
    }
}