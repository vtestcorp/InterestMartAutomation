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
        signInToApplication.updateProfile("FirstNameUpdated", "LastNameUpdated","903-963-6869");
        signInToApplication.verifyProfile("FirstNameUpdated", "LastNameUpdated","903-963-6869");
        signInToApplication.updateProfile("sud20", "Singh","903-962-6866");
        signInToApplication.logoutUserProfile();
        
    }

}