package com.qa.interestsmart.pages;

import java.util.ArrayList;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import com.qa.interestsmart.base.BasePage;
import com.qa.interestsmart.utils.CommonUtil;
import com.qa.interestsmart.utils.Constants;
import com.qa.interestsmart.utils.ElementUtil;
import com.qa.interestsmart.utils.JavaScriptUtil;
import com.qa.interestsmart.utils.TimeDifferenceCalculator;

public class SignInPage extends BasePage {

	private static final Logger logger = LogManager.getLogger(SignInPage.class);
	ArrayList<String> userFirstAndLastName;
	private WebDriver driver;
	ElementUtil elementUtil;
	Properties prop;
	TimeDifferenceCalculator timeDiffCal;
	SoftAssert softAssert = new SoftAssert();
	JavaScriptUtil javascriptutil ;
	// By Locators
	// Landing Page
	private By signInButtonOnLandingPage = By.xpath("//div[@class='main-header__actions']//a[text()='Sign In']");
	private By signUpHereLinkOnSignInPage = By.xpath("//a[text()='Sign up here']");
	private By createAnAccountButtonOnSignUpPage = By.xpath("//button[text()='Create Account']");

	//
	private By signInWithFacebookButton = By.id("fb-login");
	private By facebookEmailAddressOrPhoneNumberTextbox = By.id("email");
	private By facebookPassowrdTextbox = By.id("pass");
	private By facebookPageLoginButton = By.name("login");

	// Sign In Page
	private By emailField = By.id("email");
	private By passwordField = By.id("password");
	private By signInButton = By.id("sign-in-btn");
	private By enterEmailIdToolTip = By.id("email-error");
	private By enterPasswordToolTip = By.id("password-error");
	private By invalidCredentialsToolTip = By.xpath("//div//p[text()='These credentials do not match our records.']");

	// After Sign In Page
	private By myPropertiesText = By.xpath("//div[text()='My Properties']");
	private By userDetails = By.xpath("//div[@class='app-layout__action']//div[@class='user__name']");

	private By username = By
			.xpath("//div[@class='app-layout__action']//div[@class='user__name'][contains(text(),'Tejas Ghad')]");

	private By logoutButton = By.partialLinkText("Log O");

	// Constructor of the page
	public SignInPage(WebDriver driver) {
		elementUtil = new ElementUtil(driver);
		this.driver = driver;
		prop = super.init_prop();
		timeDiffCal = new TimeDifferenceCalculator();
		javascriptutil=  new JavaScriptUtil(driver);
	}

	// Page Actions:
	public String clickOnSignInButton() {
		elementUtil.clickWhenReady(signInButtonOnLandingPage, 20);
		logger.info("Clicked on Sign In button");
		elementUtil.waitForUrl(Constants.SIGNIN_PAGE_URL, 20);
		return driver.getCurrentUrl();
	}

	public ArrayList<Boolean> checkForEmailIdAndPassordFieldOnSignInPageIsDisplayed() {
		elementUtil.clickWhenReady(signInButtonOnLandingPage, 20);
		logger.info("Clicked on Sign In button");
		elementUtil.waitForElementToBeVisible(emailField, 20);
		boolean isEmailIdElementPresent = elementUtil.getElement(emailField).isDisplayed();
		elementUtil.waitForElementToBeVisible(passwordField, 20);
		boolean isPasswordElementPresent = elementUtil.getElement(passwordField).isDisplayed();

		ArrayList<Boolean> checkFiledResult = new ArrayList<>();
		checkFiledResult.add(isEmailIdElementPresent);
		checkFiledResult.add(isPasswordElementPresent);
		return checkFiledResult;
	}

	public ArrayList<Boolean> checkTooltipForEmailAndPasswordFieldIsDispalyed() {
		elementUtil.clickWhenReady(signInButtonOnLandingPage, 20);
		logger.info("Clicked on Sign In button");
		elementUtil.waitForElementToBeVisible(emailField, 20);
		elementUtil.waitForElementToBeVisible(passwordField, 20);
		elementUtil.clickWhenReady(signInButton, 20);
		elementUtil.waitForElementToBeVisible(enterEmailIdToolTip, 20);
		boolean isTooltipForEmailIdPresent = elementUtil.doIsDisplayed(enterEmailIdToolTip);
		elementUtil.waitForElementToBeVisible(enterPasswordToolTip, 20);
		boolean isTooltipForPasswordPresent = elementUtil.doIsDisplayed(enterPasswordToolTip);

		ArrayList<Boolean> checkTooltipFiledResult = new ArrayList<>();
		checkTooltipFiledResult.add(isTooltipForEmailIdPresent);
		checkTooltipFiledResult.add(isTooltipForPasswordPresent);
		return checkTooltipFiledResult;
	}

