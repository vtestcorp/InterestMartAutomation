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
import com.qa.interestsmart.tests.model.User;
import com.qa.interestsmart.tests.model.User_login;

public class TC_14_ChangePassword extends BaseTest{
	private static final Logger logger = LogManager.getLogger(TC_14_ChangePassword.class);
	@Test
	public void Tc_14_ChangePassword_ByProfile() throws JsonParseException, JsonMappingException, IOException
	{
		InputStream inputStream1 = TC_14_ChangePassword.class.getClassLoader().getResourceAsStream("user_login_newpassword.json");
    	InputStream inputStream2 = TC_14_ChangePassword.class.getClassLoader().getResourceAsStream("user_login_oldpassword.json");
    	ObjectMapper mapper = new ObjectMapper();
    	User_login user1 = mapper.readValue(inputStream1, User_login.class);
    	User_login user2 = mapper.readValue(inputStream2, User_login.class);

		signInToApplication.loginWithValidUsernameAndPassword();
        signInToApplication.openUserProfile();
        signInToApplication.changePasswordUsingProfileDetails(user1.password);
        signInToApplication.logoutUserProfile();
		driver.get(prop.getProperty("url"));
        signInToApplication.loginWithValidUsernameAndPassword(user1.email, user1.password);
        signInToApplication.openUserProfile();
        signInToApplication.changePasswordUsingProfileDetails(user2.password);
	}

}
