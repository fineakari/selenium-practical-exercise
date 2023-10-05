package mx.com.liverpool.homepage;

import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import mx.com.liverpool.base.TestUtilities;
import mx.com.liverpool.pages.HomePage;

public class FiltersTests extends TestUtilities {

	@Parameters({ "search-keywords" })
	@Test(groups = { "smokeTests" })
	public void checkboxFilter_canBeSelected(@Optional("karaoke") String searchkeywords) {
		log.info("Starting 'Checkbox can be selected' test.");
		HomePage homePage = new HomePage(driver, log);

		homePage.openPage();
		homePage.searchForKeyword(searchkeywords);

		log.info(homePage.getResultsSummary());
		homePage.selectFirstCheckbox();

		log.info(homePage.getResultsSummary());
		Assert.assertTrue(homePage.isFirstCheckboxesSelected(), "First checkbox is not selected.");
	}
}