	public ArrayList<Boolean> checkTooltipForEmailAndPasswordEnteredWithSpaces() {
		elementUtil.clickWhenReady(signInButtonOnLandingPage, 20);
		logger.info("Clicked on Sign In button");
		elementUtil.waitForElementToBeVisible(emailField, 20);
		elementUtil.waitForElementToBeVisible(passwordField, 20);
		elementUtil.doSendKeys(emailField, "    "); // 4 - Spaces
		elementUtil.doSendKeys(passwordField, "    "); // 4 - Spaces
		elementUtil.clickWhenReady(signInButton, 20);
		elementUtil.waitForElementToBeVisible(enterEmailIdToolTip, 20);
		boolean isTooltipDispalyedForEmailIdField = elementUtil.doIsDisplayed(enterEmailIdToolTip);

		ArrayList<Boolean> checkTooltipFiledResultForSpaces = new ArrayList<>();
		checkTooltipFiledResultForSpaces.add(isTooltipDispalyedForEmailIdField);
		return checkTooltipFiledResultForSpaces;
	}

	public boolean checkForToolTipWithEmailIdAndBlankPasswordAndClickOnSignInButton() {
		elementUtil.clickWhenReady(signInButtonOnLandingPage, 20);
		logger.info("Clicked on Sign In button");
		elementUtil.waitForElementToBeVisible(emailField, 20);
		elementUtil.waitForElementToBeVisible(passwordField, 20);
		elementUtil.doSendKeys(emailField, prop.getProperty("username")); // fetching
																			// from
																			// config.file
		elementUtil.doSendKeys(passwordField, ""); // Blank
		elementUtil.clickWhenReady(signInButton, 20);
		elementUtil.waitForElementToBeVisible(enterPasswordToolTip, 20);
		boolean isTooltipDispalyedForBlankPasswordFiled = elementUtil.doIsDisplayed(enterPasswordToolTip);
		return isTooltipDispalyedForBlankPasswordFiled;
	}

	public ArrayList<String> checkTimeToSignInTheApplicationWithValidEmailIdAndPassword() {
		elementUtil.clickWhenReady(signInButtonOnLandingPage, 20);
		logger.info("Clicked on Sign In button");
		elementUtil.waitForElementToBeClickable(emailField, 20);
		elementUtil.waitForElementToBeClickable(passwordField, 20);
		elementUtil.doActionsSendKeys(emailField, prop.getProperty("username")); // fetching
																					// from
																					// config.file
		elementUtil.doActionsSendKeys(passwordField, prop.getProperty("password")); // fetching
																					// from
																					// config.file
		elementUtil.clickWhenReady(signInButton, 20);
		elementUtil.waitForElementToBeVisible(userDetails, Constants.LOGIN_TIME_MAX_LIMIT);
		String signInUsersFirstAndLastName = elementUtil.doGetText(userDetails);
		String[] splitUserFirstNameAndLastNameCompanyName = signInUsersFirstAndLastName.split(" "); // splits
																									// as
																									// -
																									// "er"
																									// "fds\nINTEREST"
																									// "SMART"
		String[] userLastNameAndCompanyName = splitUserFirstNameAndLastNameCompanyName[1].split("\n");
		String userFirstName = splitUserFirstNameAndLastNameCompanyName[0];
		String userLastName = userLastNameAndCompanyName[0];
		logger.info("1. User First Name after login is " + userFirstName);
		logger.info("2. User Last Name after login is " + userLastName);

		ArrayList<String> userFirstAndLastName = new ArrayList<String>();
		userFirstAndLastName.add(userFirstName);
		userFirstAndLastName.add(userLastName);
		return userFirstAndLastName;
	}

