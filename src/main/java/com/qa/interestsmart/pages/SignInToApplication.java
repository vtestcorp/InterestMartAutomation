package com.qa.interestsmart.pages;

import static org.testng.Assert.assertEquals;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.qa.interestsmart.base.BasePage;
import com.qa.interestsmart.utils.Calculate;
import com.qa.interestsmart.utils.CommonUtil;
import com.qa.interestsmart.utils.Constants;
import com.qa.interestsmart.utils.ElementUtil;
import com.qa.interestsmart.utils.JavaScriptUtil;
import com.qa.interestsmart.utils.Keyboard;

public class SignInToApplication extends BasePage {

	private static final Logger logger = LogManager.getLogger(SignInToApplication.class);
	SoftAssert softAssert = new SoftAssert();
	private WebDriver driver;
	ElementUtil elementUtil;
	Properties prop;
	private double actual_RemainingBalance;
	private double actual_MonthlyPayment;

	private static double expected_MonthlyPayment;
	private static long expected_Diff_numberOfPayment;
	private static double expected_RemainingBalance;
	private static double expected_ActualEstimatedRate;

	private JavaScriptUtil javascriptutil;
	// By Locators
	// Landing Page
	private By signInButtonOnLandingPage = By.xpath("//div[@class='main-header__actions']//a[text()='Sign In']");

	// Sign In Page
	private By emailField = By.id("email");
	private By passwordField = By.id("password");
	private By signInButtonOnSignInPage = By.id("sign-in-btn");
	private By enterEmailIdToolTip = By.id("email-error");
	private By enterPasswordToolTip = By.id("password-error");
	private By invalidCredentialsToolTip = By.xpath("//div//p[text()='These credentials do not match our records.']");

	// Facebook Window Popup
	private By signInWithFacebookButton = By.id("fb-login");
	private By facebookEmailAddressOrPhoneNumberTextbox = By.id("email");
	private By facebookPassowrdTextbox = By.id("pass");
	private By facebookPageLoginButton = By.name("login");

	// Gmail Window Popup
	private By signInWithGmailButton = By.id("google-login-img");
	private By gmailEmailAddressTextbox = By.id("identifierId");
	private By afterEnterEmailIdNextButton = By.xpath("//span[text()='Next']");
	private By gmailPassowrdTextbox = By.name("password");
	private By afterEnterPasswordOfGmailNextButton = By.id("identifierId");

	// After Sign In Page
	private By pageLoder = By.id("loader");
	private By myPropertiesText = By.xpath("//div[text()='My Properties']");
	private By userDetails = By.xpath("//div[@class='app-layout__action']//div[@class='user__name']");
	private By downArrowForUserSetting = By.xpath("//div[@class='app-layout__action']//div[@class='user']"); // div[@class='user__arrow']
	private By logOutLink = By.xpath("//a[@id='log-out-c']");

	//

	private By plusButton = By.xpath("//div[@class='sidebar__ttl']//following::img[1]");
	private By searchButton = By.xpath("//input[@id='address1']");
	private By zipcode = By.xpath("//input[@id='zip_code_pop_up']");
	private By successMessage = By.xpath("//div[@id='success_msg']");

	// Loan Details
	private By startDate = By.xpath("//input[@id='start_date']");
	private By loanTerm = By.id("select2-current_loan_term-container");
	private By loanTermSearch = By.xpath("//input[@class='select2-search__field']");
	private By loanType = By.id("select2-loan_type-container");
	private By loanTypeSearch = By.xpath("//input[@class='select2-search__field']");
	private By initialBalance = By.xpath("//input[@id='amount']");
	private By remainingBalance = By.xpath("//input[@id='estimated_balance']");
	private By monthlyPayment = By.xpath("//input[@id='interest_rate_html']");
	private By go_Button = By.xpath("//button[@id='loan-details-btn']");
	private By getStarted_Button = By.xpath(
			"//div[@class='swiper-slide swiper-slide-active']//button[@class='btn btn--fill btn--full btn--medium application_flow_start'][contains(text(),'Get Started')]");
	private By continueButton = By
			.xpath("//button[@class='btn btn--fill btn--full btn--medium view_application_flow']");
	private By zestimateValue = By.xpath("//div[@class='zestimate__ttl']//following::input[1]");

	private By signInHereButton = By.xpath("//a[contains(text(),'Sign in here')]");

	private By userName = By.xpath("//div[@class='app-layout__action']//div[@class='user']");
	private By profileDropdownItem = By.xpath("//a[@class='dropdown-menu__link my-profile-c']");
//ProfileDetails
	private By firstNameProfileDetail = By.id("first_name");
	private By lastNameProfileDetail = By.id("last_name");
	private By emailProfileDetail = By.id("email");
	private By phoneProfileDetail = By.id("phone");
	private By saveProfileButton = By.id("profile_save");
	private By cancelProfileButton=By.id("reset_values");
	
