package mx.com.liverpool.homepage;

import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import mx.com.liverpool.base.TestUtilities;
import mx.com.liverpool.pages.HomePage;

public class SearchBarTests extends TestUtilities {

	@Test(groups = { "sanityTests" })
	public void searchBar_isVisible() {
		log.info("Starting Visibile Search Bar test.");
		HomePage homePage = new HomePage(driver, log);

		homePage.openPage();

		Assert.assertTrue(homePage.isSearchBarVisible(), "Search bar is not visible!");

	}

	@Parameters({ "search-keywords" })
	@Test(groups = { "smokeTests" })
	public void zoomIcon_returnsSearchResults(@Optional("sandalias") String searchkeywords) {
		log.info("Starting Search by keyword test.");
		HomePage homePage = new HomePage(driver, log);

		homePage.openPage();
		homePage.searchForKeyword(searchkeywords);

		log.info(homePage.getResultsSummary());
		Assert.assertTrue(homePage.getResultsSummary().contains(searchkeywords),
				"'" + searchkeywords + "' were not found in the results summary.");
	}

}
