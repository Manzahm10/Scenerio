package Scenerio;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScenMynt {
	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Manzoor Ahamed\\eclipse-workspace\\Selenium\\drivers\\chromedriver76.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/");

		Robot k = new Robot();
		Thread.sleep(5000);
		
		
		for(int s=0;s<2;s++) {
		k.keyPress(KeyEvent.VK_TAB);
		k.keyRelease(KeyEvent.VK_TAB);
		}
		
		k.keyPress(KeyEvent.VK_ENTER);
		k.keyRelease(KeyEvent.VK_ENTER);
		
		
		Thread.sleep(5000);	
		WebElement ser = driver.findElement(By.xpath("//input[@class='desktop-searchBar']"));
		ser.sendKeys("iphone x");	
		
		k.keyPress(KeyEvent.VK_ENTER);
		k.keyRelease(KeyEvent.VK_ENTER);
		
		
		driver.findElement(By.xpath("//a[text()='iPhone X Case']")).click();

		String onee = driver.getWindowHandle();
		Set<String> second = driver.getWindowHandles();

		for (String n : second) {
			if (!onee.equals(n))
				;
			driver.switchTo().window(n);

		}
		Thread.sleep(5000);

		driver.findElement(By.xpath("//div[text()='ADD TO BAG']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='GO TO BAG']")).click();

		WebElement print = driver.findElement(By.xpath("(//span[text()='634'])[1]"));
		String sd = print.getText();
		System.out.println(sd);
		
		driver.quit();
	}
}
