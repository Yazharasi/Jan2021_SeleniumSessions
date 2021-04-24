package FrameworkPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadPractice {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys("/Users/yazharasiprabhakaran/Desktop/Cigna.pdf");
		Thread.sleep(2000);
		driver.quit();

	}

}
