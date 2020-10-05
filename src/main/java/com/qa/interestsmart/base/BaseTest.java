package com.qa.interestsmart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.interestsmart.pages.LandingPage;
import com.qa.interestsmart.pages.LoanDetails;
import com.qa.interestsmart.pages.SignInPage;
import com.qa.interestsmart.pages.SignInToApplication;

public class BaseTest {

	WebDriver driver;
	public Properties prop;
	public BasePage basePage;
	public LandingPage landingPage;
	public SignInPage signInPage;
	public SignInToApplication signInToApplication;
	public LoanDetails loanDetails;
	public ExtentTest test;
	public static ExtentReports extent;
	
	@Parameters({ "browser" })
	@BeforeMethod
	public void setUp(@Optional("chrome") String browserName) {
		System.out.println("browserName is : " + browserName);
		basePage = new BasePage();
		prop = basePage.init_prop();
		prop.setProperty("browser", browserName);
		driver = basePage.init_driver(prop);
		landingPage = new LandingPage(driver);
		signInPage = new SignInPage(driver);
		signInToApplication = new SignInToApplication(driver);
		loanDetails = new LoanDetails(driver,test);
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		// driver.quit();
	}

}
