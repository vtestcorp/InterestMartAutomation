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
import com.qa.interestsmart.model.UserDetailsWithUpdateDetails;
import com.qa.interestsmart.model.User_login;
import com.qa.interestsmart.utils.JsonUtil;


public class TC_14_ChangePassword extends BaseTest{
	private static final Logger logger = LogManager.getLogger(TC_14_ChangePassword.class);
	@Test
	public void Tc_14_ChangePassword_ByProfile() throws JsonParseException, JsonMappingException, IOException
	{


		UserDetailsWithUpdateDetails userDetails=new UserDetailsWithUpdateDetails();
    	userDetails=JsonUtil.userDetailsWithUpdatedDetails("TC_14_changepassworddetails.json");
		signInToApplication.loginWithValidUsernameAndPassword();
        signInToApplication.openUserProfile();
        signInToApplication.changePasswordUsingProfileDetails(userDetails.updatepassword);
        signInToApplication.logoutUserProfile();
		driver.get(prop.getProperty("url"));
        signInToApplication.loginWithValidUsernameAndPassword(userDetails.updateemailAddress, userDetails.updatepassword);
        signInToApplication.openUserProfile();
        signInToApplication.changePasswordUsingProfileDetails(userDetails.password);
	}

}
