package extentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class extentReporter {
	public static ExtentReports extent;
	public static ExtentTest test;
	public void extentSetUp(){
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("sparkReports/SearchPageReport.html");
		extent.attachReporter(spark);
		spark.config().setTheme(Theme.DARK);
	}

	public void extentTest(String testName){
		test = extent.createTest(testName);
	}

	public void extentTearDown(){
		extent.flush();
	}
}