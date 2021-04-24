package FrameworkPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramePractice {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://www.londonfreelance.org/courses/frames/index.html");
		driver.switchTo().frame("bot");
		String frameTitle = driver.findElement(By.xpath("(//html/body/h2)[1]")).getText();
		System.out.println(frameTitle);
		driver.switchTo().defaultContent();
		driver.quit();

	}

}
