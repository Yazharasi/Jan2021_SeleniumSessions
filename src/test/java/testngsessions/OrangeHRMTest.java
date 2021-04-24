package testngsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrangeHRMTest extends BaseTest{
	
	@Test(priority=1)
	public void OrangeHRMPageTitleTest() {
		driver.get("https://www.orangehrm.com/");
		String str = driver.getTitle();
		Assert.assertTrue(str.contains("HR Management"));
	}

	@Test(priority=2)
	public void OrangeHRMPageUrlTest() {
		String str = driver.getCurrentUrl();
		Assert.assertEquals(str, "https://www.orangehrm.com/");

	}

	@Test(priority=3)
	public void OrangeHRMLogoTest() {
		By locator = By.xpath("//img[@alt='OrangeHRM Inc Logo']");
		WebDriverWait wait = new WebDriverWait(driver, 5);
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed());
		
	}

}
