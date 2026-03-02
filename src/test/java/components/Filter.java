package components;

import org.openqa.selenium.WebDriver;

import components.filter.BrandFilter;
import components.filter.CategoryFilter;
import components.filter.SustainabilityFilter;

public class Filter {
	final WebDriver driver;
	private BrandFilter brandFilter;
	private CategoryFilter categoryFilter;
	private SustainabilityFilter sustainabilityFilter;
	
	public Filter(WebDriver driver) {
		this.driver=driver;
	}
	
	public BrandFilter brandFilter() {
		if(brandFilter==null)
			brandFilter=new BrandFilter(driver);
		return brandFilter;
	}
	
	public CategoryFilter categoryFilter() {
		if(categoryFilter==null)
			categoryFilter=new CategoryFilter(driver);
		return categoryFilter;
	}
	
	public SustainabilityFilter sustainabilityFilter() {
		if(sustainabilityFilter==null)
			sustainabilityFilter=new SustainabilityFilter(driver);
		return sustainabilityFilter;
	}
	
}
