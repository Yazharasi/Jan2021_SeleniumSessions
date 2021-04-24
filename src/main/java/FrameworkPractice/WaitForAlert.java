package FrameworkPractice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForAlert {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/simple_context_menu.html");

		Actions action = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("//button[contains(text(),'Double')]"));
		action.doubleClick(ele).perform();

		waitForAlertGetTextAndAcceptIt(5);

	}

	public static Alert waitForAlert(int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		return wait.until(ExpectedConditions.alertIsPresent());

	}

	public static String waitForAlertAndGetText(int timeout) {
		return waitForAlert(timeout).getText();

	}

	public static void waitForAlertGetTextAndAcceptIt(int timeout) {
		waitForAlert(timeout).accept();

	}

	public static void waitForAlertAndDismissIt(int timeout) {
		waitForAlert(timeout).dismiss();

	}

}
