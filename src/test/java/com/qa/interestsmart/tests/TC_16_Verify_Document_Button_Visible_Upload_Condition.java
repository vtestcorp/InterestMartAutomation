package com.qa.interestsmart.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.qa.interestsmart.base.BaseTest;

public class TC_16_Verify_Document_Button_Visible_Upload_Condition extends BaseTest {
	private static final Logger logger = LogManager.getLogger(TC_16_Verify_Document_Button_Visible_Upload_Condition.class);
	@Test
	public void Tc_16_VerifyDocumentButtonVisibleUploadCondition()
	{
			
		String username = prop.getProperty("validusername1");
		String password = prop.getProperty("validpassword1");
		signInToApplication.loginWithValidUsernameAndPassword(username,password);
		signInToApplication.verifyDocumentButton();
	}

}
