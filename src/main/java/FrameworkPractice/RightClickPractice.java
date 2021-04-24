package FrameworkPractice;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RightClickPractice {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/simple_context_menu.html");

		Actions action = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("//span[text()='right click me']"));
		By options = By.xpath("//ul[@class='context-menu-list context-menu-root']/li");

		action.contextClick(ele).perform();
		List<WebElement> elements = driver.findElements(options);

		for (int i = 1; i <= elements.size(); i++) {
			action.contextClick(ele).perform();
			WebElement rightmenu = driver
					.findElement(By.xpath("(//ul[@class='context-menu-list context-menu-root']/li)[" + i + "]"));
			if (!rightmenu.getText().isEmpty()) {
				rightmenu.click();
				WebDriverWait wait = new WebDriverWait(driver, 10);
				Alert alert = wait.until(ExpectedConditions.alertIsPresent());
				System.out.println(alert.getText());
				alert.accept();
			}
		}

		driver.quit();

	}

}
