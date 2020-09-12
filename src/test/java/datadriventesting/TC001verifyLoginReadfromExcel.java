package datadriventesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC001verifyLoginReadfromExcel {
	
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
		public Object[][] passdata() throws IOException{
		
			File src = new File("C:\\eclipse-workspace-201906\\automationtesting\\src\\test\\resources\\exceldata\\TestData.xlsx");
			//load the file
			FileInputStream fis = new FileInputStream(src);
			//load workbook from the excel file
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			//loading the sheet 1 ( "0" is index of first sheet)
			XSSFSheet sheet = wb.getSheetAt(0);
			
			int rowCount=sheet.getLastRowNum();
			System.out.println(rowCount);
			
			int rows = rowCount + 1;
			System.out.println(rows);
			
			Object[][] data = new Object[rows][2];
			
			for(int i=1; i<rows; i++) {
				data[i][0]=sheet.getRow(i).getCell(0).getStringCellValue();
				data[i][1]=sheet.getRow(i).getCell(1).getStringCellValue();
			}
			
			return data;
			
		
			
			
		}

		
		
		
		
		
		
		
	}


