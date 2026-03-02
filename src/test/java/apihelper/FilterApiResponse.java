package apihelper;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FilterApiResponse {
	final RequestSpecification api;
	
	public FilterApiResponse(RequestSpecification api) {
		this.api=api;
	}
	private final static Logger log=LoggerFactory.getLogger(FilterApiResponse.class);
	
	public List<String> getAllBrands() {
		log.info("Reading Brands from API");
		List<String> brands=new ArrayList<>();
		Response response=given().spec(api).when().get("/brands");
		JsonNode node=response.as(JsonNode.class);
		for(JsonNode brand: node) {
		brands.add(brand.path("name").asText());
		}
		log.info("Brands response from API: {}",node.toPrettyString());
		log.info("Extracted Brand names: {}",brands);
		return brands;
	}
	
	public List<String> getAllCategories(){
		log.info("Reading Filter Categories from API");
		List<String> categories = new ArrayList<>();
		Response response = given().spec(api).when().get("/categories/tree");
		JsonNode node = response.as(JsonNode.class);
		for (JsonNode category : node) {
			categories.add(category.path("name").asText());
			JsonNode subarray = category.path("sub_categories");
			for (JsonNode subcategory : subarray) {
				categories.add(subcategory.path("name").asText());
			}
		}
		log.info("Categories response from API: {}",node);
		log.info("Extracted Category names: {}",categories);
		return categories;
	}

}
