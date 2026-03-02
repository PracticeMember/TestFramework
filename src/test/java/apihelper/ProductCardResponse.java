package apihelper;


import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ProductCardResponse {
	
	final RequestSpecification api;
	public ProductCardResponse(RequestSpecification api) {
		this.api=new RequestSpecBuilder()
				.addRequestSpecification(api).setBasePath("/products").build();
	}
		
		public List<Map<String,String>> getAllProducts(Map<String,String>queryParams) {	
			List<Map<String,String>> products=new ArrayList<>();
			Response response=given().spec(api).queryParams(queryParams).when().get();
			JsonNode cardsNode=response.as(JsonNode.class).path("data");
			for(JsonNode card: cardsNode) {
				Map<String,String>map=new HashMap<>();
				map.put("name", card.path("name").asText());
				map.put("price", card.path("price").asText());
				map.put("co2_rating", card.path("co2_rating").asText());
				map.put("in_stock", card.path("in_stock").asText());
				products.add(map);
			}
			return products;
		}
}
