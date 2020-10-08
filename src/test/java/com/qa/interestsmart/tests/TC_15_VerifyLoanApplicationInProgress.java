package com.qa.interestsmart.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.qa.interestsmart.base.BaseTest;
import com.qa.interestsmart.model.User;

import com.qa.interestsmart.utils.JsonUtil;

public class TC_15_VerifyLoanApplicationInProgress extends BaseTest {
	private static final Logger logger = LogManager.getLogger(TC_15_VerifyLoanApplicationInProgress.class);
	@Test
	public void TC_15_VerifyLoanApplicationAfterSearchStaus()
	{
		User loginDetails=new User();
		loginDetails=JsonUtil.readUserFromFile("TC_15_verifyloanapplicationInProgress");
		signInToApplication.loginWithValidUsernameAndPassword();		
		signInToApplication.verifyLoanApplicationStatus(loginDetails.address);		
	}

}