	public ArrayList<Object> checkTimeToSignInTheApplicationWithInvalidEmailIdAndPassword() {
		elementUtil.clickWhenReady(signInButtonOnLandingPage, 20);
		logger.info("Clicked on Sign In button");
		elementUtil.waitForElementToBeClickable(emailField, 20);
		elementUtil.waitForElementToBeClickable(passwordField, 20);
		elementUtil.doActionsSendKeys(emailField, Constants.INVALID_EMAILID); // fetching
																				// from
																				// Constants
																				// class
																				// for
																				// utils
																				// package
		elementUtil.doActionsSendKeys(passwordField, Constants.INVALID_PASSWORD); // fetching
																					// from
																					// Constants
																					// class
																					// for
																					// utils
																					// package
		elementUtil.clickWhenReady(signInButton, 20);
		elementUtil.waitForElementPresent(invalidCredentialsToolTip, 20);
		boolean isTooltipDisplayedForInvalidCredentials = elementUtil.doIsDisplayed(invalidCredentialsToolTip);
		String textOfInvalidCredentialsTooltip = elementUtil.doGetText(invalidCredentialsToolTip);
		boolean isUserAbleToLogin = true;
		try {
			elementUtil.waitForElementPresent(userDetails, 5);
		} catch (Exception e) {
			isUserAbleToLogin = false;
		}
		ArrayList<Object> conditionsForUserLoginWithInvalidCredentials = new ArrayList<Object>();
		conditionsForUserLoginWithInvalidCredentials.add(isTooltipDisplayedForInvalidCredentials); // adding
																									// status
																									// of
																									// error
																									// msg
																									// tooltip
																									// is
																									// displayed
		conditionsForUserLoginWithInvalidCredentials.add(textOfInvalidCredentialsTooltip); // adding
																							// error
																							// message
																							// of
																							// the
																							// error
																							// msg
																							// tooltip
		conditionsForUserLoginWithInvalidCredentials.add(isUserAbleToLogin); // adding
																				// status
																				// of
																				// is
																				// user
																				// able
																				// to
																				// signin
																				// the
																				// application
		return conditionsForUserLoginWithInvalidCredentials;
	}

	public String checkThePasswordEnteredIsInEncryptedFrom() {
		elementUtil.clickWhenReady(signInButtonOnLandingPage, 20);
		logger.info("Clicked on Sign In button");
		elementUtil.waitForElementToBeClickable(passwordField, 20);
		elementUtil.doActionsSendKeys(passwordField, prop.getProperty("password")); // fetching
																					// from
																					// config.file
		String passwordFiledTextAttributeByDefault = elementUtil.getElement(passwordField).getAttribute("type");
		return passwordFiledTextAttributeByDefault;
	}

	public long checkTimeToLoginIntoTheApplication() {
		elementUtil.clickWhenReady(signInButtonOnLandingPage, 20);
		logger.info("Clicked on Sign In button");
		elementUtil.waitForElementToBeClickable(emailField, 20);
		elementUtil.waitForElementToBeClickable(passwordField, 20);
		elementUtil.doActionsSendKeys(emailField, prop.getProperty("username")); // fetching
																					// from
																					// config.file
		elementUtil.doActionsSendKeys(passwordField, prop.getProperty("password")); // fetching
																					// from
																					// config.file
		elementUtil.clickWhenReady(signInButton, 20);
		String timeAfterSignInBtnClicked = timeDiffCal.getCurrentDateAndTime();
		elementUtil.waitForElementToBeVisible(userDetails, Constants.LOGIN_TIME_MAX_LIMIT);
		String timeAfterUsersNameIsDispalyed = timeDiffCal.getCurrentDateAndTime();
		long timeToLoginApplication = timeDiffCal.timedifferenceCalculator(timeAfterSignInBtnClicked,
				timeAfterUsersNameIsDispalyed);
		if (timeToLoginApplication <= 0) {
			logger.info("Time of clicking the SignIn button is " + timeAfterSignInBtnClicked);
			// Logger.info("Time after logged in into the application " +
			// timeAfterUsersNameIsDispalyed);
			logger.info("Time taken to login the application after clicking on signin button is less than a Second");
		} else {
			logger.info("Time of clicking the SignIn button is " + timeAfterSignInBtnClicked);
			// Logger.info("Time after logged in into the application " +
			// timeAfterUsersNameIsDispalyed);
			logger.info("Time taken to login the application after clicking on signin button is -> "
					+ timeToLoginApplication + " Seconds");
		}
		return timeToLoginApplication;
	}

	public Object[] checkAfterClickingOnSignInHereLinkFromSignInPagePageRedirectingToSignUpPage() {
		elementUtil.clickWhenReady(signInButtonOnLandingPage, 20);
		logger.info("Clicked on Sign In button");
		elementUtil.clickWhenReady(signUpHereLinkOnSignInPage, 20);
		logger.info("Clicked on \"Sign in here\"");
		elementUtil.waitForUrl(Constants.SIGNUP_PAGE_URL, 20);
		String ActualSignUpPageUrl = elementUtil.getCurrentPageUrl();
		elementUtil.waitForElementPresent(createAnAccountButtonOnSignUpPage, 20);
		boolean isCreateAccountButtonDisplayed = elementUtil.doIsDisplayed(createAnAccountButtonOnSignUpPage);

		Object[] signUpPageValidationPoints = new Object[2];
		signUpPageValidationPoints[0] = ActualSignUpPageUrl;
		signUpPageValidationPoints[1] = isCreateAccountButtonDisplayed;

		return signUpPageValidationPoints;
	}

