package com.qa.interestsmart.tests;


import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.interestsmart.base.BaseTest;
import com.qa.interestsmart.utils.Constants;
import com.qa.interestsmart.utils.ElementUtil;


public class SignInPageTest extends BaseTest {

	private static final Logger logger = LogManager.getLogger(SignInPageTest.class);
	
	@Test
	public void tc_01_check_sign_in_button_on_landing_page_is_redirecting_sign_in_page()
	{
		logger.info("Test case started: tc_01_check_sign_in_button_on_landing_page_is_redirecting_sign_in_page");
		String urlfromPage = signInPage.clickOnSignInButton();
		Assert.assertEquals(urlfromPage, Constants.SIGNIN_PAGE_URL, "CURRENT URL IS NOT MATCHING WITH SIGNIN PAGE URL" + urlfromPage);
		logger.info("Test case Ended: tc_01_check_sign_in_button_on_landing_page_is_redirecting_sign_in_page");
	}
	
	@Test
	public void tc_02_check_emailId_and_passowrd_field_is_displayed_sign_in_page()
	{
		logger.info("Test case started: tc_02_check_emailId_and_passowrd_field_is_displayed_sign_in_page");
		ArrayList<Boolean> checkFiledResult = signInPage.checkForEmailIdAndPassordFieldOnSignInPageIsDisplayed();
		boolean isEmailIdFieldDisplayed = checkFiledResult.get(0);
		boolean isPasswordFieldDisplayed = checkFiledResult.get(1);
		Assert.assertEquals(isEmailIdFieldDisplayed, true, "EMAIL ID FIELD IS NOT DISPLAYED ON SIGNIN PAGE");
		Assert.assertEquals(isPasswordFieldDisplayed, true, "PASSWORD FIELD IS NOT DISPLAYED ON SIGNIN PAGE");
		logger.info("Test case Ended: tc_02_check_emailId_and_passowrd_field_is_displayed_sign_in_page");
	}
	
	@Test
	public void tc_03_check_tooltip_for_blank_emailId_and_blank_password_field_is_displayed()
	{
		logger.info("Test case started: tc_03_check_tooltip_for_blank_emailId_and_blank_password_field_is_dispalyed");
		ArrayList<Boolean> checkTooltipResult = signInPage.checkTooltipForEmailAndPasswordFieldIsDispalyed();
		boolean isTooltipForEmailIdFieldDisplayed = checkTooltipResult.get(0);
		boolean isTooltipForPassowrdFieldDisplayed = checkTooltipResult.get(1);
		Assert.assertEquals(isTooltipForEmailIdFieldDisplayed, true, "TOOLTIP FOR EMAIL ID FIELD IS NOT DISPLAYED ON SIGNIN PAGE");
		Assert.assertEquals(isTooltipForPassowrdFieldDisplayed, true, "TOOLTIP FOR PASSWORD FIELD IS NOT DISPLAYED ON SIGNIN PAGE");
		logger.info("Test case Ended: tc_03_check_tooltip_for_blank_emailId_and_blank_password_field_is_dispalyed");
	}
	
	@Test
	public void tc_04_check_tooltip_for_spaces_in_emailId_and_password_field_is_displayed()
	{
		logger.info("Test case started: tc_04_check_tooltip_for_spaces_in_emailId_and_password_field_is_displayed");
		ArrayList<Boolean> checkTooltipResultForSpacesInEmailAndPassword = signInPage.checkTooltipForEmailAndPasswordEnteredWithSpaces();
		boolean tooltipForSpacesForEmailField = checkTooltipResultForSpacesInEmailAndPassword.get(0);
		Assert.assertEquals(tooltipForSpacesForEmailField, true, "AFTER ENTERING THE SPACES IN EMAIL AND PASSWORD FIELD TOOLTIP IS NOT DISPAYED FOR EMAIL FIELD");
		logger.info("Test case Ended: tc_04_check_tooltip_for_spaces_in_emailId_and_password_field_is_displayed");
	}
	
