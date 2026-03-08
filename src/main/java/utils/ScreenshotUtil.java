package utils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



import base.DriverFactory;

public class ScreenshotUtil {

	public static String capture(String screenshotName) {
		WebDriver driver=DriverFactory.getDriver();
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path="test-reports/screenshots/"+screenshotName+".png";
		try {
			Files.createDirectories(new File("test-reports/screenshots").toPath());
			Files.copy(src.toPath(), new File(path).toPath(),
					StandardCopyOption.REPLACE_EXISTING);
		}
		catch(Exception e) {
			
		}
		return "screenshots/"+screenshotName+".png";
	}
}
