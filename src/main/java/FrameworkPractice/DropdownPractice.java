package FrameworkPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownPractice {
	static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		By employees = By.id("Form_submitForm_NoOfEmployees");
		By industry = By.id("Form_submitForm_Industry");
		By country = By.id("Form_submitForm_Country");
		By employees2 = By.xpath("//select[@id='Form_submitForm_NoOfEmployees']/option");
		
		doSelectfromDropdownbyIndex(employees, 3);
		doSelectfromDropdownbyValue(industry, "Automotive");
		doSelectfromDropdownbyVisText(country, "Argentina");
		doSelectDropdownValueWithoutSelctClass(employees2, "76 - 100");
		
//		List<WebElement> allOptions = doGetAllOptions(industry);
//		for(WebElement e: allOptions) {
//			System.out.println(e.getText());
		}
		
		
	
	
	public static void doSelectfromDropdownbyIndex(By locator, int index) {
		Select select = new Select(driver.findElement(locator));
		select.selectByIndex(index);
	}
	
	public static void doSelectfromDropdownbyValue(By locator, String value) {
		Select select = new Select(driver.findElement(locator));
		select.selectByValue(value);
	}
	
	public static void doSelectfromDropdownbyVisText(By locator, String visibletext) {
		Select select = new Select(driver.findElement(locator));
		select.selectByVisibleText(visibletext);
	}
	
	public static void doSelectDropdownAllOptions(By locator) {
		Select select = new Select(driver.findElement(locator));
		List<WebElement> alloptions = select.getOptions();
		for(WebElement e: alloptions) {
			e.click();
		}
	}
	
	public static void doSelectDropdownValueWithoutSelctClass(By locator, String option) {
		
		List<WebElement> alloptions = driver.findElements(locator);
		for(WebElement e: alloptions) {
			if(e.getText().equals(option)) {
				e.click();
				break;
			}
		}
		
	}

}












