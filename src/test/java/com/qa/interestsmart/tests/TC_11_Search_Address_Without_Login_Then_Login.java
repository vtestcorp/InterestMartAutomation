package com.qa.interestsmart.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.qa.interestsmart.base.BaseTest;
import com.qa.interestsmart.utils.ExcelUtil;

public class TC_11_Search_Address_Without_Login_Then_Login extends BaseTest {

	private static final Logger logger = LogManager.getLogger(TC_11_Search_Address_Without_Login_Then_Login.class);

	@Test
	public void TC_01_Search_Address_Without_Login_Then_Login() {
		// Search Loan
		signInToApplication.enterAddress(ExcelUtil.ReadCellData(1, 4, "Address"));
        signInToApplication.selectAddress();
		signInToApplication.fill_LoanDate(ExcelUtil.ReadCellData(3, 3, "Address"));
		signInToApplication.fill_LoanTerm(ExcelUtil.ReadCellData(4, 3, "Address"));
		signInToApplication.fill_LoanType(ExcelUtil.ReadCellData(5, 3, "Address"));
		signInToApplication.fill_InitialBalance(ExcelUtil.ReadCellData(6, 3, "Address"));
		signInToApplication.click_GoButton();

		signInToApplication.click_GetStartedButton();
		signInToApplication.click_SignHereButton();
		signInToApplication.userLoginWithValidUsernameAndPasswordAndSignOutApplication();		
	}
}