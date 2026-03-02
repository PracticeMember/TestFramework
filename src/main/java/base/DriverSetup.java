package base;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v120.console.Console;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static utils.ConfigManager.getProperty;

public class DriverSetup {
	private final static Logger log=LoggerFactory.getLogger(DriverSetup.class);
	
	public static WebDriver createDriver(String browser) {
		browser=browser.toLowerCase();
		switch(browser) {
		case "chrome": return createChromeDriver();
		case "firefox": return createFirefoxDriver();
		case "edge": return createEdgeDriver();
		default: return null;
		}
	}

	private static WebDriver createEdgeDriver() {
		return new EdgeDriver();
	}

	private static WebDriver createChromeDriver() {
	    long implicitWait=Long.parseLong(getProperty("implicit_wait"));
	    long pageLoadWait=Long.parseLong(getProperty("pageLoadTimeout"));
	    ChromeDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadWait));
		return driver;
	}

	private static WebDriver createFirefoxDriver() {
		return new FirefoxDriver();
	}
}
