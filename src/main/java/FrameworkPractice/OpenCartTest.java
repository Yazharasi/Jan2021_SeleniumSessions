package FrameworkPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpenCartTest {

	public static void main(String[] args) {
		
		BrowserUtil br = new BrowserUtil();
		WebDriver driver = br.init_browser("chrome");
		br.launchUrl("https://demo.opencart.com/index.php?route=account/register");
		
		By firstname = By.id("input-firstname");
		By lastname = By.id("input-lastname");
		By email = By.id("input-email");
		By Telenum = By.id("input-telephone");
		By password = By.id("input-password");
		By password2 =By.id("input-confirm");
		By policy = By.name("agree");
		By register = By.xpath("//input[@value='Continue']");
				
		ElementUtil eleutil = new ElementUtil(driver);
		eleutil.doSendKeys(firstname, "Nithin");
		eleutil.doSendKeys(lastname, "Kumar");
		eleutil.doSendKeys(email, "iij@olk.com");
		eleutil.doSendKeys(Telenum, "1234567890");
		eleutil.doSendKeys(password, "123@123");
		eleutil.doSendKeys(password2, "123@123");
		eleutil.doClick(policy);
		eleutil.doClick(register);
		
		if(br.pageTitle().equals("Your Account Has Been Created!")) {
			System.out.println("The account registeration is successful");
		}
		
		else {
			System.out.println("Failed - Check the account creation steps again!");
		}
		
		By successmsg = By.xpath("//*[@id=\"content\"]/h1");
		System.out.println(eleutil.doGetText(successmsg));
		
		By continuebtn = By.linkText("Continue");
		System.out.println(eleutil.doIsDisplayed(continuebtn));
		
		
		br.doQuit();
	}

}
