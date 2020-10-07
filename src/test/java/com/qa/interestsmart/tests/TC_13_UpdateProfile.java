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

public class TC_13_UpdateProfile extends BaseTest{
    private static final Logger logger = LogManager.getLogger(TC_13_UpdateProfile.class);

    @Test
    public void TC_13_EditProfile() throws JsonParseException, JsonMappingException, IOException
    {
    	InputStream inputStream1 = TC_13_UpdateProfile.class.getClassLoader().getResourceAsStream("user_detail_1.json");
    	InputStream inputStream2 = TC_13_UpdateProfile.class.getClassLoader().getResourceAsStream("user_detail_2.json");
    	ObjectMapper mapper = new ObjectMapper();
    	User user1 = mapper.readValue(inputStream1, User.class);
    	User user2 = mapper.readValue(inputStream2, User.class);

        signInToApplication.loginWithValidUsernameAndPassword();
        
        signInToApplication.verifyProfile(user1.firstName, user1.lastName,user1.phoneNo);
		
        signInToApplication.openUserProfile();
        signInToApplication.updateProfile(user2.firstName, user2.lastName,user2.phoneNo);
        signInToApplication.verifyProfile(user2.firstName, user2.lastName,user2.phoneNo);
        signInToApplication.openUserProfile();
        signInToApplication.updateProfile(user1.firstName, user1.lastName,user1.phoneNo);
       
        signInToApplication.logoutUserProfile();        
    }

}