package com.qa.interestsmart.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.qa.interestsmart.base.BaseTest;

public class TC_17_Verify_Document_Button_Condition_Pending_Count extends BaseTest {
	private static final Logger logger = LogManager.getLogger(TC_17_Verify_Document_Button_Condition_Pending_Count.class);
	@Test
	public void TC_17_VerifyDocumentButtonConditionPendingCount()
	{
		String password = prop.getProperty("validpassword1");	
		String username = prop.getProperty("validusername1");
		signInToApplication.loginWithValidUsernameAndPassword(username,password);
		signInToApplication.verifyConditionPendingCount();
	}

}
