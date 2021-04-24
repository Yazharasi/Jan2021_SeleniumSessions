package FrameworkPractice;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomXpathPractice2 {
	
	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.freshworks.com/");
		Thread.sleep(3000);
		
		String beforexpath = "\"(//ul[@class='footer-nav’])[";
		String afterxpath = "]/li\"";
		ArrayList<String> footerlinks = new ArrayList<String>();
		
		
		for(int i=1;i<=4;i++) {
			String locator = beforexpath+i+afterxpath;
			List<WebElement> footers = driver.findElements(By.xpath(locator));
			for(WebElement e: footers) {
				footerlinks.add(e.getText());
			}
			
		}
		
		for(String e: footerlinks) {
			System.out.println(e);
		}
	}

}
