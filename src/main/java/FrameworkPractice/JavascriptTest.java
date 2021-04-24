package FrameworkPractice;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavascriptTest {

	public static void main(String[] args) throws InterruptedException{
		
		WebDriverManager.chromedriver().setup();
		BrowserUtil br = new BrowserUtil();
		WebDriver driver = br.init_browser("chrome");
		br.launchUrl("https://classic.crmpro.com/index.html");
		
		JavascriptUtil jsu = new JavascriptUtil(driver);
		Thread.sleep(2000);
		jsu.scrollPageDown();
		Thread.sleep(2000);
		jsu.scrollPageUp();
		Thread.sleep(2000);
		jsu.scrollPageDown("300");
		System.out.println("Scrolling done");
		

	}

}
