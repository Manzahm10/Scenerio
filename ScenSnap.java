package Scenerio;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScenSnap {
	public static void main(String[] args) throws AWTException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Ex-drive\\eclipse-workspace\\Mven\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.snapdeal.com/");

		WebElement ser = driver.findElement(By.xpath("//input[@id='inputValEnter']"));
		ser.sendKeys("iphone x");

		Robot e = new Robot();
		e.keyPress(KeyEvent.VK_ENTER);
		e.keyRelease(KeyEvent.VK_ENTER);

		driver.findElement(By.xpath("//p[contains(text(),'iPhone X Soft Silicon Cases WK')]")).click();

		
		String onee = driver.getWindowHandle();
		Set<String> second = driver.getWindowHandles();
		
		for(String n:second)
		{
			if(!onee.equals(n));
			driver.switchTo().window(n);
			
		}
		
		driver.findElement(By.xpath("//div[@id='add-cart-button-id']")).click();
		
		WebElement print = driver.findElement(By.xpath("//span[text()='Rs. 324']"));
		String sd = print.getText();
		System.out.println(sd);
	}
	
	

}
