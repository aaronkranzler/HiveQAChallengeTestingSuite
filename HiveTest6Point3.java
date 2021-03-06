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
 * Test to ensure that "Continue" button is enabled when valid input is given
 * @author - Aaron Kranzler
 */
public class HiveTest6Point3  {
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
        
        int size = driver.findElements(By.xpath("//button[@form='onboardingCardActionsForm']")).size();//ElementNotVisibleException thrown otherwise
        
        WebElement continueButton4 = driver.findElements(By.xpath("//button[@form='onboardingCardActionsForm']")).get(size-1);
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("ERROR");
		}
        continueButton4.click();
        
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("ERROR");
		}

        int size1 = driver.findElements(By.xpath("//input[@data-index='0']")).size();//ElementNotVisibleException thrown otherwise
        WebElement firstEmailBox = driver.findElements(By.xpath("//input[@data-index='0']")).get(size1-1);
        
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("ERROR");
		}
        firstEmailBox.sendKeys("validemail");//valid email
        
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("ERROR");
		}

        int size2 = driver.findElements(By.xpath("//input[@data-index='1']")).size();//ElementNotVisibleException thrown otherwise
        WebElement secondEmailBox = driver.findElements(By.xpath("//input[@data-index='1']")).get(size2-1);

        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("ERROR");
		}
        secondEmailBox.sendKeys("anothervalidemail@gmail.com");//valid email
        
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("ERROR");
		}
        int size3 = driver.findElements(By.xpath("//input[@data-index='2']")).size();//ElementNotVisibleException thrown otherwise
        WebElement thirdEmailBox = driver.findElements(By.xpath("//input[@data-index='2']")).get(size3-1);

        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("ERROR");
		}
        thirdEmailBox.sendKeys("athirdvalidemail@gmail.com");//valid email

        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("ERROR");
		}
        
        WebElement continueButton5 = driver.findElement(By.cssSelector(".hv.btn.btn-primary.ob-team-continue"));
        		
        if(continueButton5.isEnabled())
        {
            System.out.println("Test 6.3 passed, the continue button is enabled because there is valid input");
        }
        else
        {
            System.out.println("Test 6.3 failed, the continue button is disabled even though there is valid input");
        }

        driver.quit();
    }
}
