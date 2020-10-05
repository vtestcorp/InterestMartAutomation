package com.qa.interestsmart.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.qa.interestsmart.base.BaseTest;
import com.qa.interestsmart.utils.ExcelUtil;

public class TC_08_SearchLoan_ByInValidAddress extends BaseTest {

	private static final Logger logger = LogManager.getLogger(TC_08_SearchLoan_ByInValidAddress.class);

	@Test
	public void TC_08_SearchLoan_ByInValidAddress() {
		//Search Loan		
		signInToApplication.checkLoanByEnteringAddress(ExcelUtil.ReadCellData(2, 0, "Address"),ExcelUtil.ReadCellData(1, 1, "Address"));
				
	}
}