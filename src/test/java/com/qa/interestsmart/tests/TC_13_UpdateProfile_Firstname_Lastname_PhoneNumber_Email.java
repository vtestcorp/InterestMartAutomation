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
import com.qa.interestsmart.utils.JsonUtil;

public class TC_13_UpdateProfile_Firstname_Lastname_PhoneNumber_Email extends BaseTest{
    private static final Logger logger = LogManager.getLogger(TC_13_UpdateProfile_Firstname_Lastname_PhoneNumber_Email.class);

    @Test
    public void TC_13_EditProfile_Firstname_Lastname_Phone_Email() throws JsonParseException, JsonMappingException, IOException
    {
    	UserDetailsWithUpdateDetails userDetails=new UserDetailsWithUpdateDetails();
    	userDetails=JsonUtil.userDetailsWithUpdatedDetails("TC_13_updateprofiledetails.json");
        signInToApplication.loginWithValidUsernameAndPassword();         
        signInToApplication.verifyProfile(userDetails.firstName, userDetails.lastName,userDetails.phoneNo,userDetails.emailAddress);
        signInToApplication.openUserProfile();
        signInToApplication.updateProfile(userDetails.updatefirstName, userDetails.updatelastName,userDetails.updatephoneNo,userDetails.updateemailAddress);
        signInToApplication.verifyProfile(userDetails.updatefirstName, userDetails.updatelastName,userDetails.updatephoneNo,userDetails.updateemailAddress);
        signInToApplication.openUserProfile();
        signInToApplication.updateProfile(userDetails.firstName, userDetails.lastName,userDetails.phoneNo,userDetails.emailAddress);       
        signInToApplication.logoutUserProfile();        
    }

}