package com.qa.interestsmart.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.qa.interestsmart.base.BaseTest;
import com.qa.interestsmart.utils.ExcelUtil;

public class TC_09_Verify_MonthlyPayment_RemainingBalance extends BaseTest {

	private static final Logger logger = LogManager.getLogger(TC_09_Verify_MonthlyPayment_RemainingBalance.class);

	@Test
	public void TC_09_Verify_MonthlyPayment_RemainingBalance() {
		// Search Loan
		signInToApplication.checkLoanByEnteringLoanDetails(ExcelUtil.ReadCellData(3, 0, "Address"),
				ExcelUtil.ReadCellData(1, 1, "Address"));

		signInToApplication.fill_LoanDate(ExcelUtil.ReadCellData(1, 2, "Address"));
		signInToApplication.fill_LoanTerm(ExcelUtil.ReadCellData(2, 2, "Address"));
		signInToApplication.fill_LoanType(ExcelUtil.ReadCellData(3, 2, "Address"));
		signInToApplication.fill_InitialBalance(ExcelUtil.ReadCellData(4, 2, "Address"));
		signInToApplication.print_RemainingBalance();
		signInToApplication.printMonthlyPayment();
		// verify
		signInToApplication.CalculateExpectedvalues(3.69, 1000.00, 360);
		signInToApplication.verifyRemainingBalance();
		signInToApplication.verifyMonthlypayment();
		signInToApplication.assertAll();
	}
}