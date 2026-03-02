package manager;

import org.openqa.selenium.WebDriver;

import base.DriverFactory;
import pages.ForgotPasswordPage;
import pages.HomePage;
import pages.LoginPage;
import pages.NavigatePage;
import pages.ProductDetailsPage;
import pages.RegisterAccountPage;

public class PageManager {
	private WebDriver driver;
	private HomePage homePage;
	private LoginPage loginPage;
	private NavigatePage navigatePage;
	private RegisterAccountPage registerPage;
	private ForgotPasswordPage forgotPasswordPage;
	private ProductDetailsPage productsDetailsPage;
	
	public PageManager() {
		this.driver=DriverFactory.getDriver();
	}
	
	public HomePage home() {
		if(homePage==null)
			homePage=new HomePage(driver);
		return homePage;
	}
	
	public NavigatePage navigateTo() {
		if(navigatePage==null)
			navigatePage=new NavigatePage(driver);
		return navigatePage;
	}
	
	public LoginPage login() {
		 if(loginPage==null)
			 loginPage=new LoginPage(driver);
		return loginPage;
	}
	
	public RegisterAccountPage register() {
		if(registerPage==null)
			registerPage=new RegisterAccountPage(driver);
		return registerPage;
	}
	
	public ForgotPasswordPage forgotPassword() {
		if(forgotPasswordPage==null)
			forgotPasswordPage=new ForgotPasswordPage(driver);
		return forgotPasswordPage;
	}
	
	public ProductDetailsPage productDetails() {
		if(productsDetailsPage==null)
			productsDetailsPage=new ProductDetailsPage(driver);
		return productsDetailsPage;
	}
}
