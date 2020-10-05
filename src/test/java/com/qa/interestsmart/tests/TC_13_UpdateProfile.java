package com.qa.interestsmart.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.qa.interestsmart.base.BaseTest;

public class TC_13_UpdateProfile extends BaseTest{
    private static final Logger logger = LogManager.getLogger(TC_13_UpdateProfile.class);

    @Test
    public void TC_13_EditProfile()
    {
        signInToApplication.loginWithValidUsernameAndPassword();
        signInToApplication.openUserProfile();
        signInToApplication.updateProfile("FirstNameUpdated", "LastNameUpdated");
        signInToApplication.verifyProfile("FirstNameUpdated", "LastNameUpdated");
        signInToApplication.updateProfile("sud20", "Singh");
        
    }

}