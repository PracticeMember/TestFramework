package reports;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import utils.ScreenshotUtil;

public class ExtentTestManager {
	
	private static ThreadLocal<ExtentTest> test=new ThreadLocal<>();
	
	public static void setTest(ExtentTest extentTest) {
		test.set(extentTest);
	}
	
	public static ExtentTest getTest() {
		return test.get();
	}
	
	public static void info(String message) {
		getTest().log(Status.INFO, message);
	}
	
	public static void pass(String message) {
		getTest().log(Status.PASS, message);
	}
	
	public static void fail(String message) {
		String path=ScreenshotUtil.capture(message);
		getTest().fail("error : "+message,MediaEntityBuilder.createScreenCaptureFromPath(path).build());
	}
	
	public static void skip(String message) {
		getTest().log(Status.SKIP, message);
	}
	
	public static void screenshot(String stepName) {
		String path=ScreenshotUtil.capture(stepName);
		getTest().info(stepName,MediaEntityBuilder.createScreenCaptureFromPath(path).build());
	}
}