	@Test
	public void tc_05_check_tooltip_for_blank_password_field_is_displayed()
	{
		logger.info("Test case started: tc_05_check_tooltip_for_blank_password_field_is_displayed");
		boolean tooltipForBlankPasswordField = signInPage.checkForToolTipWithEmailIdAndBlankPasswordAndClickOnSignInButton();
		Assert.assertEquals(tooltipForBlankPasswordField, true, "AFTER ENTERING EMAIL ID AND BLANK PASSWORD TOOLTIP IS NOT DISPAYED FOR PASSWORD FIELD");
		logger.info("Test case Ended: tc_05_check_tooltip_for_blank_password_field_is_displayed");
	}
	
	@Test
	public void tc_06_check_time_to_Signin_to_aplication_with_correct_emailId_and_password()
	{
		logger.info("Test case started: tc_06_check_time_to_Signin_to_aaplication_with_correct_emailId_and_password");
		ArrayList<String> userFirstNameAndLastName = signInPage.checkTimeToSignInTheApplicationWithValidEmailIdAndPassword();
		Assert.assertEquals(userFirstNameAndLastName.get(0), prop.getProperty("userfirstname"), "AFTER LOGIN USERS FIRSTNAME IS NOT MATCHING WITH THE REGISTERED USERS FIRST NAME");
		Assert.assertEquals(userFirstNameAndLastName.get(1), prop.getProperty("userlastname") , "AFTER LOGIN USERS LASTNAME IS NOT MATCHING WITH THE REGISTERED USERS LASTNAME NAME");
		logger.info("Test case Ended: tc_06_check_time_to_Signin_to_aaplication_with_correct_emailId_and_password");
	}
	
	@Test
	public void tc_07_check_password_field_text_is_encrypted_form()
	{
		logger.info("Test case started: tc_07_check_password_field_text_is_encrypted_form");
		String passwordFiledAttributeByDefault = signInPage.checkThePasswordEnteredIsInEncryptedFrom();
		Assert.assertEquals(passwordFiledAttributeByDefault, "password", "AFTER ENTERING TEXT INTO PASSWORD FIELD THE FIELD ATTRIBUTE IS NOT AS \"password\"");
		logger.info("Test case Ended: tc_07_check_password_field_text_is_encrypted_form");
	}
	
	@Test
	public void tc_08_check_time_to_login_the_application()
	{
		logger.info("Test case started: tc_08_check_time_to_login_the_application");
		long actualTimeToLoginApp = signInPage.checkTimeToLoginIntoTheApplication();
		Assert.assertTrue(actualTimeToLoginApp <= Constants.LOGIN_TIME_MAX_LIMIT);
		logger.info("Test case Ended: tc_08_check_time_to_login_the_application");
	}
	
	@Test
	public void tc_09_check_message_for_signin_to_application_with_invalid_credentials()
	{
		logger.info("Test case started: tc_09_check_message_for_signin_to_application_with_invalid_credentials");
		ArrayList<Object> afterEnteringInvalidCredentialStatus = signInPage.checkTimeToSignInTheApplicationWithInvalidEmailIdAndPassword();
		for (int i = 0; i < afterEnteringInvalidCredentialStatus.size(); i++) {
			System.out.println((i+1) + " " + afterEnteringInvalidCredentialStatus.get(i).toString());
		}
		Assert.assertEquals(afterEnteringInvalidCredentialStatus.get(0).toString(), "true", "FOR INVALID CREDENTIALS AND CLICKED ON SIGNIN BUTTON ERROR MESSAGE TOOLTIP IS NOT DISPLAYED");
		Assert.assertEquals(afterEnteringInvalidCredentialStatus.get(1).toString(), Constants.TOOLTIP_TEXT_FOR_INVALID_CREDENTAILS, "FOR INVALID CREDENTIALS AND CLICKED ON SIGNIN BUTTON ERROR MESSAGE ON TOOLTIP IS NOT MATCHING AS EXPECTED");
		Assert.assertEquals(afterEnteringInvalidCredentialStatus.get(2).toString(), "false", "FOR INVALID CREDENTIALS AND CLICKED ON SIGNIN BUTTON USER IS ABLE TO LOGIN INTO THE APPLICATION");
		logger.info("Test case Ended: tc_09_check_message_for_signin_to_application_with_invalid_credentials");
	}
	
