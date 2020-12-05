import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ScrollDemoTest {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		
		// Pass application URL
		 
		driver.get("http://manos.malihu.gr/repository/custom-scrollbar/demo/examples/complete_examples.html");
		 
		 
		 
		// Create instance of Javascript executor
		 
		JavascriptExecutor je = (JavascriptExecutor) driver;
		 
		 
		 
		//Identify the WebElement which will appear after scrolling down
		 
		WebElement element = driver.findElement(By.xpath(".//*[@id='mCSB_4_container']/p[3]"));
		 
		 
		 
		// now execute query which actually will scroll until that element is not appeared on page.
		 
		je.executeScript("arguments[0].scrollIntoView(true);",element);
		 
		 
		 
		// Extract the text and verify the elements
		 
		System.out.println(element.getText());
		 
		}
	}

