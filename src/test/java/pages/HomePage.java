package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import components.Filter;
import components.PriceRange;
import components.ProductCard;
import components.Sort;

public class HomePage {
	WebDriver driver;
	private Sort sort;
	private Filter filter;
	private PriceRange price;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public Sort sort() {
		if(sort==null)
			sort = new Sort(driver);
		return sort;
	}
	
	public Filter filter() {
		if(filter==null)
			filter=new Filter(driver);
		return filter;
	}
	
	public PriceRange priceRange() {
		if(price==null)
			price=new PriceRange(driver);
		return price;
	}
	
	public List<ProductCard> getAllProducts(){
		List<WebElement> productCards=driver.findElements(By.xpath("//a[@class='card']"));
		List<ProductCard> cards=new ArrayList<>();
		for(WebElement productCard : productCards) {
			ProductCard card=new ProductCard(productCard);
			cards.add(card);
		}
		return cards;
	}
	
	public String getPageNo() {
		return driver.findElement(By.xpath("//ul[@class='pagination']//li[@class='page-item active']"))
				.getText();
	}
}
