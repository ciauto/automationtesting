package datadriventesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC001verifyLoginlocaldata {
	
		WebDriver driver;

		@BeforeMethod
		public void setup() {
			System.setProperty("webdriver.chrome.driver", "c:\\driver\\chromedriver.exe");
			
			driver = new ChromeDriver();
			driver.get("http://zero.webappsecurity.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	
	
		@Test(dataProvider = "logindata")
		public void verifylogin(String uname, String pword) {
	
		// TODO Auto-generated method stub				
		//setting up the chrome browser driver
		
		
		driver.findElement(By.id("signin_button")).click();
		driver.findElement(By.id("user_login")).sendKeys(uname);
		driver.findElement(By.id("user_password")).sendKeys(pword);
		driver.findElement(By.name("submit")).click();
		String actualTitle=driver.getTitle();
		
		String expectedTitle = "Zero - Account Summary";
		Assert.assertEquals(actualTitle, expectedTitle);
		
			
		}
		
		@AfterMethod
		public void tearDown() {
			driver.quit();
		}
		
		
		@DataProvider(name="logindata")
		public Object[][] passdata(){
		//create 2D array name data with 3 rows and 2 column
		Object[][] data = new Object[4][2];
		//we have input data 	
		data[0][0]="username";
		data[0][1]="password";
		
		data[1][0]="Tye";
		data[1][1]="tutorial";	
		
		data[2][0]="Naresh";
		data[2][1]="tutorial";
		
		data[3][0]="username";
		data[3][1]="password";
		
		return data;
		}

		
		
		
		
		
		
		
	}


