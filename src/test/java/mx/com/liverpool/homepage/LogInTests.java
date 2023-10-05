package mx.com.liverpool.homepage;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import mx.com.liverpool.base.TestUtilities;
import mx.com.liverpool.pages.HomePage;
import mx.com.liverpool.pages.LoginPage;

public class LogInTests extends TestUtilities {

	@Test(groups = { "smokeTests" })
	public void logInElements_areVisible() {
		log.info("Starting log in elements visibility test.");
		HomePage homePage = new HomePage(driver, log);

		homePage.openPage();
		LoginPage loginPage = homePage.clickLogInLink();

		Assert.assertTrue(loginPage.isUsernameFieldVisible(), "Username is not visible.");
		Assert.assertTrue(loginPage.isPasswordFieldVisible(), "Password is not visible.");
		Assert.assertTrue(loginPage.isLogInButtonVisible(), "Log In button is not visible.");
	}

	@Test(groups = { "smokeTests" })
	public void logIn_worksCorrectly() {
		log.info("Starting log in test.");
		HomePage homePage = new HomePage(driver, log);

		// openChromeWithArguments();
		homePage.openPage();
		LoginPage loginPage = homePage.clickLogInLink();
		String loginURL = homePage.getCurrentUrl();

		homePage = loginPage.logIn(getUsername(), getPassword());

		log.info("CurrentURL: " + homePage.getCurrentUrl());
		Assert.assertNotEquals(loginURL, homePage.getCurrentUrl(), "Page didn't update");
		// Assert.assertTrue(homePage.isUserLoggedIn(), "User is not logged in.");
	}

	@AfterTest(enabled = false)
	public void logOut() {
		log.info("Logging out.");
		HomePage homePage = new HomePage(driver, log);
		homePage.clickLogOutLink();
	}

	@Test(enabled = false)
	public void openChromeWithDevArgs_browserOpens() {
		openChromeWithArguments();
	}

}
