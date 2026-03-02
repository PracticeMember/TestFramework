package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ElementActions {
	private static final Logger log=LoggerFactory.getLogger(ElementActions.class);
	
	private final WebDriver driver;
	
	public ElementActions(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement find(By locator){
		return driver.findElement(locator);
	}
	
	public void click(By locator) {
		find(locator).click();
		log.info("Clicked on {}",locator);
	}
	
	public void sendText(By locator,String text) {
		find(locator).sendKeys(text);
		log.info("Entered {} in to {}",text,locator);
	}
	
	public void getText(By locator) {
		find(locator).getText();
		log.info("Extracted text from element : {}",locator);
	}
	
	public String getAttribute(By locator,String Attribute) {
		log.info("Getting attribute '{}' from element '{}'",Attribute,locator);
		return find(locator).getAttribute(Attribute);
	}
}
