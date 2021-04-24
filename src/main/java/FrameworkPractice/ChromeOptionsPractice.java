package FrameworkPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeOptionsPractice {

	public static void main(String[] args) {
		

		ChromeOptions co = new ChromeOptions();
//		co.addArguments("--headless");
		co.addArguments("--incognito");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(co);
		driver.get("https://www.google.com");
		
		System.out.println("The title is: "+driver.getTitle());
		System.out.println("The title is: "+driver.getCurrentUrl());
		driver.navigate().to("https://www.amazon.com");
		
		

	}

}
