package tests;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import base.DriverFactory;
import components.ProductCard;
import junit.framework.Assert;
import manager.ApiManager;
import manager.PageManager;
import reports.ExtentTestManager;

public class HomePageTest extends BaseTest{
	private final static Logger log=LoggerFactory.getLogger(HomePageTest.class);
	
	@Test(description="Verify that Brand Names under Filter section matches with Api response")
	public void shouldMatchUIBrandNamesUnderFiltersWithApi() {
		page.navigateTo().openSoftwareTestingPage();
		ExtentTestManager.screenshot("Navigated to Software Testing Page");
		List<String>brandsFromApi=api.filter().getAllBrands();
		ExtentTestManager.info("Triggered API endpoint for filter brand names");
		List<String>brandsFromUI=page.home().filter().brandFilter().getBrandsNamesUI();
		ExtentTestManager.screenshot("Read filter Brands names from UI");
		Assert.assertTrue(brandsFromApi.size()>0);
		Assert.assertEquals("Brands from API and UI are not equal",brandsFromApi, brandsFromUI);
		ExtentTestManager.pass("Compared filter brands from API with UI brands Successfully");
	}
	
	@Test(description="Verify that Category Names under Filter section matches with Api response")
	public void shouldMatchUICategoryNamesUnderFiltersWithApi() {
		page.navigateTo().openSoftwareTestingPage();
		List<String>categoriesFromApi=api.filter().getAllCategories();
		List<String>categoriesFromUI=page.home().filter().categoryFilter().getCategoryNamesUI();
		Assert.assertTrue(categoriesFromApi.size()>0);
		Assert.assertEquals(categoriesFromApi, categoriesFromUI);
	}
	
	@Test(description="Verify that Product Cards matches with Api response")
	public void shouldMatchUIProductCardInfoWithApi() throws InterruptedException, ExecutionException {
		Map<String,String>queryParams=new HashMap<>();
		page.navigateTo().openSoftwareTestingPage();
		var home=page.home();
		String pageNo=home.getPageNo();
		String priceMin=home.priceRange().getMinPrice();
		String priceMax=home.priceRange().getMaxPrice();
		
		queryParams.put("between", "price,"+priceMin+","+priceMax);
		queryParams.put("is_rental", "false");
		queryParams.put("page", pageNo);
		
		List<Map<String,String>>productsFromApi=api.productCard().getAllProducts(queryParams);
		List<ProductCard>productCardsUI=home.getAllProducts();
		Assert.assertTrue(productsFromApi.size()>0);
		int i=0;
		for(var product: productsFromApi) {
			ProductCard productCard=productCardsUI.get(i);
			log.info("Product {}",productCard.getName());
			Assert.assertEquals(product.get("name"), productCard.getName());
			Assert.assertEquals(product.get("price"),productCard.getPrice());
			Assert.assertEquals(product.get("in_stock"),String.valueOf(productCard.isInStock()));
			Assert.assertEquals(product.get("co2_rating"), productCard.ratingBadgeCO2());
		    i++;
		}
	}
	
	
	
}
