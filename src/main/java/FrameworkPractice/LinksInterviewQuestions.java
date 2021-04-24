package FrameworkPractice;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LinksInterviewQuestions {

	
		// Find total of links available
		// Print all the link texts
		// Print only the texts that are not null along with the index
	
		public static void main(String args[]) {
	
		BrowserUtil br = new BrowserUtil();
		WebDriver driver = br.init_browser("chrome");
		br.launchUrl("https://www.amazon.in/");
		
		ElementUtil eleutil = new ElementUtil(driver);
		By alllinks = By.tagName("a");
		ArrayList<String> allLinkText = eleutil.getTextofAllLinks(alllinks);
		System.out.println("Total links count: "+allLinkText.size());
		
		System.out.println("--------------Printing all links----------");
		for(int i=0;i<allLinkText.size();i++) {
			System.out.println(i+"-->"+allLinkText.get(i));
		}
		
		System.out.println("--------------Printing only the links thats are not null----------");
		for(int i=0;i<allLinkText.size();i++) {
		if(!allLinkText.get(i).isEmpty())
			System.out.println(i+"-->"+allLinkText.get(i));
		}
		
		br.doQuit();
	}

}
