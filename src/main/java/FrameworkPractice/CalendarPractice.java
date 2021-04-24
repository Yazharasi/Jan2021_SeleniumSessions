package FrameworkPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarPractice {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");

		selectaDate("a", "9");
		Thread.sleep(2000);;
		selectaDatefromList("11");

	}

	public static void selectaDate(String locator, String day) {
		driver.findElement(By.id("datepicker")).click();
		driver.findElement(By.xpath("//" + locator + "[text() ='" + day + "']")).click();
	}

	public static void selectaDatefromList(String day) {
		driver.findElement(By.id("datepicker")).click();
		List<WebElement> dates = driver.findElements(By.cssSelector("table.ui-datepicker-calendar a"));
		for (WebElement e : dates) {
			if (e.getText().equals(day)) {
				e.click();
				break;
			}
		}
	}

}