	@Test 
	public void tc_10_check_after_clicking_on_sign_in_here_link_form_signin_page_redirected_to_signup_page()
	{
		logger.info("Test case started: tc_10_check_after_clicking_on_sign_up_here_link_form_signin_page_redirected_to_signup_page");
		Object[] validationPointsForSignUpPage = signInPage.checkAfterClickingOnSignInHereLinkFromSignInPagePageRedirectingToSignUpPage();
		Assert.assertEquals(validationPointsForSignUpPage[0], Constants.SIGNUP_PAGE_URL, "AFTER CLICKING ON \"Sign in here\" LINK FORM SIGNIN PAGE THE REDIRECTED URL IS NOT MATCHING WITH THE EXPECTED URL FOR SIGNUP PAGE");
		Assert.assertEquals(validationPointsForSignUpPage[1], true, "AFTER CLICKING ON \"Sign in here\" LINK FORM SIGNIN PAGE \"CREATE ACCOUNT\" BUTTON IS NOT PRESENT ON THE SIGNUP PAGE");
		logger.info("Test case Ended: tc_10_check_after_clicking_on_sign_up_here_link_form_signin_page_redirected_to_signup_page");
	}
	

	@Test
	public void tc_11_check_user_is_able_to_login_with_facebook_from_the_signin_page()
	{
		logger.info("Test case started: tc_12_check_user_is_able_to_login_with_facebook_from_the_signin_page");
		ArrayList<String> userFirstNameAndLastNameFromFacebook = signInPage.checkUserIsAbleLoginUsingFacebookAfterClickingOnSigninWithFacebookFromSigninPage();
		Assert.assertEquals(userFirstNameAndLastNameFromFacebook.get(0), prop.getProperty("facebookUserFirstName"), "AFTER LOGIN USERS FIRSTNAME IS NOT MATCHING WITH THE FACEBOOK USERS FIRST NAME");
		Assert.assertEquals(userFirstNameAndLastNameFromFacebook.get(1), prop.getProperty("facebookUserLastName"), "AFTER LOGIN USERS FIRSTNAME IS NOT MATCHING WITH THE FACEBOOK USERS FIRST NAME");
		logger.info("Test case Ended: tc_12_check_user_is_able_to_login_with_facebook_from_the_signin_page");
	}
	
	@Test // failing for edge browser
	public void tc_12_check_after_clicking_on_signin_with_facebook_button_facebook_login_page_open_in_new_window()
	{
		logger.info("Test case started: tc_11_check_after_clicking_on_signin_with_facebook_button_facebook_login_page_open_in_new_window");
		Object[] facebookPageValidationAfterClickingOnLoginWithFacebook = signInPage.checkAfterClickingOnSignInWithFacebookButtonUserRedirectedToFacebookLoginPage();
		Assert.assertEquals(facebookPageValidationAfterClickingOnLoginWithFacebook[0], true, "AFTER CLICKING ON SIGNIN WITH FACEBOOK BUTTON FACEBOOK LOGIN PAGE IT NOT REDIRECTED TO CORRECT FACEBOOK URL");
		Assert.assertEquals(facebookPageValidationAfterClickingOnLoginWithFacebook[1], true, "AFTER CLICKING ON SIGNIN WITH FACEBOOK BUTTON FACEBOOK LOGIN PAGE NOT SHOWING LOGIN BUTTON");
		logger.info("Test case Ended: tc_11_check_after_clicking_on_signin_with_facebook_button_facebook_login_page_open_in_new_window");
	}
}
