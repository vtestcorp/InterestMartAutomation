package com.qa.interestsmart.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.aventstack.extentreports.ExtentTest;
import com.qa.interestsmart.utils.OptionsManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	private static final Logger logger = LogManager.getLogger(BasePage.class);
	
	WebDriver driver;
	Properties prop;
	OptionsManager optionsManager;
	public static String flashElement;
	public String BROWSER_NAME;
	public ExtentTest test;
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	/**
	 * This method is used to initialize the webdriver on the basis of given
	 * browser name
	 * 
	 * @param browserName
	 * @return this returns driver
	 */
	public WebDriver init_driver(Properties prop) {

		flashElement = prop.getProperty("highlight").trim();
		String browserName = prop.getProperty("browser").trim();
		

		System.out.println("Browser Name is : " + browserName);
		logger.info("Browser Name is : " + browserName);
		BROWSER_NAME = browserName;
		optionsManager = new OptionsManager(prop);
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			// driver = new ChromeDriver(optionsManager.getChromeOptions());
			tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			// driver = new FirefoxDriver(optionsManager.getFirefoxOptions());
			tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
		} else if (browserName.equalsIgnoreCase("opera")) {
			WebDriverManager.operadriver().setup();
			tlDriver.set(new OperaDriver());
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			tlDriver.set(new EdgeDriver());
		} else if (browserName.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			tlDriver.set(new InternetExplorerDriver());
		} else if (browserName.equalsIgnoreCase("safari")) {
			// driver = new SafariDriver();
			tlDriver.set(new SafariDriver());
		}

		else {
			System.out.println("Please pass the correct browser name " + browserName);
			logger.info("Please pass the correct browser name " + browserName);
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		getDriver().get(prop.getProperty("url"));

		return getDriver();
	}

	/**
	 * getDriver using ThreadLocal
	 */
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

	/**
	 * This method is used to get the properties values from configuration file
	 * 
	 * @return it returns prop
	 */
	public Properties init_prop() {
		prop = new Properties();
		String path = null;
		String env = null;

		try {

			env = System.getProperty("env");
			//System.out.println("Running on Environment: " + env);
			if (env == null) {
				path = "./src/main/java/com/qa/interestsmart/config/config.qa.properties";
				System.out.println("Running on Environment: " + "QA");
				logger.info("Running on Environment: " + "QA");
			} 
			else {
				switch (env) {
				case "stage":
					path = "./src/main/java/com/qa/interestsmart/config/config.stage.properties";
					System.out.println("Running on Environment: " + "stage");
					logger.info("Running on Environment: " + "stage");
					break;
				case "prod":
					path = "./src/main/java/com/qa/interestsmart/config/config.stage.properties";
					System.out.println("Running on Environment: " + "prod");
					logger.info("Running on Environment: " + "prod");
					break;
				default:
					System.out.println("Please pass the correct env value for configuration file ....");
					logger.info("Please pass the correct env value for configuration file ....");
					break;
				}

			}

			FileInputStream ip = new FileInputStream(path);
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;

	}

	/**
	 * This method is used to take screenshot
	 */
	public String getScreenshot() {
		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.info("Capturing Screenshot for failed testcase");
		return path;
	}
	
	public String getScreenshot(String screenshotName) {
		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + screenshotName + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.info("Capturing Screenshot for failed testcase");
		return path;
	}
	
	public String getBrowserName()
	{
		return BROWSER_NAME;
	}

}
