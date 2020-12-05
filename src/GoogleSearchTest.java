import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleSearchTest {
	
	public static void main(String[] args) throws InterruptedException {
		
	WebDriver driver = new FirefoxDriver();
	
	
	
	driver.get("http://google.com/");
	
	Thread.sleep(3000);
	
	driver.findElement(By.name("q")).sendKeys("java");
	
	Thread.sleep(5000);
	
	
	List<WebElement> elements=driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbl1']"));
	
	System.out.println(elements.size());
	
	for(int i=0;i<elements.size();i++) {
		System.out.println(elements.get(i).getText());
		if(elements.get(i).getText().equals("javascript")) {
			elements.get(i).click();
			break;
		}
	}
	
	
}
}