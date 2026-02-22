package listnerUtility;

import java.io.File;
import java.util.Date;
import org.openqa.selenium.io.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import BaseTest.BaseClass;

public class ListnerImplementation implements ITestListener,ISuiteListener{
	
	public ExtentReports report;
	public ExtentSparkReporter spark;
	public ExtentTest test;
	@Override
	public void onStart(ISuite suite) {
		Date date =new Date();
		String newDate = date.toString().replace(" ","_").replace(":","_");
		spark=new ExtentSparkReporter("./AdvanceReports/report_"+newDate+".html");
		spark.config().setDocumentTitle("NinzaCRM Test Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows 10");
		Reporter.log("Report Config",true);
	}

	@Override
	public void onFinish(ISuite suite) {
		report.flush();
		Reporter.log("Report backup",true);
	}

	

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		
		String testName = result.getMethod().getMethodName();
		Reporter.log("==execution Stearted =="+testName,true);
		test = report.createTest(testName);
		test.log(Status.INFO,"===="+testName+"Execution STARTED====");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		String testName = result.getMethod().getMethodName();
		test.log(Status.PASS,"===="+testName+"Execution SUCCESS====");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		String testName = result.getMethod().getMethodName();
		Date date =new Date();
		String newDate = date.toString().replace(" ", "_").replace(":", "_");
		TakesScreenshot ts =(TakesScreenshot)BaseClass.sDriver;
	    String src = ts.getScreenshotAs(OutputType.BASE64);
	   test.addScreenCaptureFromBase64String(src);
	   
		test.log(Status.FAIL,"===="+testName+"Execution FAILED====");
	    
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
		String testName = result.getMethod().getMethodName();
		Reporter.log("==execution Skipped =="+testName,true);
		test.log(Status.SKIP,"===="+testName+"Execution Skipped====");
	}

}
