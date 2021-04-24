package FrameworkPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomXpathPractice1 {

	public static void main(String[] args) {
		

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://classic.crmpro.com/index.html");
		
		List<WebElement> footerlinks = driver.findElements(By.xpath("//div[@class='col-lg-4 col-sm-6 col-offset-2 margin social']//li/a"));
		for(WebElement e: footerlinks) {
		System.out.println(e.getText());
			
		}
		
		driver.quit();

	}

}
