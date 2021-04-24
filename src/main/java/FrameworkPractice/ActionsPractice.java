package FrameworkPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsPractice {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://mrbool.com/");

		By context = By.xpath("//a[@class='menulink']");
		By locator = By.xpath("//ul[@class='submenu']//a");

		doMouseHoverandSelectSubmenu(context, locator, "ARTICLES");
		driver.get("http://mrbool.com/");
		doMouseHoverandSelectSubmenu(context, locator, "COURSES");
		driver.get("http://mrbool.com/");
		doMouseHoverandSelectSubmenu(context, locator, "SINGLE VIDEOS");

		driver.quit();
	}

	public static void doMouseHoverandSelectSubmenu(By locator1, By locator2, String submenu) {

		Actions action = new Actions(driver);
		WebElement ele = driver.findElement(locator1);

		action.moveToElement(ele).perform();

		List<WebElement> sublist = driver.findElements(locator2);
		for (WebElement e : sublist) {
			if (e.getText().equals(submenu)) {
				e.click();
				System.out.println(driver.getTitle());
				break;
			}
		}

	}

}
