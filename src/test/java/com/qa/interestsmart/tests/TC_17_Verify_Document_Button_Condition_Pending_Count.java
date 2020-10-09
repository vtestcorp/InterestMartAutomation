package com.qa.interestsmart.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.qa.interestsmart.base.BaseTest;
import com.qa.interestsmart.model.User;
import com.qa.interestsmart.utils.JsonUtil;

public class TC_17_Verify_Document_Button_Condition_Pending_Count extends BaseTest {
	private static final Logger logger = LogManager.getLogger(TC_17_Verify_Document_Button_Condition_Pending_Count.class);
	@Test
	public void TC_17_VerifyDocumentButtonConditionPendingCount()
	{
		User loginDetails=new User();
		loginDetails=JsonUtil.readUserFromFile("TC_17_verifydocumentbuttonpendingCount.json");

		signInToApplication.loginWithValidUsernameAndPassword(loginDetails.emailAddress,loginDetails.password);
		signInToApplication.verifyConditionPendingCount(loginDetails.address);
	}

}
