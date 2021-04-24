package FrameworkPractice;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HasMapRBAC {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		doLogin("admin");
		doLogin("dev");
		doLogin("tester");
		doLogin("vendor");
		doLogin("seller");
		
		driver.quit();
	}

	public static void doLogin(String role) throws InterruptedException {
		String[] cred = getUserCredentials(role).split(":");
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys(cred[0].trim());
		driver.findElement(By.id("input-password")).clear();
		driver.findElement(By.id("input-password")).sendKeys(cred[1].trim());
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Thread.sleep(2000);
	}

	public static String getUserCredentials(String role) {

		Map<String, String> userperm = new HashMap<String, String>();
		userperm.put("admin", "admin@g.com: admin123");
		userperm.put("dev", "dev@g.com:dev123");
		userperm.put("tester", "tester@g.com:tester123");
		userperm.put("vendor", "vendor@g.com:vendor123");
		userperm.put("seller", "seller@g.com:seller123");

		if (userperm.containsKey(role)) {
			return userperm.get(role);
		}
		return null;
	}

}
