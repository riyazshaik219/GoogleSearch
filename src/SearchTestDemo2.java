import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTestDemo2 {

	static FirefoxDriver driver=null;
	static WebDriverWait wait;
	
	//pre requisities
		@BeforeMethod
		public static void setUp() throws Exception{
			
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		Thread.sleep(10000);
		
		}
		
		@Test
		public void AddToCart() throws IOException {
			driver.findElement(By.linkText("Mobiles")).click();
			wait =new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='gwb-mcnc-merchandised-search-11']/div/div[1]/a/img")));
		
		
			//moving forward to select mobile to be added to cart
			driver.findElement(By.xpath("//*[@id='gwb-mcnc-merchandised-search-11']/div/div[1]/a/img")).click();
			wait =new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-to-cart-button")));
			
			//after selection,to press "add to cart"
			driver.findElement(By.id("add-to-cart-button")).click();
			wait =new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-labelledby='attach-sidesheet-view-cart-button-announce']")));
		
			//clicking cart to check the item added in cart
			driver.findElement(By.xpath("//input[@aria-labelledby='attach-sidesheet-view-cart-button-announce']")).click();
			wait =new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Shopping Cart')]")));
		
			//Assertion test to check expected value VS actual value
			String actual =driver.getTitle();
			String expected="Amazon.in Shopping Cart";
			Assert.assertEquals(actual, expected);
		
			//capturing screenshot of the cart window and saving it to the device
			File src=driver.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("D:\\Automation\\GoogleSearch\\Screenshots\\images.png"));
			
		
		}
		//post conditions 
				/*@AfterMethod 
				public void tearDown() {
					driver.quit();
				}*/
}
