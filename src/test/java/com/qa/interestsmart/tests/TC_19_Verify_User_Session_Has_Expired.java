package com.qa.interestsmart.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.qa.interestsmart.base.BaseTest;

public class TC_19_Verify_User_Session_Has_Expired extends BaseTest{
	private static final Logger logger = LogManager.getLogger(TC_19_Verify_User_Session_Has_Expired.class);
	@Test
	public void TC_19_VerifyYourSessionHasExpired()
	{
		String username = prop.getProperty("validusername1");
		String password = prop.getProperty("validpassword1");	
		signInToApplication.loginWithValidUsernameAndPassword(username,password);
		signInToApplication.verifySessionHasExpiredAfterTimeOut();
		//signInToApplication.openUserProfile();
	}

}
