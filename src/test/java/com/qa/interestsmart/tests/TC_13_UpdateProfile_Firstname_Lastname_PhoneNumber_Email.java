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
import com.qa.interestsmart.utils.JsonUtil;

public class TC_13_UpdateProfile_Firstname_Lastname_PhoneNumber_Email extends BaseTest{
    private static final Logger logger = LogManager.getLogger(TC_13_UpdateProfile_Firstname_Lastname_PhoneNumber_Email.class);

    @Test
    public void TC_13_EditProfile_Firstname_Lastname_Phone_Email() throws JsonParseException, JsonMappingException, IOException
    {

    	User user1=new User();
    	User user2=new User();
    	user1=JsonUtil.readUserFromFile("TC_13_UpdateProfile_olddetails.json");
    	user2=JsonUtil.readUserFromFile("TC_13_UpdateProfile_newdetails.json");
        signInToApplication.loginWithValidUsernameAndPassword();        
        signInToApplication.verifyProfile(user1.firstName, user1.lastName,user1.phoneNo,user1.emailAddress);      
        signInToApplication.openUserProfile();
        signInToApplication.updateProfile(user2.firstName, user2.lastName,user2.phoneNo,user2.emailAddress);
        signInToApplication.verifyProfile(user2.firstName, user2.lastName,user2.phoneNo,user2.emailAddress);
        signInToApplication.openUserProfile();
        signInToApplication.updateProfile(user1.firstName, user1.lastName,user1.phoneNo,user1.emailAddress);
       
        signInToApplication.logoutUserProfile();        
    }

}