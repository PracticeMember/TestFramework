package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class PriceRange extends BasePage{

	public PriceRange(WebDriver driver) {
		super(driver);
	}
	
	public String getMinPrice() {
		return elementActions().getAttribute(
				By.cssSelector(".ngx-slider-pointer-min"),"aria-valuenow");
		//return driver.findElement(By.cssSelector(".ngx-slider-pointer-min")).getAttribute("aria-valuenow");
	}
	
	public String getMaxPrice() {
		return driver.findElement(By.cssSelector(".ngx-slider-pointer-max")).getAttribute("aria-valuenow");
	}
}
