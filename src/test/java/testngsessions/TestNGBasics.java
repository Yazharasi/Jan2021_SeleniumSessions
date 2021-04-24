package testngsessions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGBasics {

	@BeforeSuite
	public void createUserInDB() {
		System.out.println("Before Suite --> Create User");
	}

	@BeforeTest
	public void giveUserPermission() {
		System.out.println("Before Test --> Give User Permission");
	}

	@BeforeClass
	public void launchUrl() {
		System.out.println("Before Class --> Launch the browser and Url");
	}

	@BeforeMethod
	public void login() {
		System.out.println("Before Method --> Verify Login");
	}

	@Test
	public void titleVerification() {
		System.out.println("At Test --> verify the title");
	}

	@Test
	public void Search() {
		System.out.println("At Test --> Search for products");
	}

	@Test
	public void logoVerification() {
		System.out.println("At Test --> verify the logo");
	}

	@AfterMethod
	public void logout() {
		System.out.println("After Method --> logout");
	}

	@AfterClass
	public void closeBrowser() {
		System.out.println("After Class --> Close the Browser");
	}

	@AfterTest
	public void revokeAccess() {
		System.out.println("After Test --> Revoke the access");
	}

	@AfterSuite
	public void deleteuser() {
		System.out.println("After Suite --> Delete the user");
	}

}
