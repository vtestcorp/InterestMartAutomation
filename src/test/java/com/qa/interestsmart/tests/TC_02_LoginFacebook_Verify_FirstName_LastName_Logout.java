package com.qa.interestsmart.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.qa.interestsmart.base.BaseTest;
import com.qa.interestsmart.pages.SignInPage;

public class TC_02_LoginFacebook_Verify_FirstName_LastName_Logout extends BaseTest {

	private static final Logger logger = LogManager
			.getLogger(TC_02_LoginFacebook_Verify_FirstName_LastName_Logout.class);

	@Test
	public void TC_01_LoginFacebook_Verify_FirstName_LastName_Logout() {

		signInPage.checkUserIsAbleLoginUsingFacebookAfterClickingOnSigninWithFacebookFromSigninPage();
		signInPage.verifyFacebookFirstNameLastName();
		signInPage.userLogoutOfFacebook();
	}
}