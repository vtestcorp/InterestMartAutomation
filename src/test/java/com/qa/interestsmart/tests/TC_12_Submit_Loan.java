package com.qa.interestsmart.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.qa.interestsmart.base.BaseTest;
import com.qa.interestsmart.utils.ExcelUtil;
import com.qa.interestsmart.utils.Keyboard;

public class TC_12_Submit_Loan extends BaseTest {

	private static final Logger logger = LogManager.getLogger(TC_12_Submit_Loan.class);
	String filePath = System.getProperty("user.dir");

	@Test
	public void TC_12_Submit_Loan() throws Exception {
		// test = extent.createTest("TC_12_Submit_Loan", "Submit Loan");
		// Valid Email, Valid Password
		signInToApplication.loginWithValidUsernameAndPassword();


		loanDetails.enterSSN(ExcelUtil.ReadCellData(8, 4, "Address"));
		loanDetails.enterDOB(ExcelUtil.ReadCellData(9, 4, "Address"));
		loanDetails.enterYearsInSchool(ExcelUtil.ReadCellData(10, 4, "Address"));
		loanDetails.enterMaritalStatus(ExcelUtil.ReadCellData(11, 4, "Address"));
		loanDetails.enterDependents(ExcelUtil.ReadCellData(12, 4, "Address"));
		loanDetails.enterDependentsAge(ExcelUtil.ReadCellData(13, 4, "Address"));
		loanDetails.enterYearsOfAddress(ExcelUtil.ReadCellData(14, 4, "Address"));
		loanDetails.enterMonthAtAddress(ExcelUtil.ReadCellData(15, 4, "Address"));
		loanDetails.clickNextButton();
		loanDetails.enterTypeOfProperty(ExcelUtil.ReadCellData(16, 4, "Address"));
		loanDetails.select_AreYouSelfEmployed(ExcelUtil.ReadCellData(17, 4, "Address"));
		loanDetails.enter_MonthlyIncome(ExcelUtil.ReadCellData(18, 4, "Address"));
		loanDetails.enter_EmployerName(ExcelUtil.ReadCellData(19, 4, "Address"));
		loanDetails.enter_BusinessPhone(ExcelUtil.ReadCellData(20, 4, "Address"));
		loanDetails.enter_Position(ExcelUtil.ReadCellData(21, 4, "Address"));
		loanDetails.enter_YearsAtJob(ExcelUtil.ReadCellData(22, 4, "Address"));
		loanDetails.enter_YearsInLineOfWork(ExcelUtil.ReadCellData(23, 4, "Address"));
		loanDetails.enter_EmployerAddress(ExcelUtil.ReadCellData(24, 4, "Address"));
		loanDetails.enter_City(ExcelUtil.ReadCellData(25, 4, "Address"));
		loanDetails.enter_State(ExcelUtil.ReadCellData(26, 4, "Address"));
		loanDetails.enter_ZipCode(ExcelUtil.ReadCellData(27, 4, "Address"));
		loanDetails.clickIncomeNextButton();
		// Assests
		loanDetails.enter_AssestsType(ExcelUtil.ReadCellData(28, 4, "Address"));
		loanDetails.enter_AssestsName(ExcelUtil.ReadCellData(29, 4, "Address"));
		loanDetails.enter_AssestsValue(ExcelUtil.ReadCellData(30, 4, "Address"));
		loanDetails.select_PlansForThisProperty(ExcelUtil.ReadCellData(31, 4, "Address"));
//		loanDetails.enterTypeOfProperty("Townhouse");
		loanDetails.clickAssestsNextButton();
		// Declarations
		loanDetails.question_1("Yes");
		loanDetails.question_2("No");
		loanDetails.question_3("Yes");
		loanDetails.question_4("No");
		loanDetails.question_5("Yes");
		loanDetails.question_6("No");
		loanDetails.question_7("Yes");
		loanDetails.question_8("No");
		loanDetails.question_9("Yes");
		loanDetails.question_10("Yes");
		loanDetails.question_11("No");
		loanDetails.question_12("Yes");
		loanDetails.clickDeclarationNextButton();
		loanDetails.uploadDriverLicense(filePath+"\\"+"Documents\\driver license.png");
		loanDetails.uploadPaystubs(filePath+"\\"+"Documents\\paystubs.png");
		loanDetails.uploadW2s(filePath+"\\"+"Documents\\W2s.png");
		loanDetails.uploadTaxReturns(filePath+"\\"+"Documents\\tax returns.png");
		loanDetails.uploadBankStatements(filePath+"\\"+"Documents\\bank statements.png");
		loanDetails.uploadIRA(filePath+"\\"+"Documents\\IRA.png");
		loanDetails.clickFinishDocuments();
		loanDetails.verify_ApplicationSubmitted();
	}
}