	private By updateProfileMessage = By.className("alert-data text-center");
	private By clickOk = By.xpath("//button[contains(text(),'OK')]");
	private By updatedpassword = By.id("password");
	private By updatedConfirmPassword = By.id("password_confirmation");

	private By clickContinue = By.id("property_exists_btn");
	private By applicationMessage = By.xpath("//h1[contains(text(),'Application in progress')]");
	
	private By documentButton=By.xpath("//span[@class='blue-notification']");
	private By documentButtonPendingCount=By.xpath("//label[@class='count']");
	private By pendingItemCount=By.xpath("//span[@class='heading-count']");

	// Constructor of the page
	public SignInToApplication(WebDriver driver) {
		elementUtil = new ElementUtil(driver);
		this.driver = driver;
		prop = super.init_prop();
		softAssert = new SoftAssert();
		javascriptutil = new JavaScriptUtil(driver);
	}

	// Actions:

	public void checkUserLoginWithValidUsernameAndPasswordAndSignOutApplication() {
		elementUtil.clickWhenReady(signInButtonOnLandingPage, 20);
		logger.info("Clicked on Sign In button on the landing page");
		elementUtil.waitForElementToBeClickable(emailField, 20);
		elementUtil.waitForElementToBeClickable(passwordField, 20);
		elementUtil.doActionsSendKeys(emailField, prop.getProperty("validusername")); // fetching
																						// from
																						// config.file
		logger.info("Sending user email id into email filed as -> " + prop.getProperty("validusername"));
		elementUtil.doActionsSendKeys(passwordField, prop.getProperty("validpassword")); // fetching
																							// from
																							// config.file
		logger.info("Sending user password into email filed as -> " + prop.getProperty("validpassword"));
		elementUtil.clickWhenReady(signInButtonOnSignInPage, 20);
		logger.info("After entering user's valid email id and valid password clicked on Sign In button on Signin page");
		elementUtil.waitForElementToBeVisible(userDetails, Constants.LOGIN_TIME_MAX_LIMIT);

		boolean isUserNameAppearsAfterLogin = elementUtil.doIsDisplayed(userDetails);
		softAssert.assertEquals(isUserNameAppearsAfterLogin, true);

		logger.info("User is successfully able to login into the application");

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
		logger.info("Fetched user first name after successful login as -> " + userFirstName);
		logger.info("Fetched user last name after successful login as -> " + userLastName);

		softAssert.assertEquals(userFirstName, prop.getProperty("userfirstname"),
				"AFTER LOGIN USERS FIRSTNAME IS NOT MATCHING WITH THE REGISTERED USERS FIRST NAME");
		softAssert.assertEquals(userLastName, prop.getProperty("userlastname"),
				"AFTER LOGIN USERS LASTNAME IS NOT MATCHING WITH THE REGISTERED USERS LASTNAME NAME");
		// CommonUtil.LongWait();
		// elementUtil.clickWhenReady(downArrowForUserSetting, 20);
		boolean isLodingCompeted = elementUtil.invisibilityofAllElements(pageLoder, 20);
		if (isLodingCompeted) {

			elementUtil.waitForElementToBeClickable(downArrowForUserSetting, 20);
			elementUtil.doActionsClick(downArrowForUserSetting);
			// elementUtil.clickWhenReady(logOutLink, 20);
			elementUtil.waitForElementToBeClickable(logOutLink, 20);
			elementUtil.doActionsClick(logOutLink);

			elementUtil.waitForUrl(Constants.SIGNIN_PAGE_URL, 20);
			String pageUrlAfterLogout = elementUtil.getCurrentPageUrl();

			Assert.assertEquals(pageUrlAfterLogout, Constants.SIGNIN_PAGE_URL);

		}
		logger.info("User is successfully able to logout from the application");
	}

