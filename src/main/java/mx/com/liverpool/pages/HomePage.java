package mx.com.liverpool.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

	private String pageUrl = "https://www.liverpool.com.mx/tienda/home";

	private By searchBarLocator = By.id("mainSearchbar");
	private By zoomIconLocator = By
			.xpath("//div[@id='__next']/header/div[@class='o-header']/div/div//i[@class='icon-zoom']");
	private By resultsSummaryLocator = By
			.xpath("//div[@id='__next']/div[1]/div[1]//h1[@class='a-headline__typeahed searcherTitle-result']");

	private By logInLinkLocator = By.linkText("Iniciar sesión");
	private By activeLogInLocator = By
			.xpath("//div[@id='__next']/header/div[@class='o-header']//div[@class='m-searchBar']/div/div[5]/span");

	public HomePage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	/** Open HomePage using it's url */
	public void openPage() {
		log.info("Opening page: " + pageUrl);
		openUrl(pageUrl);
		log.info("Page opened!");
	}

	/** Verify if logged in user button is visible on the page. */
	public boolean isSearchBarVisible() {
		log.info("Is search bar visible? : " + find(searchBarLocator).isDisplayed());
		return find(searchBarLocator).isDisplayed();
	}

	/** Execute search. */
	public void searchForKeyword(String keywords) {
		log.info("Searching for word(s): " + keywords);
		enterText(keywords, searchBarLocator);
		click(zoomIconLocator);
	}

	public String getResultsSummary() {
		return find(resultsSummaryLocator).getText();
	}

	/** Verify if logged in user button is visible on the page. */
	public boolean isUserLoggedIn() {
		return find(activeLogInLocator).isDisplayed();
	}

	/** Open LoginPage by clicking on Iniciar sesión Link */
	public LoginPage clickLogInLink() {
		log.info("Clicking on Log In link on Home Page");
		// Note for later: If isUserLoggedIn then perform logout
		click(logInLinkLocator);
		return new LoginPage(driver, log);
	}

}
