package FrameworkPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicTablePractice3 {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		driver.get(
				"https://www.espncricinfo.com/series/south-africa-women-in-nz-2019-20-1187711/new-zealand-women-vs-south-africa-women-3rd-odi-1187716/full-scorecard");
		
		

		String name = "Maddy Green";

		getAlldetails(name);
		
		driver.quit();

	}

	public static void getAlldetails(String name) {
		List<WebElement> eleList = driver.findElements(By.xpath("//a[text()='" + name + "']/parent::td/following-sibling::td"));

		for (int i = 1; i < eleList.size(); i++) {
			String detail = eleList.get(i).getText();
			System.out.print(detail + " ");
		}
	}

}
