package com.qa.interestsmart.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.qa.interestsmart.base.BaseTest;

import com.qa.interestsmart.model.User;
import com.qa.interestsmart.utils.JsonUtil;

public class TC_16_Verify_Document_Button_Visible_Upload_Condition extends BaseTest {
	private static final Logger logger = LogManager.getLogger(TC_16_Verify_Document_Button_Visible_Upload_Condition.class);
	@Test
	public void Tc_16_VerifyDocumentButtonVisibleUploadCondition()
	{
			
		User loginDetails=new User();
		loginDetails=JsonUtil.readUserFromFile("TC_16_verifydocumentbuttonLogin.json");
				
		signInToApplication.loginWithValidUsernameAndPassword(loginDetails.emailAddress,loginDetails.password);
		signInToApplication.verifyDocumentButton(loginDetails.address);
	}

}
