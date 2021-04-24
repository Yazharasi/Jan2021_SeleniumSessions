package FrameworkPractice;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dynamictable1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://classic.freecrm.com/");
		
		driver.findElement(By.name("username")).sendKeys("groupautomation");
		driver.findElement(By.name("password")).sendKeys("Test@12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		driver.switchTo().frame(1);
		driver.findElement(By.linkText("CONTACTS")).click();
		
		String name = "Devisha Sharma";
		String befxpath =  "//form[@id='vContactsForm']//tr[";
		String aftxpath1 = "]/td[1]";
		String aftxpath2 = "]/td[";
		String aftxpath3 = "]";
		
		ArrayList<String> contactdetails = new ArrayList<String>();
		
		
		List<WebElement> nameList = driver.findElements(By.xpath("//form[@id='vContactsForm']//tr/td[2]/a"));
		int listsize = nameList.size();
		
		for(int i=1;i<listsize;i++) {
			String value = nameList.get(i).getText();
			if(value.equals(name)) {
				driver.findElement(By.xpath(befxpath+(i+2)+aftxpath1)).click();
				for(int j=3;j<=7;j++) {
					WebElement e = driver.findElement(By.xpath(befxpath+(i+2)+aftxpath2+j+aftxpath3));
					contactdetails.add(e.getText());
			}
				break;
		}
		
		
		}
		

	System.out.println(contactdetails);		
	driver.quit();
		

	}

}
