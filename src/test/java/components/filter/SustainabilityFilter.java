package components.filter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SustainabilityFilter {

	
	final WebDriver driver;
	public SustainabilityFilter(WebDriver driver) {
		this.driver=driver;
	}

	public void selectSustainabilityFilter() {
		By ecoFriendly=By.xpath("//input[@data-test='eco-friendly-filter']");
		WebElement ele=driver.findElement(ecoFriendly);
		if(!ele.isSelected()) {
			ele.click();
		}
	}
	
	public void deselectSustainabilityFilter() {
		By ecoFriendly=By.xpath("//input[@data-test='eco-friendly-filter']");
		WebElement ele=driver.findElement(ecoFriendly);
		if(ele.isSelected()) {
			ele.click();
		}
	}
}
