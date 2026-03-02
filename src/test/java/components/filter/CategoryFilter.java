package components.filter;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CategoryFilter {
	final WebDriver driver;
	
	public CategoryFilter(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public void selectHandTools(String... handtools) {
		for(String handtool: handtools) {
		By tool=By.xpath("//label[input[@name='category_id'] and normalize-space(.)='"+handtool+"']");
		WebElement ele=driver.findElement(tool);
			if(!ele.isSelected()) {
				ele.click();
			}
		}
	}
	
	public void deSelectHandTools(String... handtools) {
		for(String handtool: handtools) {
		By tool=By.xpath("//label[input[@name='category_id'] and normalize-space(.)='"+handtool+"']");
		WebElement ele=driver.findElement(tool);
			if(ele.isSelected()) {
				ele.click();
			}
		}
	}
	
	public void selectPowerTools(String... powertools) {
		for(String powertool: powertools) {
		By tool=By.xpath("//label[input[@name='category_id'] and normalize-space(.)='"+powertool+"']");
		WebElement ele=driver.findElement(tool);
			if(!ele.isSelected()) {
				ele.click();
			}
		}
	}
	
	public void deSelectPowerTools(String... powertools) {
		for(String powertool: powertools) {
			By tool=By.xpath("//label[input[@name='category_id'] and normalize-space(.)='"+powertool+"']");
			WebElement ele=driver.findElement(tool);
				if(ele.isSelected()) {
					ele.click();
			}
		}
	}
	
	public void selectOtherTools(String... othertools) {
		for(String othertool: othertools) {
		By tool=By.xpath("//label[input[@name='category_id'] and normalize-space(.)='"+othertool+"']");
		WebElement ele=driver.findElement(tool);
			if(!ele.isSelected()) {
				ele.click();
			}
		}
	}
	
	public void deSelectOtherTools(String... othertools) {
		for(String othertool: othertools) {
		By tool=By.xpath("//label[input[@name='category_id'] and normalize-space(.)='"+othertool+"']");
		WebElement ele=driver.findElement(tool);
			if(ele.isSelected()) {
				ele.click();
			}
		}
	}
	
	public List<String> getCategoryNamesUI(){
		List<WebElement> categories=driver.findElements(By.xpath("//label[.//input[@name='category_id']]"));
		return categories.stream()
				.map(category->category.getText().trim())
				.collect(Collectors.toList());
	}
	
}
