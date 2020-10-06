package com.qa.interestsmart.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.qa.interestsmart.base.BaseTest;

public class TC_14_ChangePassword extends BaseTest{
	private static final Logger logger = LogManager.getLogger(TC_14_ChangePassword.class);
	@Test
	public void Tc_14_ChangePassword_ByProfile()
	{
		String oldPassword = prop.getProperty("validpassword1");
		String newPassword = prop.getProperty("validpassword2");
		String username = prop.getProperty("validusername1");
		signInToApplication.loginWithValidUsernameAndPassword();
        signInToApplication.openUserProfile();
        signInToApplication.changePasswordUsingProfileDetails(newPassword);
        signInToApplication.logoutUserProfile();
		driver.get(prop.getProperty("url"));
        signInToApplication.loginWithValidUsernameAndPassword(username, newPassword);
        signInToApplication.openUserProfile();
        signInToApplication.changePasswordUsingProfileDetails(oldPassword);
	}

}
