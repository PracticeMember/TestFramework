package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductCard {
 
	private WebElement root;
	
	public ProductCard(WebElement root) {
		this.root=root;
	}
	
	public String getName() {
		return root.findElement(By.cssSelector("[data-test='product-name']")).getText();
	}
	
	public String getPrice() {
		return root.findElement(By.cssSelector("[data-test='product-price']"))
				.getText().replace("$", "");
	}
	
	public String ratingBadgeCO2() {
		return root.findElement(By.xpath("//*[@data-test='co2-rating-badge']//span[contains(@class,'active')]")).getText();
	}
	
	public boolean isInStock() {
		try {
		root.findElement(By.cssSelector("[data-test='out-of-stock']")).isDisplayed(); 
		return false;
		}
		catch(Exception e) {}
		return true;
	}
}
