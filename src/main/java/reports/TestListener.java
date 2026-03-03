package reports;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import utils.ScreenshotUtil;

public class TestListener implements ITestListener {

	private ExtentReports extent=ExtentManager.getInstance();

	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest test=extent.createTest(result.getMethod().getMethodName());
		ExtentTestManager.setTest(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentTestManager.getTest().log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String message=result.getThrowable().getMessage();
		ExtentTestManager.getTest().log(Status.FAIL, result.getThrowable());
		String path=ScreenshotUtil.capture(message);
		ExtentTestManager.getTest().fail(message,MediaEntityBuilder.createScreenCaptureFromPath(path).build());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
	
	
	
}
