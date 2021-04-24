package FrameworkPractice;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class FooterLink1 {

	public static void main(String[] args) {
		
		BrowserUtil br = new BrowserUtil();
		WebDriver driver = br.init_browser("chrome");
		br.launchUrl("https://www.amazon.in/");
		
		ElementUtil ele = new ElementUtil(driver);
		By collinks = By.xpath("//div[@class='navFooterColHead']");
		ArrayList<String> ColHeaders = ele.getTextofAllLinks(collinks);
		for(String e: ColHeaders) {
			System.out.println(e);
		}
		
		By footerlinks = By.xpath("//div[@class='navFooterLinkCol navAccessibility']//a");
		ArrayList<String> footerheaders = ele.getTextofAllLinks(footerlinks);
		for(String e: footerheaders) {
			System.out.println(e);
		}
		
		br.doQuit();

	}

}




