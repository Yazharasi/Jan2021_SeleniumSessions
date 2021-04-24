package SeleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuitandCloseConcept {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "/Users/yazharasiprabhakaran/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.homedepot.com/");
		
		System.out.println(driver.getTitle());
		
		driver.close();
		
//		driver.quit();
		
		System.out.println(driver.getTitle());
		
	
		

	}

}
