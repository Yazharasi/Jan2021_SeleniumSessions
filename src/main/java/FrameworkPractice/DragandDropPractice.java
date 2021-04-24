package FrameworkPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragandDropPractice {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("http://demo.guru99.com/test/drag_drop.html");
		Thread.sleep(2000);

		By source = By.xpath("//a[text()=' BANK ']");
		By target = By.xpath("//ol[@class='field14 ui-droppable ui-sortable']/li");

//		action.clickAndHold(source).moveToElement(target).release().build().perform();
		doDragandDrop(source, target);

		Thread.sleep(2000);
		driver.quit();

	}

	public static void doDragandDrop(By sourcelocator, By targetlocator) {
		Actions action = new Actions(driver);
		WebElement source = driver.findElement(sourcelocator);
		WebElement target = driver.findElement(targetlocator);
		action.dragAndDrop(source, target).perform();
	}

}
