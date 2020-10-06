package com.qa.interestsmart.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.qa.interestsmart.base.BaseTest;
import com.qa.interestsmart.utils.ExcelUtil;

public class TC_15_VerifyLoanApplicationInProgress extends BaseTest {
	private static final Logger logger = LogManager.getLogger(TC_15_VerifyLoanApplicationInProgress.class);
	@Test
	public void TC_15_VerifyLoanApplicationAfterSearchStaus()
	{
		String oldPassword = prop.getProperty("validpassword1");	
		String username = prop.getProperty("validusername1");
		signInToApplication.loginWithValidUsernameAndPassword();		
		signInToApplication.verifyLoanApplicationStatus(ExcelUtil.ReadCellData(3, 0,"Address"));		
	}

}
