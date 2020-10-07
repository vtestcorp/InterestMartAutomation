package com.qa.interestsmart.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.qa.interestsmart.base.BaseTest;

public class TC_18_Verify_Document_Button_Condition_Pending_Count_With_Pending_Item_Count extends BaseTest{
	private static final Logger logger = LogManager.getLogger(TC_18_Verify_Document_Button_Condition_Pending_Count_With_Pending_Item_Count.class);
	@Test
	public void TC_18_VerifyDocumentButtonConditionPendingCountWithPendingItemCount()
	{
		
		String username = prop.getProperty("validusername1");
		String password = prop.getProperty("validpassword1");	
		signInToApplication.loginWithValidUsernameAndPassword(username,password);
		signInToApplication.verifyDocumentButtonConditionPendingCountWithPendingItem();
	}

}
