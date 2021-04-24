package SeleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class CrossBrowserTesting {

	public static void main(String[] args) {
		

		WebDriver driver;
		String browser = "Safari";
		
/* ************************Using if case****************** */
		 
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","/Users/yazharasiprabhakaran/Downloads/chromedriver");
			driver = new ChromeDriver();
		}
		
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","/Users/yazharasiprabhakaran/Downloads");
			driver = new FirefoxDriver();
		}
		
		else if(browser.equalsIgnoreCase("safari"))
		{
			driver = new SafariDriver();
		}
		
		else
		{
			System.out.println("Give correct browser");
			driver = new ChromeDriver();
		}
		
/* ************************Using Switch case****************** */
		
//		switch (browser.toLowerCase()) {
//		case "chrome":
//			System.setProperty("webdriver.chrome.driver","/Users/yazharasiprabhakaran/Downloads/chromedriver");
//			driver = new ChromeDriver();
//			break;
//			
//		case "firefox":
//			System.setProperty("webdriver.gecko.driver","/Users/yazharasiprabhakaran/Downloads");
//			driver = new FirefoxDriver();
//			break;
//			
//		case "safari":	
//			driver = new SafariDriver();
//			break;
//			
//		default:
//			System.out.println("Give correct browser");
//			driver = new ChromeDriver();
//			break;
//		}
		
		driver.get("https://www.homedepot.com/");
		
		System.out.println(driver.getTitle());
		
		driver.quit();

	}

}
