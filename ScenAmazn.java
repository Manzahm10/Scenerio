package Scenerio;


import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScenAmazn {
	public static void main(String[] args) throws Throwable {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Manzoor Ahamed\\eclipse-workspace\\Selenium\\drivers\\chromedriver76.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");

		WebElement ser = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		ser.sendKeys("Iphone x");

		Robot e=new Robot();
		e.keyPress(KeyEvent.VK_ENTER);
		e.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();

		String one = driver.getWindowHandle();
		Set<String> second = driver.getWindowHandles();

		for (String a : second) {

			if (!one.equals(a)) {
				driver.switchTo().window(a);
			}

		}
		
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		
		WebElement element = driver.findElement(By.xpath("(//span[@class='a-color-price hlb-price a-inline-block a-text-bold'])[1]"));
		String text = element.getText();
		System.out.println(text);
		
		driver.quit();

	}
}
