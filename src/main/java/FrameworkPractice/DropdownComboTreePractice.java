package FrameworkPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownComboTreePractice {

	static WebDriver driver;

	public static void main(String[] args) throws Exception {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.findElement(By.id("justAnInputBox")).click();

		Thread.sleep(2000);

//		By options = By.cssSelector("span.comboTreeItemTitle");
		By options = By.xpath("//span[@class='comboTreeItemTitle']");

//		doSelectDropdownOptionfromComboTree(options, "choice 6 2 2");

//		doSelectMultiOptionsfromComboDropdown(options, "choice 6 2 2");
//		doSelectMultiOptionsfromComboDropdown(options, "choice 6 2 2", "choice 3", "choice 2 2", "choice 2 1");
		doSelectMultiOptionsfromComboDropdown(options, "ALL");

		System.out.println("The choice is selected");

	}

	public static void doSelectDropdownOptionfromComboTree(By locator, String value) {
		List<WebElement> allchoices = driver.findElements(locator);
		for (int i = 0; i < allchoices.size(); i++) {
			String option = allchoices.get(i).getText();
			if (option.equals(value)) {
				allchoices.get(i).click();
				break;
			}
		}

	}

	public static void doSelectMultiOptionsfromComboDropdown(By locator, String... choices) {
		List<WebElement> choiceList = driver.findElements(locator);

		if (!choices[0].equalsIgnoreCase("all")) {

			for (WebElement e : choiceList) {
				String choicetext = e.getText();
				for (int i = 0; i < choices.length; i++) {
					if (choicetext.equals(choices[i])) {
						e.click();
						break;
					}

				}
			}

		}

		else {
			try {
				for (WebElement e : choiceList) {
					e.click();
				}
			} catch (Exception e) {
			}
		}

	}

}
