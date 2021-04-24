package FrameworkPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticTablePractice {

	static WebDriver driver;

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/Users/yazharasiprabhakaran/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");

		int rowcount = driver.findElements(By.xpath("//*[@id=\"customers\"]/tbody/tr")).size();
		int colcount = driver.findElements(By.xpath("//*[@id=\"customers\"]/tbody/tr/th")).size();

		getAllTablevalues(rowcount, colcount);
		driver.quit();

	}

	public static void getAllTablevalues(int rowcount, int colcount) {
		String xpath1 = "//*[@id=\"customers\"]/tbody/tr[";
		String xpath2 = "]/td[";
		String xpath3 = "]";
		for (int i = 2; i <= rowcount; i++) {
			for (int j = 1; j <= colcount; j++) {
				String xpath = xpath1 + i + xpath2 + j + xpath3;
				String value = driver.findElement(By.xpath(xpath)).getText();
				System.out.print(value + "--");
			}
			System.out.println();
		}
	}

}