	public void userLoginWithValidUsernameAndPasswordAndSignOutApplication() {
		// elementUtil.clickWhenReady(signInButtonOnLandingPage, 20);
		logger.info("Clicked on Sign In button on the landing page");
		elementUtil.waitForElementToBeClickable(emailField, 20);
		elementUtil.waitForElementToBeClickable(passwordField, 20);
		elementUtil.doActionsSendKeys(emailField, prop.getProperty("validusername1")); // fetching
																						// from
																						// config.file
		logger.info("Sending user email id into email filed as -> " + prop.getProperty("validusername"));
		elementUtil.doActionsSendKeys(passwordField, prop.getProperty("validpassword1")); // fetching
																							// from
																							// config.file
		logger.info("Sending user password into email filed as -> " + prop.getProperty("validpassword"));
		elementUtil.clickWhenReady(signInButtonOnSignInPage, 20);
		logger.info("After entering user's valid email id and valid password clicked on Sign In button on Signin page");
		elementUtil.waitForElementToBeVisible(userDetails, Constants.LOGIN_TIME_MAX_LIMIT);

		boolean isUserNameAppearsAfterLogin = elementUtil.doIsDisplayed(userDetails);
		softAssert.assertEquals(isUserNameAppearsAfterLogin, true);

		logger.info("User is successfully able to login into the application");

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
		logger.info("Fetched user first name after successful login as -> " + userFirstName);
		logger.info("Fetched user last name after successful login as -> " + userLastName);

		softAssert.assertEquals(userFirstName, prop.getProperty("userfirstname"),
				"AFTER LOGIN USERS FIRSTNAME IS NOT MATCHING WITH THE REGISTERED USERS FIRST NAME");
		softAssert.assertEquals(userLastName, prop.getProperty("userlastname"),
				"AFTER LOGIN USERS LASTNAME IS NOT MATCHING WITH THE REGISTERED USERS LASTNAME NAME");
		// CommonUtil.LongWait();
		// elementUtil.clickWhenReady(downArrowForUserSetting, 20);
		boolean isLodingCompeted = elementUtil.invisibilityofAllElements(pageLoder, 20);
		if (isLodingCompeted) {

			elementUtil.waitForElementToBeClickable(downArrowForUserSetting, 20);
			elementUtil.doActionsClick(downArrowForUserSetting);
			// elementUtil.clickWhenReady(logOutLink, 20);
			elementUtil.waitForElementToBeClickable(logOutLink, 20);
			elementUtil.doActionsClick(logOutLink);

			elementUtil.waitForUrl(Constants.SIGNIN_PAGE_URL, 20);
			String pageUrlAfterLogout = elementUtil.getCurrentPageUrl();

			Assert.assertEquals(pageUrlAfterLogout, Constants.SIGNIN_PAGE_URL);

		}
		logger.info("User is successfully able to logout from the application");
	}

	public void verifyLoanApplicationStatus(String address) {
		javascriptutil.clickElementByJS(driver.findElement(plusButton));
		elementUtil.doSendKeys(searchButton, address);
		CommonUtil.MediumWait();

		elementUtil.getElement(searchButton).sendKeys(Keys.DOWN, Keys.ENTER);
		CommonUtil.MediumWait();

		logger.info("APPLICATION IN PROGRESS ");
		String actualmessage = elementUtil.getElement(applicationMessage).getText();
		Assert.assertEquals(actualmessage, "Application in progress");
		elementUtil.doClick(clickContinue);

	}

	public void verifyDocumentButton() {
		boolean visible=elementUtil.getElement(documentButton).isDisplayed();
		logger.info("Document Button Visible Upload Condition");
		Assert.assertTrue(visible);
		
	}
	
	public void verifyConditionPendingCount()
	{
		String pendingCount=elementUtil.getElement(documentButtonPendingCount).getText();
		logger.info("Document Button Condition Pending Count");
		Assert.assertEquals(pendingCount, "1");
		
	}
	
	public void verifyDocumentButtonConditionPendingCountWithPendingItem()
	{
		String pendingCount=elementUtil.getElement(documentButtonPendingCount).getText();
		String pendingItems=elementUtil.getElement(pendingItemCount).getText();
		logger.info("Document Button Condition PendingCount same with PendingItem");
		Assert.assertEquals(pendingCount, pendingItems);
	}

