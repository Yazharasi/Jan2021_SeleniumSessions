package FrameworkPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SuggestionList {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/");

		By initText = By.id("search_query_top");
		By suggText = By.xpath("//ul/li[starts-with(@class,'ac_')]");

		doSelectTextfromSuggList(initText, suggText, "Dresses", "T-shirts > Faded Short Sleeve T-shirts");

	}

	public static void doSelectTextfromSuggList(By locator1, By locator2, String source, String target)
			throws InterruptedException {
		driver.findElement(locator1).sendKeys(source);
		Thread.sleep(2000);
		List<WebElement> suggList = driver.findElements(locator2);
		for (WebElement e : suggList) {
			String sugg = e.getText();
			if (sugg.equals(target)) {
				e.click();
				System.out.println(driver.getTitle());
				break;
			}
		}

	}

}
