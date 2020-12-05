import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AmazonSearchTest {

	static FirefoxDriver driver=null;
	static WebDriverWait wait;
	
	//pre requisities
	@BeforeMethod
	public static void setUp() throws Exception{
		
	driver=new FirefoxDriver();
	driver.get("https://www.amazon.in/");
	Thread.sleep(10000);
	
	}
	
	@Test(priority=1)
	public void productSearchTest() {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
		driver.findElement(By.xpath("//input[@type='submit' and @class='nav-input']")).click();
		System.out.println(driver.getTitle());
	}
		@Test(priority=2)
		public void TestAddToCart() {
	
//selecting Books section		
		
driver.findElementByLinkText("Books").click();
 wait=new WebDriverWait(driver,10);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Fall Again, Rise Again")));

//moving forward to select Book to be added to cart
driver.findElementByLinkText("Fall Again, Rise Again").click();
wait=new WebDriverWait(driver,10);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-to-cart-button")));

//after selection,to press "add to cart"
driver.findElementById("add-to-cart-button").click();
wait=new WebDriverWait(driver,10);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hlb-view-cart-announce")));

//clicking cart to check the item added in cart
driver.findElementById("hlb-view-cart-announce").click();
wait=new WebDriverWait(driver,10);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sc-active-cart")));


//Assertion test to check expected value VS actual value
String Actual1=driver.getTitle();
String Expected1="Amazon.in Shopping Cart";
Assert.assertEquals(Actual1,Expected1);

//capturing screenshot of the cart window and saving it to the device
File srcFile=driver.getScreenshotAs(OutputType.FILE);
File desFile=new File("D:\\Automation\\GoogleSearch\\addToCart.jpg");
try {
	FileUtils.copyFile(srcFile,desFile);
} catch (IOException e) {

	e.printStackTrace();
}

}
		//post conditions 
		@AfterMethod 
		public void tearDown() {
			//driver.quit();
		}
		
		
		
	}

