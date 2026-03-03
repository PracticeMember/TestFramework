package base;

import static utils.ConfigManager.getProperty;

import org.bouncycastle.asn1.cmp.ProtectedPart;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.specification.RequestSpecification;
import manager.ApiManager;
import manager.PageManager;
import reports.TestListener;
import utils.ConfigManager;
import utils.Slf4jRequestFilter;


@Listeners(TestListener.class)
public class BaseTest {
	private final static Logger log=LoggerFactory.getLogger(BaseTest.class);
	
	public final static String TEST_RESOURCES = "//src//test//resources//config";
	public final static String RT_CONFIG = TEST_RESOURCES+"//rt_config";
	public final static String ST_CONFIG = TEST_RESOURCES+"//st_config";
	public final static String COMMON_CONFIG = TEST_RESOURCES+"//common_config";
	
	protected RequestSpecification requestspec;

	protected ApiManager api;
	protected PageManager page;
	
	@BeforeSuite
	@Parameters({"env"})
	public void setConfigs(@Optional("rt") String env) {
		String config=env.equalsIgnoreCase("rt")?RT_CONFIG:ST_CONFIG;
		ConfigManager.load(COMMON_CONFIG,config);
	}
	
	@BeforeMethod(alwaysRun=true)
	public void apisetup() {
		 String baseURI = getProperty("baseURI");
		 requestspec = new RequestSpecBuilder().setBaseUri(baseURI)
				 .addHeader("Content-Type", "application/json")
				 .addFilter(new RequestLoggingFilter(LogDetail.ALL))
				 .addFilter(new Slf4jRequestFilter())
				 .setRelaxedHTTPSValidation().build();
		 log.info("Request Specification built in before hook");
	}
	
	@BeforeMethod(alwaysRun=true)
	public void setup(ITestContext context) {
		String browser = System.getProperty("browser");

		if (browser == null) {
		    browser = context.getCurrentXmlTest().getParameter("browser");
		}
		if(browser==null) {
			browser="chrome";
		}
		WebDriver driver=DriverSetup.createDriver(browser);
		DriverFactory.setDriver(driver);
		log.info("Driver instance created and set in driver factory");
		 System.out.println("Thread: " + Thread.currentThread().getId() + " driver: " + DriverFactory.getDriver());
		this.api=new ApiManager(requestspec);
	    this.page=new PageManager();
	}
	
	@AfterMethod(alwaysRun=true)
	public void teardown() {
		DriverFactory.removeDriver();
	}
}
