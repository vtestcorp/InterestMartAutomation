package com.qa.interestsmart.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.qa.interestsmart.base.BaseTest;
import com.qa.interestsmart.utils.ExcelUtil;

public class TC_10_Verify_MonthlyPayment_RemainingBalance_NegativeScenario extends BaseTest {

	private static final Logger logger = LogManager.getLogger(TC_10_Verify_MonthlyPayment_RemainingBalance_NegativeScenario.class);

	@Test
	public void TC_10_Verify_MonthlyPayment_RemainingBalance_NegativeScenario() {
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
		signInToApplication.CalculateExpectedvalues(4, 1000.00, 360);
		signInToApplication.verifyRemainingBalance();
		signInToApplication.verifyMonthlypayment();
		signInToApplication.assertAll();
	}
}