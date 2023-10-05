package mx.com.liverpool.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

	private By usernameLocator = By.xpath("//input[@id='username']");
	private By passwordLocator = By.xpath("//input[@id='password']");
	private By logInButtonLocator = By
			.xpath("/html/body//section//form[@method='POST']/div[@class='c4b4939bc']/button[@name='action']");

	public LoginPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	public boolean isUsernameFieldVisible() {
		return find(usernameLocator).isDisplayed();
	}

	public boolean isPasswordFieldVisible() {
		return find(passwordLocator).isDisplayed();
	}

	public boolean isLogInButtonVisible() {
		return find(logInButtonLocator).isDisplayed();
	}

	/** Execute log in */
	public HomePage logIn(String username, String password) {
		log.info("Executing LogIn");
		enterText(username, usernameLocator);
		enterText(password, passwordLocator);
		click(logInButtonLocator);
		return new HomePage(driver, log);
	}

}
