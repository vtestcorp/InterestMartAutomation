package com.qa.interestsmart.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.qa.interestsmart.base.BaseTest;
import com.qa.interestsmart.utils.ExcelUtil;

public class TC_03_Login_ValidEmail_ValidPassword extends BaseTest {

	private static final Logger logger = LogManager.getLogger(TC_03_Login_ValidEmail_ValidPassword.class);

	@Test
	public void TC_03_Login_ValidEmail_ValidPassword() {

		// Valid Email, Valid Password
		signInToApplication.checkUserLoginWithValidUsernameAndPasswordAndSignOutApplication();		

				
	}
}