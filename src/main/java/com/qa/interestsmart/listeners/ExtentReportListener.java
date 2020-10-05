package com.qa.interestsmart.listeners;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qa.interestsmart.base.BasePage;

public class ExtentReportListener extends BasePage implements ITestListener {
	
	private static final Logger logger = LogManager.getLogger(ExtentReportListener.class);
	
	private static String DocumentTitle = "Interest Smart";
	private static String ReportName = "Automation Test Result for Interest Smart";
	private static String currentDateAndTime = getCurrentDateAndTimeIn_DD_MM_YYYY_HH_MM_SS();
	private static final String OUTPUT_FOLDER = "./build/";
	private static final String FILE_NAME = "InterestSmart_TestExecutionReport_"+currentDateAndTime+".html";

	private static ExtentReports extent = init();
	public static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();

	private static ExtentReports init() {

		Path path = Paths.get(OUTPUT_FOLDER);
		// if directory exists?
		if (!Files.exists(path)) {
			try {
				Files.createDirectories(path);
				logger.info("Created build folder to save Extent Reports at path " + OUTPUT_FOLDER);
			} catch (IOException e) {
				// fail to create directory
				e.printStackTrace();
				logger.info("Failed to create build folder to save Extent Reports");
			}
		}
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(OUTPUT_FOLDER + FILE_NAME);
		htmlReporter.config().setDocumentTitle(DocumentTitle);
		htmlReporter.config().setReportName(ReportName);
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setReportUsesManualConfiguration(true);

		return extent;
	}

	public synchronized void onStart(ITestContext context) {
		System.out.println("Test Suite started!");
		logger.info("Test Suite started!");
	}

	public synchronized void onFinish(ITestContext context) {
		System.out.println("Test Suite is ending!");
		logger.info("Test Suite is ending!");
		extent.flush();
		test.remove();
	}

	public synchronized void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		String qualifiedName = result.getMethod().getQualifiedName();		
		int last = qualifiedName.lastIndexOf(".");
		int mid = qualifiedName.substring(0, last).lastIndexOf(".");
		String className = qualifiedName.substring(mid + 1, last);

		System.out.println(methodName + " started!");
		logger.info(methodName + " started!" );
		ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(),
				result.getMethod().getDescription());

		extentTest.assignCategory(result.getTestContext().getSuite().getName());
		/*
		 * methodName = StringUtils.capitalize(StringUtils.join(StringUtils.
		 * splitByCharacterTypeCamelCase(methodName), StringUtils.SPACE));
		 */
		extentTest.assignCategory(className);
		test.set(extentTest);
		test.get().getModel().setStartTime(getTime(result.getStartMillis()));
	}

	public synchronized void onTestSuccess(ITestResult result) {
		System.out.println((result.getMethod().getMethodName() + " passed!"));
		logger.info((result.getMethod().getMethodName() + " passed!"));
		test.get().pass("Test passed");
		test.get().getModel().setEndTime(getTime(result.getEndMillis()));
	}

	public synchronized void onTestFailure(ITestResult result) {
		System.out.println((result.getMethod().getMethodName() + " failed!"));
		logger.info((result.getMethod().getMethodName() + " failed!"));
		try {
			test.get().fail(result.getThrowable(),MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot()).build());
			logger.info("Attaching screenshot in extent report for failed testcase name -> " + (result.getMethod().getMethodName()));
		} catch (IOException e) {
			System.err.println("Exception thrown while updating test fail status " + Arrays.toString(e.getStackTrace()));
			logger.info("Exception thrown while updating test fail status " + Arrays.toString(e.getStackTrace()));
		}
		test.get().getModel().setEndTime(getTime(result.getEndMillis()));
	}

	public synchronized void onTestSkipped(ITestResult result) {
		System.out.println((result.getMethod().getMethodName() + " skipped! on " + getBrowserName()));
		try {
			test.get().skip(result.getThrowable(),
					MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot()).build());
			logger.info("Attaching screenshot in extent report for skipped testcase name -> " + (result.getMethod().getMethodName()));
		} catch (IOException e) {
			System.err
					.println("Exception thrown while updating test skip status " + Arrays.toString(e.getStackTrace()));
			logger.info("Exception thrown while updating test skip status " + Arrays.toString(e.getStackTrace()));
		}
		test.get().getModel().setEndTime(getTime(result.getEndMillis()));
	}

	public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println(("onTestFailedButWithinSuccessPercentage for " + result.getMethod().getMethodName()));
		logger.info(("onTestFailedButWithinSuccessPercentage for " + result.getMethod().getMethodName()));
	}

	private Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}
	
	private static String getCurrentDateAndTimeIn_DD_MM_YYYY_HH_MM_SS()
	{
		Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        
        String currentDateAndTime = formater.format(calendar.getTime());
        return currentDateAndTime;
	}
	
	// Not In Use for now
	private static String dateFormatIn_YYYY_MM_DD_HH_MM_SS()
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		Date date = new Date();
		System.out.println();
		String StringDate = dateFormat.format(date);
		return StringDate;
	}

}
