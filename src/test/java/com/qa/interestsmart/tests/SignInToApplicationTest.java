package com.qa.interestsmart.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.qa.interestsmart.base.BaseTest;

public class SignInToApplicationTest extends BaseTest {

	private static final Logger logger = LogManager.getLogger(SignInToApplicationTest.class);

	@Test
	public void tc_01_User_Signin_to_application_with_Valid_emailId_and_Valid_password_and_signout_application() {
		logger.info(
				"Test case started: tc_01_User_Signin_to_aplication_with_Valid_emailId_and_Valid_password_and_signout_application");
		signInToApplication.checkUserLoginWithValidUsernameAndPasswordAndSignOutApplication();
		logger.info(
				"Test case Ended: tc_01_User_Signin_to_aplication_with_Valid_emailId_and_Valid_password_and_signout_application");
	}

	@Test
	public void tc_02_User_is_unable_to_Signin_application_with_Invalid_emailId_and_Valid_password() {
		logger.info(
				"Test case started: tc_02_User_is_unable_to_Signin_application_with_Invalid_emailId_and_Valid_password");
		signInToApplication.checkUserUnableLoginWithInvalidUsernameAndValidPassword();
		logger.info(
				"Test case Ended: tc_02_User_is_unable_to_Signin_application_with_Invalid_emailId_and_Valid_password");
	}

	@Test
	public void tc_03_User_is_unable_to_Signin_application_with_Valid_emailId_and_Invalid_password() {
		logger.info("Test case started: tc_03_User_Signin_to_aplication_with_Valid_emailId_and_Invalid_password");
		signInToApplication.checkUserUnableLoginWithValidUsernameAndInvalidPassword();
		logger.info("Test case Ended: tc_03_User_Signin_to_aplication_with_Valid_emailId_and_Invalid_password");
	}

	@Test
	public void tc_04_User_Signin_to_aplication_with_valid_emailId_and_valid_password_from_facebook_and_signout_application() {
		logger.info(
				"Test case started: tc_04_User_Signin_to_aplication_with_valid_emailId_and_valid_password_from_facebook_and_signout_application");
		signInToApplication.checkUserAbleLoginWithValidUsernameAndValidPasswordFromFacebookSignOutApplication();
		logger.info(
				"Test case Ended: tc_04_User_Signin_to_aplication_with_valid_emailId_and_valid_password_from_facebook_and_signout_application");
	}

}
