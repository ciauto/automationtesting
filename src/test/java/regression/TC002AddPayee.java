package regression;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC002AddPayee {

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
	
		driver.findElement(By.id("signin_button")).click();
		driver.findElement(By.id("user_login")).sendKeys("username");
		driver.findElement(By.id("user_password")).sendKeys("password");
		driver.findElement(By.name("submit")).click();
		
		driver.findElement(By.xpath("//a[@href='/bank/redirect.html?url=pay-bills.html']")).click();
		driver.findElement(By.xpath("//a[@href='#ui-tabs-2']")).click();
		driver.findElement(By.id("np_new_payee_name")).sendKeys("HydroOne Utility");
		driver.findElement(By.id("np_new_payee_address")).sendKeys("200 RoberSpec Pkwy, Mississauga, ON L6R1K9");
		driver.findElement(By.id("np_new_payee_account")).sendKeys("123234434");
		driver.findElement(By.id("np_new_payee_details")).sendKeys("Natural Gas Utility");
		driver.findElement(By.id("add_new_payee")).click();
		String text = driver.findElement(By.id("alert_content")).getText();

		// Assert.assertTrue(text.endsWith("was successfully created."));
		Assert.assertTrue(text.contains("was successfully created."));

			
		}
		
		@AfterMethod
		public void tearDown() {
			driver.quit();
		}
		

		
		
		
		
		
		
		
	}


