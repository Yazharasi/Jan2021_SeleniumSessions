package FrameworkPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementWaits {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/index.html");

		By locator = By.name("username");

		waitForElementToBeClickable(locator, 5).sendKeys("Test");

		By locators = By.cssSelector("section#footer ul a");
		List<WebElement> linkList = waitForElementsVisibility(locators, 5);
		for (WebElement e : linkList) {
			System.out.println(e.getText());
		}

		By imglocator = By.tagName("img");
		System.out.println("The total image count is: " + waitForElementsVisibility(imglocator, 5).size());

	}

	public static WebElement waitForElementPresent(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}

	public static WebElement waitForElementVisibility(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}

	public static List<WebElement> waitForElementsPresent(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));

	}

	public static List<WebElement> waitForElementsVisibility(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));

	}

	public static WebElement waitForElementToBeClickable(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.elementToBeClickable(locator));

	}

	public static void clickWhenReady(By locator, int timeout) {
		waitForElementToBeClickable(locator, timeout).click();

	}

}
