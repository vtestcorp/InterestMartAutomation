package com.qa.interestsmart.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.qa.interestsmart.base.BaseTest;
import com.qa.interestsmart.utils.ExcelUtil;

public class TC_01 extends BaseTest {

	private static final Logger logger = LogManager.getLogger(TC_01.class);

	@Test
	public void TC_01_() {
		signInPage.checkUserIsAbleLoginUsingFacebookAfterClickingOnSigninWithFacebookFromSigninPage();
		signInPage.verifyFacebookFirstNameLastName();
		signInPage.userLogoutOfFacebook();
		// signInToApplication.userLoginThroughGoogle();
		
		// Valid Email, Valid Password
		signInToApplication.checkUserLoginWithValidUsernameAndPasswordAndSignOutApplication();		
        // Invalid Email, Valid Password
		signInToApplication.checkUserUnableLoginWithInvalidUsernameAndValidPassword();
		// valid Email invalid password
		signInToApplication.checkUserUnableLoginWithValidUsernameAndInvalidPassword();
		// invalid email invalid password
		signInToApplication.checkUserUnableLoginWithInvalidUsernameAndInValidPassword();
		
//		signInToApplication.checkLoanByEnteringAddress(ExcelUtil.ReadCellData(1, 0, "Address"));
				
	}
}