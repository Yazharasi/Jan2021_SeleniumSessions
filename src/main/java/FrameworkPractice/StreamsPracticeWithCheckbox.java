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

public class StreamsPracticeWithCheckbox {
	static WebDriver driver;

	public static void main(String[] args) {

//		ArrayList<String> arr = new ArrayList<String>();
//		arr.add("Tom IBM");
//		arr.add("Meera CTS");
//		arr.add("Aswin Infosys");
//		arr.add("Harry IBM");
//		arr.add("Mithula TCS");
//		arr.add("Mary WIPRO");
//		arr.add("Ranjitha IBM");
//		arr.stream().filter(ele -> ele.contains("IBM")).forEach(ele -> System.out.println(ele));

//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		driver.get("https://datatables.net/extensions/select/examples/initialisation/checkbox.html");
//		
//		By locator = By.cssSelector("td.select-checkbox");
//		List<WebElement> checkboxfields = driver.findElements(locator);
//		checkboxfields.stream().forEach(ele -> ele.click());

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/index.html");
		driver.findElement(By.name("username")).sendKeys("groupautomation");
		driver.findElement(By.name("password")).sendKeys("Test@12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();

		By framelocator = By.xpath("//frame[@name='mainpanel']");
		WebElement ele = driver.findElement(framelocator);

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ele));
		driver.findElement(By.cssSelector("div#navmenu li>a[title='Contacts']")).click();
		selectCheckboxUsingStream("Chandru Selvam");

//		name field: //td/a[text()='Chandru Selvam']
//		Checkbox: //td/a[text()='Chandru Selvam']/parent::td/preceding-sibling::td/input
//			
//			"//td/a[text()='"+name+"']/parent::td/preceding-sibling::td/input"

	}

	public static void selectCheckboxUsingStream(String name) {
		By xpath = By.xpath("//td/a[text()='" + name + "']/parent::td/preceding-sibling::td/input");
		driver.findElements(xpath).stream().forEach(ele -> ele.click());

	}

}
