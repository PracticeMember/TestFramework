package base;

import org.openqa.selenium.WebDriver;

import core.ElementActions;

public class BasePage {
	
	protected WebDriver driver;
	protected ElementActions elementActions;
	
	public BasePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public ElementActions elementActions() {
		if(elementActions==null)
			elementActions=new ElementActions(driver);
		return elementActions;
	}
}
