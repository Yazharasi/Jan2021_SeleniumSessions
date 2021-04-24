package FrameworkPractice;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClosingAdBrowsers {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.naukri.com/");
		Set<String> handles = driver.getWindowHandles();
		ArrayList<String> handleList = new ArrayList<String>(handles);
		
		for(int i=1;i<handleList.size();i++) {
			driver.switchTo().window(handleList.get(i));
			driver.close();
			driver.switchTo().window(handleList.get(0));
		}
		
		System.out.println("All the ad windows are closed");
		
		driver.quit();

	}

}
