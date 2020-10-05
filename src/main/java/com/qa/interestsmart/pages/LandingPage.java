package com.qa.interestsmart.pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.http.HttpConnection;
import org.apache.http.impl.HttpConnectionMetricsImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.qa.interestsmart.base.BasePage;
import com.qa.interestsmart.utils.Constants;
import com.qa.interestsmart.utils.ElementUtil;

public class LandingPage extends BasePage {
	
	private static final Logger logger = LogManager.getLogger(LandingPage.class);

	private WebDriver driver;
	ElementUtil elementUtil;
	
	// By Locators - Landing Page
	private By IshlLogoOnLandingPage = By.xpath("//div[@class='main-header__row']//img");
	private By signInLinkOnLandingPage = By.xpath("//div[@class='main-header__actions']/a[text()='Sign In']");

	// Constructor of the page:
	public LandingPage(WebDriver driver) {
		elementUtil = new ElementUtil(driver);
		this.driver = driver;
	}

	// Page Actions:
	public void getLandingTitle() {
		 String landingPageTitle = elementUtil.waitForTitlePresent(Constants.LANDING_PAGE_TITLE, 10);
		 Assert.assertEquals(landingPageTitle, Constants.LANDING_PAGE_TITLE);
		 logger.info("Landing page title is " + landingPageTitle);
	}
	
//	public void getIshlLogoSizeOnLandingPage()
//	{
//		int heightOfLogo = elementUtil.getElement(IshlLogoOnLandingPage).getSize().getHeight();
//		int widthOfLogo = elementUtil.getElement(IshlLogoOnLandingPage).getSize().getWidth();
//		System.out.println("Height is -> " + heightOfLogo);
//		System.out.println("Width is -> " + widthOfLogo);
//		Assert.assertEquals(heightOfLogo, Constants.LANDING_PAGE_LOGO_HEIGHT, "ISHL landing page logo height is not matching");
//		Assert.assertEquals(widthOfLogo, Constants.LANDING_PAGE_LOGO_WIDTH, "ISHL landing page logo width is not matching");
//	}
//	
//	public void checkSignInLinkIsActiveOnLandingPage()
//	{
//		
//		String linkUrl = elementUtil.getElement(signInLinkOnLandingPage).getAttribute("href");
//		connectionStatus(linkUrl);
//		//System.out.println(connectionStatus(linkUrl));
//		
//	}
	
//	public boolean connectionStatus(String linkUrl)
//	{
//		boolean isLinkActive = false;
//		try {
//			URL url = new URL(linkUrl);
//			HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
//			httpURLConnection.setConnectTimeout(3000);
//			httpURLConnection.connect();
//			System.out.println(httpURLConnection.getResponseCode());
//			if (httpURLConnection.getResponseCode() == 200) {
//				isLinkActive = true;
//				return isLinkActive;
//			}
//			else {
//				isLinkActive = false;
//				return isLinkActive;
//			}
//			
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return isLinkActive;
//	}
	
	
	
	
	
}
