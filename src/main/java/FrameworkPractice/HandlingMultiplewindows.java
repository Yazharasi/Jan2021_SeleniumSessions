package FrameworkPractice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingMultiplewindows {
	static WebDriver driver;
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.aetna.com/");

//		driver.findElement(By.xpath("//a[@class='sociallink sociallink--instagram']")).click();
//		driver.findElement(By.xpath("//a[@class='sociallink sociallink--facebook']")).click();
//		driver.findElement(By.xpath("//a[@class='sociallink sociallink--twitter']")).click();
//		driver.findElement(By.xpath("//a[@class='sociallink sociallink--youtube']")).click();
		
		By insta = By.xpath("//a[@class='sociallink sociallink--instagram']");
		By face = By.xpath("//a[@class='sociallink sociallink--facebook']");
		By Twit = By.xpath("//a[@class='sociallink sociallink--twitter']");
		By YTube = By.xpath("//a[@class='sociallink sociallink--youtube']");
		
		goToChildWindowGetTitleandClose(insta);
		goToChildWindowGetTitleandClose(face);
		goToChildWindowGetTitleandClose(Twit);
		goToChildWindowGetTitleandClose(YTube);
		

/* 		Using Window Handler APi method:  */

/* 		Set<String> handles = driver.getWindowHandles();   */

//		Iterator<String> it = handles.iterator();
//		String parentHandle = it.next();
//		String chileHandle1 = it.next();
//		String chileHandle2 = it.next();
//		String chileHandle3 = it.next();
//		String chileHandle4 = it.next();
	
/* 		Using ArrayList   */
		
//		ArrayList<String> handleList = new ArrayList<String>(handles);
//		String parentHandle = handleList.get(0);
//		String chileHandle1 = handleList.get(1);
//		String chileHandle2 = handleList.get(2);
//		String chileHandle3 = handleList.get(3);
//		String chileHandle4 = handleList.get(4);
//		
//
//		System.out.println("The page title is : " + driver.getTitle());
//		driver.switchTo().window(chileHandle1);
//		System.out.println("The page title is : " + driver.getTitle());
//		driver.close();
//		driver.switchTo().window(chileHandle2);
//		System.out.println("The page title is : " + driver.getTitle());
//		driver.close();
//		driver.switchTo().window(chileHandle3);
//		System.out.println("The page title is : " + driver.getTitle());
//		driver.close();
//		driver.switchTo().window(chileHandle4);
//		System.out.println("The page title is : " + driver.getTitle());
//		driver.close();
//		driver.switchTo().window(parentHandle);
//		System.out.println("The page title is : " + driver.getTitle());
//		driver.quit();
		
		

	}
	
	public static void goToChildWindowGetTitleandClose(By locator) {
		driver.findElement(locator).click();
		Set<String> handles = driver.getWindowHandles();
		ArrayList<String> handleList = new ArrayList<String>(handles);
		String parWindow = handleList.get(0);
		String childWindow = handleList.get(1);
		
		driver.switchTo().window(childWindow);
		System.out.println("The child window title is: "+driver.getTitle());
		driver.close();
		driver.switchTo().window(parWindow);
		
	}

}
