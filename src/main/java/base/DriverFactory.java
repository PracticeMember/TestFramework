package base;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
 
	static ThreadLocal<WebDriver> threadLocal=new ThreadLocal<>();
	
	public static WebDriver getDriver() {
		return threadLocal.get();
	}
	
	public static void setDriver(WebDriver driver) {
		 threadLocal.set(driver);
	}
	
	public static void removeDriver() {
		if(threadLocal.get()!=null)
			threadLocal.get().quit();
		threadLocal.remove();
	}
}
