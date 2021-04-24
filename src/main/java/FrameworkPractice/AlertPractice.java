package FrameworkPractice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertPractice {

	public static void main(String[] args) throws Exception{

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

		driver.findElement(By.xpath("//input[@value='Sign in']")).click();
		
		Alert alert = driver.switchTo().alert();
		System.out.println("The alert message is: "+alert.getText());
		Thread.sleep(2000);
		alert.accept();
		System.out.println("The alert is handled successfully");
		driver.quit();
	}

}



