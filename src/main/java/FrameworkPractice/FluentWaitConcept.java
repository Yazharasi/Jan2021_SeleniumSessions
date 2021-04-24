package FrameworkPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitConcept {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.freshworks.com/");
		By locator = By.xpath("//a[@title='View All Products']");
		fluentwaitforElementPresence(locator, 5, 200).click();

		By footerlinks = By.cssSelector("div.footer-main a");
		List<WebElement> ele = fluentwaitforElementsPresence(footerlinks, 5, 500);
		for (WebElement e : ele) {
			System.out.println(e.getText());
		}

	}

//	1.FluentWait for WebElement
//	2.FluentWait for WebElements
//	3. FluentWait for Alert
//	4. FluentWait for Frame

	public static WebElement fluentwaitforElementPresence(By locator, int timeout, int interval) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeout))
				.pollingEvery(Duration.ofMillis(interval)).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}

	public static List<WebElement> fluentwaitforElementsPresence(By locator, int timeout, int interval) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeout))
				.pollingEvery(Duration.ofMillis(interval)).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));

	}

	public static Alert fluentwaitforAlertPresence(int timeout, int interval) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeout))
				.pollingEvery(Duration.ofMillis(interval)).ignoring(NoAlertPresentException.class);
		return wait.until(ExpectedConditions.alertIsPresent());

	}

	public static void fluentwaitforFramePresence(String idorname, int timeout, int interval) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeout))
				.pollingEvery(Duration.ofMillis(interval)).ignoring(NoSuchFrameException.class);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(idorname));

	}

	public static void fluentWaitForTitle(int timeout, int interval, String value) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeout))
				.pollingEvery(Duration.ofSeconds(interval));
		wait.until(ExpectedConditions.titleContains(value));

	}

	public static void fluentWaitForUrl(int timeout, int interval, String value) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeout))
				.pollingEvery(Duration.ofSeconds(interval));
		wait.until(ExpectedConditions.urlContains(value));

	}

}
