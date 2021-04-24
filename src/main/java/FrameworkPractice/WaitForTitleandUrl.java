package FrameworkPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForTitleandUrl {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.toolsqa.com/");
		driver.findElement(By.xpath("//span[text()='Demo Site']")).click();

		waitForTitleContains(5, "QA");
		System.out.println(driver.getTitle());
		waitForUrlContains(5, "demoqa.com");
		System.out.println(driver.getCurrentUrl());

	}

	public static void waitForTitle(int timeout, String title) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.titleIs(title));
	}

	public static void waitForTitleContains(int timeout, String title) {

		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.titleContains(title));
	}

	public static void waitForUrl(int timeout, String url) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.urlToBe(url));

	}

	public static void waitForUrlContains(int timeout, String url) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.urlContains(url));
	}

}
