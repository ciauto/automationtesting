package smoke;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC001verifyLogin {
	
			WebDriver driver;

		@BeforeMethod
		public void setup() {
			System.setProperty("webdriver.chrome.driver", "c:\\driver\\chromedriver.exe");
			
			driver = new ChromeDriver();
			driver.get("http://zero.webappsecurity.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	
	
		@Test
		public void verifylogin() {
	
		// TODO Auto-generated method stub				
		//setting up the chrome browser driver
		
		
		driver.findElement(By.id("signin_button")).click();
		driver.findElement(By.id("user_login")).sendKeys("username");
		driver.findElement(By.id("user_password")).sendKeys("passwor");
		driver.findElement(By.name("submit")).click();
		String actualTitle=driver.getTitle();
		
		String expectedTitle = "Zero - Account Summary";
		Assert.assertEquals(actualTitle, expectedTitle);
		
			
		}
		
		@AfterMethod
		public void tearDown() {
			driver.quit();
		}
		
		

		
		
		
		
		
		
		
	}


