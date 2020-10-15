package com.qa.interestsmart.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.qa.interestsmart.base.BaseTest;
import com.qa.interestsmart.model.User;
import com.qa.interestsmart.model.UserDetailsWithPendingCountNo;
import com.qa.interestsmart.utils.JsonUtil;

public class TC_18_Verify_Document_Button_Condition_Pending_Count_With_Pending_Item_Count extends BaseTest{
	private static final Logger logger = LogManager.getLogger(TC_18_Verify_Document_Button_Condition_Pending_Count_With_Pending_Item_Count.class);
	@Test
	public void TC_18_VerifyDocumentButtonConditionPendingCountWithPendingItemCount()
	{
		
		UserDetailsWithPendingCountNo loginDetails=new UserDetailsWithPendingCountNo();
		loginDetails=JsonUtil.userDetailsWithPendingCountNo("TC_18_verifyDocumentButtonConditionPendingCountwithPendingItemCount.json");
		signInToApplication.loginWithValidUsernameAndPassword(loginDetails.emailAddress,loginDetails.password);
		signInToApplication.verifyDocumentButtonConditionPendingCountWithPendingItem(loginDetails.address);
		
	}

}
