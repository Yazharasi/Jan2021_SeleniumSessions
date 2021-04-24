package FrameworkPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StreamsPractice {

	public static void main(String[] args) {
		
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.amazon.in/");
	By locator = By.tagName("a");
	
	ElementUtil el = new ElementUtil(driver);
	List<String> linksList = el.waitForElementsAndReturnTextList(locator, 10);
	linksList.stream().forEach(ele -> System.out.println(ele));
	
	driver.quit();
	
//	Question: get all links and print the link text that is not empty and text that has the word Amazon
	
//	Method 1:
//	for(WebElement e: linksList) {
//		String text = e.getText();
//		if(!text.isEmpty() && text.contains("Amazon")) {
//			System.out.println(text);
//		}
//	}
	
//	Method 2: Using 2 streams
	
//	List<String> linksText = linksList.stream().filter(ele -> !ele.getText().isEmpty()).filter(ele -> ele.getText().contains("Amazon")).map(ele -> ele.getText()).collect(Collectors.toList());
//	linksText.stream().forEach(ele -> System.out.println(ele));
	
	
//	Method 3: Using 2 streams in different way
	
//	List<WebElement> filteredList = linksList.stream().filter(ele -> !ele.getText().isEmpty()).filter(ele -> ele.getText().contains("Amazon")).collect(Collectors.toList());
//	filteredList.stream().forEach(ele -> System.out.println(ele.getText()));
	
//	Method 4: Using single stream
	
//	long beforeExec = System.currentTimeMillis();
//	linksList.parallelStream().filter(ele -> !ele.getText().isEmpty()).filter(ele -> ele.getText().contains("Amazon")).forEach(ele -> System.out.println(ele.getText()));
//	long afterExec = System.currentTimeMillis();
//	System.out.println("The time diff: "+(afterExec - beforeExec));
//	4330 mlsecs
	
	
//	Method 5: Using single parallel stream
//	long beforeExec = System.currentTimeMillis();
//	linksList.parallelStream().filter(ele -> !ele.getText().isEmpty()).filter(ele -> ele.getText().contains("Amazon")).forEach(ele -> System.out.println(ele.getText()));	
//	long afterExec = System.currentTimeMillis();
//	System.out.println("The time diff: "+(afterExec - beforeExec));
//	4060 msecs
	}

}
