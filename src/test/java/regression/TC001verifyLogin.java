package regression;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class TC001verifyLogin {
	
			WebDriver driver;
			Logger log=LogManager.getLogger(TC001verifyLogin.class);

		@BeforeMethod
		public void setup() {
			
			System.setProperty("webdriver.chrome.driver", "c:\\driver\\chromedriver.exe");
			
			driver = new ChromeDriver();
			log.info("chrome browser is invoked");
			driver.get("http://zero.webappsecurity.com/");
			log.info("zero banking website is loaded");
			driver.manage().window().maximize();
			log.info("window is maximized");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	
	
		@Test
		public void verifylogin() {
	
		// TODO Auto-generated method stub				
		//setting up the chrome browser driver
		
		
		driver.findElement(By.id("signin_button")).click();
		log.info("sign in button clicked");
		driver.findElement(By.id("user_login")).sendKeys("username");
		log.info("usename entered");
		driver.findElement(By.id("user_password")).sendKeys("password");
		driver.findElement(By.name("submit")).click();
		String actualTitle=driver.getTitle();
		
		String expectedTitle = "Zero - Account Summary";
		Assert.assertEquals(actualTitle, expectedTitle);
		
			
		}
		
		@AfterMethod
		public void tearDown() {
			log.info("closing browser");
			driver.quit();
		}
		
		

		
		
		
		
		
		
		
	}


