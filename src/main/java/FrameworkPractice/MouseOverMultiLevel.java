package FrameworkPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseOverMultiLevel {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://book.spicejet.com/");

		By login = By.id("Login");
		By clubmem = By.xpath("(//ul[@id='menu-list-login']//a)[1]");
		By memlogin = By.xpath("//ul[@id='menu-list-login']//ul//a");
		
		doMouseOver(login);
		doMouseHoverandSelectSubmenu(clubmem, memlogin, "Member Login");

	}

	public static void doMouseOver(By locator) {
		Actions action = new Actions(driver);
		WebElement ele = driver.findElement(locator);
		action.moveToElement(ele).perform();
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
