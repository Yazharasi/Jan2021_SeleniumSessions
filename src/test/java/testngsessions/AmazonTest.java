package testngsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonTest extends BaseTest {

	@Test(priority=1)
	public void amazonPageTitleTest() {
		driver.get("https://www.amazon.in/");
		String str = driver.getTitle();
		Assert.assertTrue(str.contains("Online Shopping site in India"));
	}

	@Test(priority=2)
	public void amazonPageUrlTest() {
		String str = driver.getCurrentUrl();
		Assert.assertEquals(str, "https://www.amazon.in/");

	}

	@Test(priority=3)
	public void amazonLogoTest() {
		By locator = By.xpath("//a[@aria-label='Amazon']");
		WebDriverWait wait = new WebDriverWait(driver, 5);
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed());
		
	}

}
