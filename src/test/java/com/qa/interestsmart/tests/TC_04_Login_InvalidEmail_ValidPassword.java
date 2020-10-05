package com.qa.interestsmart.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.qa.interestsmart.base.BaseTest;

public class TC_04_Login_InvalidEmail_ValidPassword extends BaseTest {

	private static final Logger logger = LogManager.getLogger(TC_04_Login_InvalidEmail_ValidPassword.class);

	@Test
	public void TC_04_Login_InvalidEmail_ValidPassword() {
				
        // Invalid Email, Valid Password
		signInToApplication.checkUserUnableLoginWithInvalidUsernameAndValidPassword();
		
				
	}
}