	public void loginWithValidUsernameAndPassword(String username, String password) {

		try {
			elementUtil.clickWhenReady(signInButtonOnLandingPage, 20);
			logger.info("Clicked on Sign In button on the landing page");
			elementUtil.waitForElementToBeClickable(emailField, 20);
			elementUtil.waitForElementToBeClickable(passwordField, 20);
			elementUtil.doActionsSendKeys(emailField, username); // fetching
																	// from
																	// config.file
			logger.info("Sending user email id into email filed as -> " + username);
			elementUtil.doActionsSendKeys(passwordField, password); // fetching
																	// from
																	// config.file
			logger.info("Sending user password into email filed as -> " + password);
			elementUtil.clickWhenReady(signInButtonOnSignInPage, 20);
			logger.info(
					"After entering user's valid email id and valid password clicked on Sign In button on Signin page");
			elementUtil.waitForElementToBeVisible(userDetails, Constants.LOGIN_TIME_MAX_LIMIT);

			boolean isUserNameAppearsAfterLogin = elementUtil.doIsDisplayed(userDetails);
			softAssert.assertEquals(isUserNameAppearsAfterLogin, true);

			logger.info("User is successfully able to login into the application");

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
			logger.info("Fetched user first name after successful login as -> " + userFirstName);
			logger.info("Fetched user last name after successful login as -> " + userLastName);

			softAssert.assertEquals(userFirstName, prop.getProperty("userfirstname"),
					"AFTER LOGIN USERS FIRSTNAME IS NOT MATCHING WITH THE REGISTERED USERS FIRST NAME");
			softAssert.assertEquals(userLastName, prop.getProperty("userlastname"),
					"AFTER LOGIN USERS LASTNAME IS NOT MATCHING WITH THE REGISTERED USERS LASTNAME NAME");
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// CommonUtil.LongWait();
		// elementUtil.clickWhenReady(downArrowForUserSetting, 20);

	}

	public void loginWithValidUsernameAndPassword() {
		loginWithValidUsernameAndPassword(prop.getProperty("validusername1"), prop.getProperty("validpassword1"));
	}

	public void openUserProfile() {
		CommonUtil.shortWait();
		elementUtil.doClick(userName);
		logger.info("Click on User Profile");
		elementUtil.clickWhenReady(profileDropdownItem, 20);
	}

	public void logoutUserProfile() {
		CommonUtil.shortWait();
		elementUtil.doClick(userName);
		logger.info("Click on User Profile");
		elementUtil.clickWhenReady(logOutLink, 20);
	}

	public void updateProfile(String firstName, String lastName, String phone) {
		elementUtil.clearField(firstNameProfileDetail);
		elementUtil.doActionsSendKeys(firstNameProfileDetail, firstName);

		elementUtil.clearField(lastNameProfileDetail);
		elementUtil.doActionsSendKeys(lastNameProfileDetail, lastName);

		elementUtil.clearField(phoneProfileDetail);
		elementUtil.doActionsSendKeys(phoneProfileDetail, phone);

		elementUtil.clickWhenReady(saveProfileButton, 20);
		elementUtil.clickWhenReady(clickOk, 50);
		logger.info("Your profile has been successfully updated");

	}

	public void verifyProfile(String firstName, String lastName, String phone) {
		
		openUserProfile();
		CommonUtil.shortWait();
		String actualFirstName = elementUtil.getElement(firstNameProfileDetail).getAttribute("value");
		
		String actualLastName = elementUtil.getElement(lastNameProfileDetail).getAttribute("value");
		String actualPhone = elementUtil.getElement(phoneProfileDetail).getAttribute("value");
		assertEquals(firstName, actualFirstName);
		assertEquals(lastName, actualLastName);
		assertEquals(phone, actualPhone);
		elementUtil.clickWhenReady(saveProfileButton, 50);
		elementUtil.clickWhenReady(clickOk, 50);
	}
	

	public void verifySessionHasExpiredAfterTimeOut()
	{
		try {
			Thread.sleep(480000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.navigate().refresh();
		String redirecturl=driver.getCurrentUrl();
		Assert.assertEquals(redirecturl,Constants.SIGNIN_PAGE_URL);
		System.out.println("");
	}
	public void checkUserLoginWithValidUsernameAndPasswordAndSignOutApplication(String username, String password) {
		// elementUtil.clickWhenReady(signInButtonOnLandingPage, 20);
		logger.info("Clicked on Sign In button on the landing page");
		elementUtil.waitForElementToBeClickable(emailField, 20);
		elementUtil.waitForElementToBeClickable(passwordField, 20);
		elementUtil.doActionsSendKeys(emailField, username); // fetching
																// from
																// config.file
		logger.info("Sending user email id into email filed as -> " + prop.getProperty("validusername"));
		elementUtil.doActionsSendKeys(passwordField, password); // fetching
																// from
																// config.file
		logger.info("Sending user password into email filed as -> " + prop.getProperty("validpassword"));
		elementUtil.clickWhenReady(signInButtonOnSignInPage, 20);
		logger.info("After entering user's valid email id and valid password clicked on Sign In button on Signin page");
		elementUtil.waitForElementToBeVisible(userDetails, Constants.LOGIN_TIME_MAX_LIMIT);

		boolean isUserNameAppearsAfterLogin = elementUtil.doIsDisplayed(userDetails);
		Assert.assertEquals(isUserNameAppearsAfterLogin, true);

		logger.info("User is successfully able to login into the application");

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
		logger.info("Fetched user first name after successful login as -> " + userFirstName);
		logger.info("Fetched user last name after successful login as -> " + userLastName);

		Assert.assertEquals(userFirstName, prop.getProperty("userfirstname"),
				"AFTER LOGIN USERS FIRSTNAME IS NOT MATCHING WITH THE REGISTERED USERS FIRST NAME");
		Assert.assertEquals(userLastName, prop.getProperty("userlastname"),
				"AFTER LOGIN USERS LASTNAME IS NOT MATCHING WITH THE REGISTERED USERS LASTNAME NAME");
		// CommonUtil.LongWait();
		// elementUtil.clickWhenReady(downArrowForUserSetting, 20);
		boolean isLodingCompeted = elementUtil.invisibilityofAllElements(pageLoder, 20);
		if (isLodingCompeted) {

			elementUtil.waitForElementToBeClickable(downArrowForUserSetting, 20);
			elementUtil.doActionsClick(downArrowForUserSetting);
			// elementUtil.clickWhenReady(logOutLink, 20);
			elementUtil.waitForElementToBeClickable(logOutLink, 20);
			elementUtil.doActionsClick(logOutLink);

			elementUtil.waitForUrl(Constants.SIGNIN_PAGE_URL, 20);
			String pageUrlAfterLogout = elementUtil.getCurrentPageUrl();

			Assert.assertEquals(pageUrlAfterLogout, Constants.SIGNIN_PAGE_URL);

		}
		logger.info("User is successfully able to logout from the application");
	}

	public void checkUserUnableLoginWithInvalidUsernameAndValidPassword() {
		try {
			elementUtil.clickWhenReady(signInButtonOnLandingPage, 20);
			logger.info("Clicked on Sign In button on the landing page");
			elementUtil.waitForElementToBeClickable(emailField, 20);
			elementUtil.waitForElementToBeClickable(passwordField, 20);
			elementUtil.doActionsSendKeys(emailField, prop.getProperty("invalidusername")); // fetching
																							// from
																							// config.file
			Thread.sleep(3000L);
			logger.info("Sending user email id into email filed as -> " + prop.getProperty("invalidusername"));
			elementUtil.doActionsSendKeys(passwordField, prop.getProperty("validpassword")); // fetching
																								// from
																								// config.file
			logger.info("Sending user password into email filed as -> " + prop.getProperty("validpassword"));
			elementUtil.clickWhenReady(signInButtonOnSignInPage, 20);
			logger.info(
					"After entering user's invalid email id and valid password clicked on Sign In button on Signin page");
			elementUtil.waitForElementPresent(invalidCredentialsToolTip, 20);
			String invalidCredentailsToolipMessage = elementUtil.doGetText(invalidCredentialsToolTip);
			javascriptutil.scrollIntoView(driver.findElement(passwordField));
			logger.info(
					"After entering user's invalid email id and valid password clicked on Sign In button on Signin page tooltip message is -> "
							+ invalidCredentailsToolipMessage);
			softAssert.assertEquals(invalidCredentailsToolipMessage, Constants.INVALID_CREDENTAILS_TOOLTIP_MESSAGE,
					"AFTER ENTERING INVALID USERNAME AND VALID PASSWORD "
							+ "TO LOGIN INTO APPLICATION THE INVALID CREDENTAILS TOOL TIP MESSAGE IS NOT MATCHING WITH EXPECTED TOOLTIP MESSAGE");
			logger.info(
					"After entering user's invalid email id and valid password clicked on Sign In button on Signin page tooltip message appears with text -> "
							+ invalidCredentailsToolipMessage);
			Thread.sleep(6000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void changePasswordUsingProfileDetails(String newPassword) {
		logger.info("Updated Password -> " + newPassword);
		elementUtil.clearField(updatedpassword);
		elementUtil.doActionsSendKeys(updatedpassword, newPassword);
		elementUtil.clearField(updatedConfirmPassword);
		elementUtil.doActionsSendKeys(updatedConfirmPassword, newPassword);
		elementUtil.clickWhenReady(saveProfileButton, 20);
		elementUtil.clickWhenReady(clickOk, 50);
		logger.info("Your profile has been successfully updated");

	}

	public void checkUserUnableLoginWithInvalidUsernameAndInValidPassword() {
		// elementUtil.clickWhenReady(signInButtonOnLandingPage, 20);
		logger.info("Clicked on Sign In button on the landing page");
		elementUtil.waitForElementToBeClickable(emailField, 20).clear();
		elementUtil.waitForElementToBeClickable(passwordField, 20).clear();
		elementUtil.doActionsSendKeys(emailField, prop.getProperty("invalidusername")); // fetching
																						// from
																						// config.file
		logger.info("Sending user email id into email filed as -> " + prop.getProperty("invalidusername"));
		elementUtil.doActionsSendKeys(passwordField, prop.getProperty("invalidpassword")); // fetching
																							// from
																							// config.file
		logger.info("Sending user password into email filed as -> " + prop.getProperty("validpassword"));
		elementUtil.clickWhenReady(signInButtonOnSignInPage, 20);
		logger.info(
				"After entering user's invalid email id and valid password clicked on Sign In button on Signin page");
		elementUtil.waitForElementPresent(invalidCredentialsToolTip, 20);
		String invalidCredentailsToolipMessage = elementUtil.doGetText(invalidCredentialsToolTip);
		logger.info(
				"After entering user's invalid email id and valid password clicked on Sign In button on Signin page tooltip message is -> "
						+ invalidCredentailsToolipMessage);
		Assert.assertEquals(invalidCredentailsToolipMessage, Constants.INVALID_CREDENTAILS_TOOLTIP_MESSAGE,
				"AFTER ENTERING INVALID USERNAME AND VALID PASSWORD "
						+ "TO LOGIN INTO APPLICATION THE INVALID CREDENTAILS TOOL TIP MESSAGE IS NOT MATCHING WITH EXPECTED TOOLTIP MESSAGE");
		logger.info(
				"After entering user's invalid email id and valid password clicked on Sign In button on Signin page tooltip message appears with text -> "
						+ invalidCredentailsToolipMessage);

	}

	public void checkUserUnableLoginWithValidUsernameAndInvalidPassword() {
		try {
			elementUtil.clickWhenReady(signInButtonOnLandingPage, 20);
			logger.info("Clicked on Sign In button on the landing page");
			elementUtil.waitForElementToBeClickable(emailField, 20).clear();
			elementUtil.waitForElementToBeClickable(passwordField, 20).clear();
			elementUtil.doActionsSendKeys(emailField, prop.getProperty("validusername")); // fetching
																							// from
																							// config.file
			logger.info("Sending user email id into email filed as -> " + prop.getProperty("validusername"));
			elementUtil.doActionsSendKeys(passwordField, prop.getProperty("invalidpassword")); // fetching
																								// from
																								// config.file
			logger.info("Sending user password into email filed as -> " + prop.getProperty("invalidpassword"));
			elementUtil.clickWhenReady(signInButtonOnSignInPage, 20);
			logger.info(
					"After entering user's valid email id and invalid password clicked on Sign In button on Signin page");
			elementUtil.waitForElementPresent(invalidCredentialsToolTip, 20);
			String invalidCredentailsToolipMessage = elementUtil.doGetText(invalidCredentialsToolTip);
			javascriptutil.scrollIntoView(driver.findElement(passwordField));
			logger.info(
					"After entering user's valid email id and invalid password clicked on Sign In button on Signin page tooltip message is -> "
							+ invalidCredentailsToolipMessage);
			CommonUtil.MediumWait();
			softAssert.assertEquals(invalidCredentailsToolipMessage, Constants.INVALID_CREDENTAILS_TOOLTIP_MESSAGE,
					"AFTER ENTERING VALID USERNAME AND INVALID PASSWORD "
							+ "TO LOGIN INTO APPLICATION THE INVALID CREDENTAILS TOOL TIP MESSAGE IS NOT MATCHING WITH EXPECTED TOOLTIP MESSAGE");
			logger.info(
					"After entering user's valid email id and invalid password clicked on Sign In button on Signin page tooltip message appears with text -> "
							+ invalidCredentailsToolipMessage);
			Thread.sleep(6000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void checkUserAbleLoginWithValidUsernameAndValidPasswordFromFacebookSignOutApplication() {

		elementUtil.clickWhenReady(signInButtonOnLandingPage, 20);
		logger.info("Clicked on Sign In button");
		elementUtil.clickWhenReady(signInWithFacebookButton, 20);
		logger.info("Clicked on \"Sign in with Facebook\" button");
		elementUtil.waitForWindowPresentAndSwitchToIt(2, 20);
		elementUtil.switchToWindowId(driver, 1);
		logger.info("Switched to the Facebook window");
		elementUtil.waitForElementPresent(facebookEmailAddressOrPhoneNumberTextbox, 20);
		elementUtil.doActionsSendKeys(facebookEmailAddressOrPhoneNumberTextbox,
				prop.getProperty("facebookUserEmailID"));
		logger.info("Entered EmailId in the facebook window as -> " + prop.getProperty("facebookUserEmailID"));
		elementUtil.waitForElementPresent(facebookPassowrdTextbox, 20);
		elementUtil.doActionsSendKeys(facebookPassowrdTextbox, prop.getProperty("facebookUserPassword"));
		logger.info("Entered password in the facebook window as -> " + prop.getProperty("facebookUserPassword"));
		elementUtil.clickWhenReady(facebookPageLoginButton, 20);
		logger.info("Clicked on \"Log In\" button from facebook window");
		CommonUtil.MediumWait();
		elementUtil.switchToWindowId(driver, 0);
		logger.info("Switched from facebook window to original window of application");

		elementUtil.waitForElementToBeVisible(userDetails, 20);
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
		logger.info("1. User First Name after login from facebook is -> " + userFirstName);
		logger.info("2. User Last Name after login from facebook  is -> " + userLastName);

		Assert.assertEquals(userFirstName, prop.getProperty("facebookUserFirstName"));
		Assert.assertEquals(userLastName, prop.getProperty("facebookUserLastName"));
		boolean isLodingCompeted = elementUtil.invisibilityofAllElements(pageLoder, 20);
		if (isLodingCompeted) {
			elementUtil.waitForElementToBeClickable(downArrowForUserSetting, 20);
			elementUtil.doActionsClick(downArrowForUserSetting);
			// elementUtil.clickWhenReady(logOutLink, 20);
			elementUtil.waitForElementToBeClickable(logOutLink, 20);
			elementUtil.doActionsClick(logOutLink);

			elementUtil.waitForUrl(Constants.SIGNIN_PAGE_URL, 20);
			String pageUrlAfterLogout = elementUtil.getCurrentPageUrl();

			Assert.assertEquals(pageUrlAfterLogout, Constants.SIGNIN_PAGE_URL);
		}
		logger.info("User is successfully able to logout from the application");
	}

	public void userLoginThroughGoogle() {
		try {
			elementUtil.clickWhenReady(signInWithGmailButton, 20);
			elementUtil.clickWhenReady(gmailEmailAddressTextbox, 20);
			Thread.sleep(6000);
			elementUtil.doSendKeys(gmailEmailAddressTextbox, prop.getProperty("facebookUserEmailID"));
			// driver.findElement(gmailEmailAddressTextbox).sendKeys(prop.getProperty("facebookUserEmailID"));

			// elementUtil.doActionsSendKeys(gmailEmailAddressTextbox,
			// prop.getProperty("gmailUserPassword"));

			Thread.sleep(3000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void checkLoanByEnteringAddress(String invalidAddress, String input_ZipCode) {
		try {
			elementUtil.clickWhenReady(signInButtonOnLandingPage, 20);
			logger.info("Clicked on Sign In button on the landing page");
			elementUtil.waitForElementToBeClickable(emailField, 20).clear();
			elementUtil.waitForElementToBeClickable(passwordField, 20).clear();
			elementUtil.doActionsSendKeys(emailField, prop.getProperty("validusername")); // fetching
																							// from
																							// config.file
			logger.info("Sending user email id into email filed as -> " + prop.getProperty("validusername"));
			elementUtil.doActionsSendKeys(passwordField, prop.getProperty("validpassword")); // fetching
																								// from
																								// config.file
			logger.info("Sending user password into email filed as -> " + prop.getProperty("validpassword"));
			elementUtil.clickWhenReady(signInButtonOnSignInPage, 20);
			logger.info(
					"After entering user's valid email id and valid password clicked on Sign In button on Signin page");

			System.out.println("title is " + driver.getTitle());

			softAssert.assertEquals(driver.getTitle(), "InterestSmart");

			javascriptutil.clickElementByJS(driver.findElement(plusButton));
			Thread.sleep(6000);

			elementUtil.doActionsSendKeys(searchButton, invalidAddress);
			elementUtil.pressEnter(searchButton);
			getScreenshot("User entered invalid address");
			Thread.sleep(3000);
			elementUtil.doActionsSendKeys(zipcode, input_ZipCode);
			elementUtil.pressEnter(zipcode);
			Thread.sleep(6000L);
			if (driver.findElement(successMessage).isDisplayed()) {
				getScreenshot("We found your mortgage data!");
				String messages = driver.findElement(successMessage).getText();
				System.out.println("Heading is " + messages);
				softAssert.assertEquals(messages, "We found your mortgage data!");
				softAssert.assertAll();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void checkLoanByEnteringLoanDetails(String invalidAddress, String input_ZipCode) {
		try {
			elementUtil.clickWhenReady(signInButtonOnLandingPage, 20);
			logger.info("Clicked on Sign In button on the landing page");
			elementUtil.waitForElementToBeClickable(emailField, 20).clear();
			elementUtil.waitForElementToBeClickable(passwordField, 20).clear();
			elementUtil.doActionsSendKeys(emailField, prop.getProperty("validusername")); // fetching
																							// from
																							// config.file
			logger.info("Sending user email id into email filed as -> " + prop.getProperty("validusername"));
			elementUtil.doActionsSendKeys(passwordField, prop.getProperty("validpassword")); // fetching
																								// from
																								// config.file
			logger.info("Sending user password into email filed as -> " + prop.getProperty("validpassword"));
			elementUtil.clickWhenReady(signInButtonOnSignInPage, 20);
			logger.info(
					"After entering user's valid email id and valid password clicked on Sign In button on Signin page");

			System.out.println("title is " + driver.getTitle());

			softAssert.assertEquals(driver.getTitle(), "InterestSmart");

			javascriptutil.clickElementByJS(driver.findElement(plusButton));
			Thread.sleep(6000);

			elementUtil.doActionsSendKeys(searchButton, invalidAddress);
			elementUtil.pressEnter(searchButton);
			getScreenshot("User entered invalid address");
			Thread.sleep(3000);
			elementUtil.doActionsSendKeys(zipcode, input_ZipCode);
			elementUtil.pressEnter(zipcode);
			Thread.sleep(6000L);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterAddress(String Address) {
		try {
			elementUtil.doActionsSendKeys(searchButton, Address);
			elementUtil.pressEnter(searchButton);
			getScreenshot("User entered valid address");
			Thread.sleep(3000);
			// elementUtil.doActionsSendKeys(zipcode, input_ZipCode);
			// elementUtil.pressEnter(zipcode);
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterZipCode(String ZipCode) {
		try {
			elementUtil.doActionsSendKeys(zipcode, ZipCode);
			elementUtil.pressEnter(zipcode);
			getScreenshot("User entered zip code");
			Thread.sleep(3000);
			// elementUtil.doActionsSendKeys(zipcode, input_ZipCode);
			// elementUtil.pressEnter(zipcode);
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectAddress() {
		try {
			Keyboard.pressDown();
			Thread.sleep(3000);
			// Keyboard.pressDown();
			Thread.sleep(3000);
			Keyboard.pressEnter();
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void fill_LoanDate(String Date) {
		try {
			elementUtil.clickWhenReady(startDate, 20);
			elementUtil.doActionsSendKeys(startDate, Date);
			driver.findElement(startDate).sendKeys(Keys.ENTER);
			Thread.sleep(3000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void fill_LoanTerm(String inputloanTerm) {
		try {
			elementUtil.clickWhenReady(loanTerm, 20);
			elementUtil.doActionsSendKeys(loanTermSearch, inputloanTerm);
			driver.findElement(loanTermSearch).sendKeys(Keys.ENTER);
			Thread.sleep(3000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void fill_LoanType(String input_LoanType) {
		try {
			elementUtil.clickWhenReady(loanType, 20);
			elementUtil.doActionsSendKeys(loanTypeSearch, input_LoanType);
			driver.findElement(loanTypeSearch).sendKeys(Keys.ENTER);
			Thread.sleep(3000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void fill_InitialBalance(String input_InitialBalance) {
		try {
			elementUtil.clickWhenReady(initialBalance, 20);
			elementUtil.doActionsSendKeys(initialBalance, input_InitialBalance);
			driver.findElement(initialBalance).sendKeys(Keys.ENTER);
			Thread.sleep(3000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void click_GoButton() {
		try {
			Thread.sleep(3000L);
			elementUtil.clickWhenReady(go_Button, 20);
			getScreenshot();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void click_GetStartedButton() {
		try {
			Thread.sleep(3000L);
			// elementUtil.clickWhenReady(getStarted_Button, 30);
			javascriptutil.clickElementByJS(driver.findElement(getStarted_Button));
			getScreenshot();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void click_ContinueButton() {
		try {
			Thread.sleep(3000L);
			// elementUtil.clickWhenReady(getStarted_Button, 30);
			javascriptutil.clickElementByJS(driver.findElement(continueButton));
			getScreenshot();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void print_RemainingBalance() {
		try {

			String value = driver.findElement(remainingBalance).getAttribute("value");
			actual_RemainingBalance = Double.parseDouble(value.replace("$", ""));
			System.out.println("Actual remmaing balance is :" + actual_RemainingBalance);
			Thread.sleep(3000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void printMonthlyPayment() {
		try {
			String value = driver.findElement(monthlyPayment).getAttribute("value");
			actual_MonthlyPayment = Double.parseDouble(value.replace("$", ""));
			System.out.println("Actual monthly payment is :" + actual_MonthlyPayment);
			Thread.sleep(3000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void CalculateExpectedvalues(double roi, double loanAmount, int timePeriod) {
		try {
			expected_ActualEstimatedRate = Calculate.calcuteActualEstimatedRate(roi);// 3.690
			expected_MonthlyPayment = Calculate.calcuteMonthlyPayment(loanAmount, timePeriod);
			expected_Diff_numberOfPayment = Calculate.noOfPaymentsDone(360, 10);
			expected_RemainingBalance = Calculate.remainingBalanceLeft();
			Thread.sleep(3000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyRemainingBalance() {
		try {
			softAssert.assertEquals(actual_RemainingBalance, expected_RemainingBalance,
					"Actual Remaining Balance " + actual_RemainingBalance
							+ " is not equal to Expected Remaining balance " + expected_RemainingBalance);
			Thread.sleep(3000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyMonthlypayment() {
		try {
			softAssert.assertEquals(actual_MonthlyPayment, expected_MonthlyPayment, "Actual Monthly Payment "
					+ actual_MonthlyPayment + " is not equal to Expected Monthly Payment " + expected_MonthlyPayment);
			softAssert.assertAll();
			Thread.sleep(3000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void assertAll() {
		try {
			softAssert.assertAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void fill_ZestimateValue(String input_ZestimateValue) {
		try {
			elementUtil.doSendKeys(zestimateValue, input_ZestimateValue);
			Thread.sleep(3000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void click_SignHereButton() {
		try {
			Thread.sleep(3000L);
			elementUtil.clickWhenReady(signInHereButton, 30);
			getScreenshot();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
