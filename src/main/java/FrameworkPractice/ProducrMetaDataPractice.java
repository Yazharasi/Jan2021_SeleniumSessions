package FrameworkPractice;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProducrMetaDataPractice {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=product/product&path=20_27&product_id=41");
		Map<String, String> prodDtls = new HashMap<String, String>();

		By pname = By.cssSelector("div#content h1");
		prodDtls.put("Name", driver.findElement(pname).getText());
		By brand = By.xpath("((//div[@class='col-sm-4'])[2]//li)[1]");
		String brandname[] = driver.findElement(brand).getText().split(":");
		prodDtls.put(brandname[0].trim(), brandname[1].trim());

		By pcode = By.xpath("((//div[@class='col-sm-4'])[2]//li)[2]");
		String productcode[] = driver.findElement(pcode).getText().split(":");
		prodDtls.put(productcode[0].trim(), productcode[1].trim());

		By avail = By.xpath("((//div[@class='col-sm-4'])[2]//li)[3]");
		String availability[] = driver.findElement(avail).getText().split(":");
		prodDtls.put(availability[0].trim(), availability[1].trim());

		By price = By.xpath("((//div[@class='col-sm-4'])[2]//li)[4]");
		prodDtls.put("Price", driver.findElement(price).getText());

		By tax = By.xpath("((//div[@class='col-sm-4'])[2]//li)[5]");
		String taxValue[] = driver.findElement(tax).getText().split(":");
		prodDtls.put(taxValue[0].trim(), taxValue[1].trim());

		prodDtls.forEach((k, v) -> System.out.println(k + ", " + v));

	}

}
