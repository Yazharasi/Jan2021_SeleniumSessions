package FrameworkPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClickandSendKeysPractice {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("http://demoqa.com/text-box");
	
		Thread.sleep(1000);
		
		Actions action = new Actions(driver);
		
		WebElement un = driver.findElement(By.id("userName"));
		WebElement email = driver.findElement(By.id("userEmail"));
		WebElement loginbtn = driver.findElement(By.id("submit"));
		
		
		action.sendKeys(un, "TestUser").perform();
		action.sendKeys(email, "testuser@test.com").perform();
		action.click(loginbtn).perform();
		
		String name = driver.findElement(By.xpath("//div[@id='output']//p[contains(@id,'name')]")).getText();
		System.out.println("The name segment: "+name);
		String mail = driver.findElement(By.xpath("//div[@id='output']//p[contains(@id,'email')]")).getText();
		System.out.println("The email segment: "+mail);
	}

}
