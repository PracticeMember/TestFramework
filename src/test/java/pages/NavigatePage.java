package pages;

import org.openqa.selenium.WebDriver;

import base.BasePage;

import static utils.ConfigManager.getProperty;
public class NavigatePage extends BasePage{

	public NavigatePage(WebDriver driver) {
		super(driver);
	}
	
	public void openSoftwareTestingPage() {
		driver.get(getProperty("url"));
	}
	
	public void navigateBackFromPage() {
		driver.navigate().back();
	}
}
