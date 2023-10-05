package mx.com.liverpool.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

	protected WebDriver driver;
	protected Logger log;

	@BeforeClass(alwaysRun = true)
	public void setUp(ITestContext ctx) {
		String testName = ctx.getCurrentXmlTest().getName();
		log = LogManager.getLogger(testName);

		// Using Dev port
		ChromeOptions options = new ChromeOptions();
		/*
		 * This options are to connect session to existing browser using Dev portlaunch
		 * to avoid verification page. Only works opening the browser with arguments:
		 * 'start chrome --remote-debugging-port=9222
		 * --user-data-dir="C:\selenum\ChromeProfile"'
		 */
		// TODO: Fix, not working.
		// options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");

		// Create driver
		log.info("Open driver");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		// Close browser
		log.info("Close driver");
		driver.close();
	}
}
