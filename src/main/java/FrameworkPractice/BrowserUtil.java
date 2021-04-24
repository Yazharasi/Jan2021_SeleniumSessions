package FrameworkPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtil {
	
	WebDriver driver;

	
	public WebDriver init_browser(String browsername){
		
		System.out.println("The browser name is: "+browsername);
		
		switch (browsername.toLowerCase()) {
		
		case "chrome": 
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
			
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
			
		case "safari":
			driver = new SafariDriver();
			break;
			
			default: 
				System.out.println("Enter the correct browser name");
				break;
			
		}
		return driver;
	}
	
	public void launchUrl(String url) {
		driver.get(url);
	}
	
	public String pageTitle() {
		return driver.getTitle();
	}
	
	public String currentUrl() {
		return driver.getCurrentUrl();
	}
	
	public void navigateTo(String url) {
		driver.navigate().to(url);
	}
	public void navigateBack() {
		driver.navigate().back();
	}
	
	public void navigateForward() {
		driver.navigate().forward();
	}
	
	public void doRefresh() {
		driver.navigate().refresh();
	}
	
	public void doClose() {
		driver.close();
	}
	
	public void doQuit() {
		driver.quit();
	}

}
