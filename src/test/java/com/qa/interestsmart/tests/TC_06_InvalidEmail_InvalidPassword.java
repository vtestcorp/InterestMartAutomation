package com.qa.interestsmart.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.qa.interestsmart.base.BaseTest;
import com.qa.interestsmart.utils.ExcelUtil;

public class TC_06_InvalidEmail_InvalidPassword extends BaseTest {

	private static final Logger logger = LogManager.getLogger(TC_06_InvalidEmail_InvalidPassword.class);

	@Test
	public void TC_06_InvalidEmail_InvalidPassword() {
		// valid Email invalid password
		signInToApplication.checkUserUnableLoginWithValidUsernameAndInvalidPassword();

	}
}