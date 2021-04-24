package FrameworkPractice;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class FooterLink2 {

	public static void main(String[] args) {
		
		BrowserUtil br = new BrowserUtil();
		WebDriver driver = br.init_browser("chrome");
		br.launchUrl("https://www.amazon.in/");
		
		ElementUtil ele = new ElementUtil(driver);
		By footerlinks = By.xpath("//div[@class='navFooterLine navFooterLinkLine navFooterPadItemLine ']//a");
		ArrayList<String> langList = ele.getTextofAllLinks(footerlinks);
		for(String e: langList) {
			System.out.println(e);
		}
		
		br.doQuit();

	}

}