	public Object[] checkAfterClickingOnSignInWithFacebookButtonUserRedirectedToFacebookLoginPage() {
		elementUtil.clickWhenReady(signInButtonOnLandingPage, 20);
		logger.info("Clicked on Sign In button");
		elementUtil.clickWhenReady(signInWithFacebookButton, 20);
		logger.info("Clicked on \"Sign in with Facebook\" button");
		elementUtil.waitForWindowPresentAndSwitchToIt(2, 20);
		elementUtil.switchToWindowId(driver, 1);
		String facebookPageUrl = elementUtil.getCurrentPageUrl();
		logger.info("Facebook Page URL is " + facebookPageUrl);
		boolean isFacebookpageUrlCorrect = false;
		if (facebookPageUrl.contains("https://www.facebook.com/login")) {
			isFacebookpageUrlCorrect = true;
		}
		elementUtil.waitForElementToBeVisible(facebookPageLoginButton, 20);
		boolean isFacebookLogInButtonDispalyed = elementUtil.doIsDisplayed(facebookPageLoginButton);

		Object[] facebookPagePageValidationPoints = new Object[2];
		facebookPagePageValidationPoints[0] = isFacebookpageUrlCorrect;
		facebookPagePageValidationPoints[1] = isFacebookLogInButtonDispalyed;
		return facebookPagePageValidationPoints;
	}

	public ArrayList<String> checkUserIsAbleLoginUsingFacebookAfterClickingOnSigninWithFacebookFromSigninPage() {
		try {
			elementUtil.clickWhenReady(signInButtonOnLandingPage, 20);
			logger.info("Clicked on Sign In button");
			elementUtil.clickWhenReady(signInWithFacebookButton, 20);
			logger.info("Clicked on \"Sign in with Facebook\" button");
			elementUtil.waitForWindowPresentAndSwitchToIt(2, 20);
			elementUtil.switchToWindowId(driver, 1);
			elementUtil.waitForElementPresent(facebookEmailAddressOrPhoneNumberTextbox, 20);
			elementUtil.doActionsSendKeys(facebookEmailAddressOrPhoneNumberTextbox,
					prop.getProperty("facebookUserEmailID"));
			elementUtil.waitForElementPresent(facebookPassowrdTextbox, 20);
			elementUtil.doActionsSendKeys(facebookPassowrdTextbox, prop.getProperty("facebookUserPassword"));
			elementUtil.clickWhenReady(facebookPageLoginButton, 20);
			CommonUtil.MediumWait();
			elementUtil.switchToWindowId(driver, 0);

			elementUtil.waitForElementToBeVisible(userDetails, Constants.LOGIN_TIME_MAX_LIMIT);
			String signInUsersFirstAndLastName = elementUtil.doGetText(userDetails);
			String[] splitUserFirstNameAndLastNameCompanyName = signInUsersFirstAndLastName.split(" "); // splits
																										// as
																										// -
																										// "er"
																										// "fds\nINTEREST"
																										// "SMART"
			String[] userLastNameAndCompanyName = splitUserFirstNameAndLastNameCompanyName[1].split("\n");
			String userFirstName = splitUserFirstNameAndLastNameCompanyName[0];
			String userLastName = userLastNameAndCompanyName[0];
			logger.info("1. User First Name after login is " + userFirstName);
			logger.info("2. User Last Name after login is " + userLastName);

			userFirstAndLastName = new ArrayList<String>();
			userFirstAndLastName.add(userFirstName);
			userFirstAndLastName.add(userLastName);
			getScreenshot("User login into facebook");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userFirstAndLastName;

	}

	public void verifyFacebookFirstNameLastName() {
		try {
			softAssert.assertEquals(userFirstAndLastName.get(0), prop.getProperty("facebookUserFirstName"),
					"AFTER LOGIN USERS FIRSTNAME IS NOT MATCHING WITH THE FACEBOOK USERS FIRST NAME");
			softAssert.assertEquals(userFirstAndLastName.get(1), prop.getProperty("facebookUserLastName"),
					"AFTER LOGIN USERS LASTNAME IS NOT MATCHING WITH THE FACEBOOK USERS LAST NAME");
			softAssert.assertAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void userLogoutOfFacebook() {
		try {
			elementUtil.waitForElementToBeClickable(username, 10);
			javascriptutil.clickElementByJS(driver.findElement(username));
			getScreenshot("User click logout button");
			elementUtil.waitForElementToBeClickable(logoutButton, 10);
			javascriptutil.clickElementByJS(driver.findElement(logoutButton));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
