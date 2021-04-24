package SeleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class LaunchingBrowser {

	public static void main(String[] args) {
//		System.setProperty("webdriver.chrome.driver","/Users/yazharasiprabhakaran/Downloads/chromedriver");
//		WebDriver driver = new ChromeDriver();
		
		WebDriver driver = new SafariDriver();
		driver.get("https://www.homedepot.com/");
		String title = driver.getTitle();
		System.out.println("The title is: "+title);
		String currenturl = driver.getCurrentUrl();
		System.out.println("The Current URL is: "+currenturl);
		

		if(title.equals("The Home Depot"))
		{
			System.out.println("The page title is correct.");
		}
		
		else 
		{
			System.out.println("The title is incorrect.");
		}
		driver.quit();
		

	}

}
