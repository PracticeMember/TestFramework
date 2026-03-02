package components.filter;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BrandFilter {
	
	private static final Logger log = LoggerFactory.getLogger(BrandFilter.class);
	final WebDriver driver;
	public BrandFilter(WebDriver driver) {
		this.driver=driver;
	}
	
	/**
	 * @param select accepts true for select or false for deselect
	 * @param brands brandname, could be zero or more, zero means no operation performed
	 */
	public void selectBrand(boolean select,String... brands) {
		for(String brand: brands) {
		By brandLocator=By.xpath("//label[input[@name='brand_id'] and normalize-space(.)='"+brand+"']");
		WebElement ele=driver.findElement(brandLocator);
		if(select) {
			if(!ele.isSelected()) {
				ele.click();
				log.info("Selecting brand: {}",brand);
			}
		}
		else {
			if(ele.isSelected()) {
				log.info("Deselecting brand: {}",brand);
				ele.click();
			}
		 }
		}
	}
	
	/**
	 * Read brand names from UI
	 * @return list of brand names
	 */
	public List<String> getBrandsNamesUI(){
		List<WebElement> brands=driver.findElements(By.xpath("//label[.//input[@name='brand_id']]"));
		return brands.stream().map(brand->brand.getText().trim())
				.collect(Collectors.collectingAndThen(Collectors.toList(),list->{
					log.info("Read filter brands: {} ",list);
					return list;
				}));
	}
}
