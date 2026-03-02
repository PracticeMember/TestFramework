package manager;

import apihelper.FilterApiResponse;
import apihelper.ProductCardResponse;
import io.restassured.specification.RequestSpecification;

public class ApiManager {
 
	private RequestSpecification api;
	private FilterApiResponse filter;
	private ProductCardResponse productCard;
	
	public ApiManager(RequestSpecification api) {
		this.api=api;
		this.filter=new FilterApiResponse(api);
		this.productCard=new ProductCardResponse(api);
	}
	
	public FilterApiResponse filter() {
		if(filter==null)
			filter=new FilterApiResponse(api);
		return filter;
	}
	
	public ProductCardResponse productCard() {
		if(productCard==null)
			productCard=new ProductCardResponse(api);
		return productCard;
	}
}
