package testngsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenCartTest extends BaseTest{
	
	@Test(priority=1)
	public void openCartPageTitleTest() {
		driver.get("https://demo.opencart.com/");
		String str = driver.getTitle();
		Assert.assertTrue(str.contains("Your Store"));
	}

	@Test(priority=2)
	public void openCartPageUrlTest() {
		String str = driver.getCurrentUrl();
		Assert.assertEquals(str, "https://demo.opencart.com/");

	}
	
	@Test(priority=3)
	public void openCartLogoTest() {
		By locator = By.xpath("//a[text()='Your Store']");
		WebDriverWait wait = new WebDriverWait(driver, 5);
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed());
		
	}

}
