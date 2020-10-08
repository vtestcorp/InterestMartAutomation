package com.qa.interestsmart.tests;

import java.io.IOException;
import java.io.InputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.interestsmart.base.BaseTest;
import com.qa.interestsmart.model.User;
import com.qa.interestsmart.model.User_login;
import com.qa.interestsmart.utils.JsonUtil;


public class TC_14_ChangePassword extends BaseTest{
	private static final Logger logger = LogManager.getLogger(TC_14_ChangePassword.class);
	@Test
	public void Tc_14_ChangePassword_ByProfile() throws JsonParseException, JsonMappingException, IOException
	{

		User user1=JsonUtil.readUserFromFile("TC_14_changepassword_newdetail.json");
		User user2=JsonUtil.readUserFromFile("TC_14_changepassword_olddetail.json");
		signInToApplication.loginWithValidUsernameAndPassword();
        signInToApplication.openUserProfile();
        signInToApplication.changePasswordUsingProfileDetails(user1.password);
        signInToApplication.logoutUserProfile();
		driver.get(prop.getProperty("url"));
        signInToApplication.loginWithValidUsernameAndPassword(user1.emailAddress, user1.password);
        signInToApplication.openUserProfile();
        signInToApplication.changePasswordUsingProfileDetails(user2.password);
	}

}
