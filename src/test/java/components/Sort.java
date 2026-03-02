package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Sort {

	final WebDriver driver;
	
	public Sort(WebDriver driver) {
		this.driver=driver;
	}
	
	public void selectSortOptionFromDropDownByValue(String option) {
		WebElement sort=driver.findElement(By.className("form-select"));
		Select dropdown=new Select(sort);
		dropdown.selectByValue(option);
	}
	
	public void selectSortOptionFromDropDownText(String option) {
		WebElement sort=driver.findElement(By.className("form-select"));
		Select dropdown=new Select(sort);
		dropdown.selectByVisibleText(option);
	}
}
