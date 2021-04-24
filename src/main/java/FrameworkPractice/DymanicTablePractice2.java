package FrameworkPractice;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DymanicTablePractice2 {

	static WebDriver driver;

	public static void main(String args[]) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://classic.freecrm.com/");

		driver.findElement(By.name("username")).sendKeys("groupautomation");
		driver.findElement(By.name("password")).sendKeys("Test@12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("mainpanel"));
		driver.findElement(By.linkText("CONTACTS")).click();

		String name = "David Crist";
		selectCheckboxWithGivenName(name);
		System.out.println(getAllContactDetails(name));
		
		driver.quit();

	}

	public static void selectCheckboxWithGivenName(String name) {
		driver.findElement(
				By.xpath("//a[text()='" + name + "']/parent::td/preceding-sibling::td/input[@type='checkbox']"))
				.click();
	}

	public static String getCompanyName(String name) {
		String companyName = driver
				.findElement(By.xpath("//a[text()='" + name + "']/parent::td/following-sibling::td[1]")).getText();
		return companyName;
	}

	public static String getPhoneNumber(String name) {
		String phonenum = driver.findElement(By.xpath("//a[text()='" + name + "']/parent::td/following-sibling::td[2]"))
				.getText();
		return phonenum;
	}

	public static List<String> getAllContactDetails(String name) {
		List<String> contactDetails = new ArrayList<String>();
		contactDetails.add(getCompanyName(name));
		contactDetails.add(getPhoneNumber(name));
		return contactDetails;

	}

}
