package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

	private static ExtentReports extent;
	
	public static ExtentReports getInstance() {
		if(extent==null) {
			ExtentSparkReporter reporter=new ExtentSparkReporter("test-reports/ExtentReporter.html");
			reporter.config().enableOfflineMode(true);
			reporter.config().setTimelineEnabled(true);
			extent=new ExtentReports();
			extent.attachReporter(reporter);
		}
		return extent;
	}
}
