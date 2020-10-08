package com.qa.interestsmart.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.qa.interestsmart.base.BaseTest;
import com.qa.interestsmart.model.AddressDetails;
import com.qa.interestsmart.model.LoanDetails;
import com.qa.interestsmart.model.User;
import com.qa.interestsmart.pages.SignInToApplication;
import com.qa.interestsmart.utils.JsonUtil;

public class TC_21_Submit_Loan_Pdf_Documents extends BaseTest{
	private static final Logger logger = LogManager.getLogger(TC_21_Submit_Loan_Pdf_Documents.class);
	@Test
	public void TC_21_Submit_Loan_PDF_Documents()
	{
		User loginDetails=new User();
		loginDetails=JsonUtil.readUserFromFile("TC_21_testdata1.json");
    	AddressDetails addressDetails=new AddressDetails();
    	addressDetails=JsonUtil.readAddressfromFile("TC_21_testdata_addressdetils.json");
    	LoanDetails loanDetails=new LoanDetails();
    	loanDetails=JsonUtil.readLoanDetailsfromFile("TC_21_testdata_loandetails.json");
    	
    	signInToApplication.loginWithValidUsernameAndPassword(loginDetails.emailAddress,loginDetails.password);
    	
    	signInToApplication.enterAddress(addressDetails.address);
    	signInToApplication.enterZipCode(addressDetails.pincode);
		signInToApplication.selectAddress();
		
		signInToApplication.fill_LoanDate(loanDetails.loanDate);
		signInToApplication.fill_LoanTerm(loanDetails.loanTerm);
		signInToApplication.fill_LoanType(loanDetails.loanType);
		signInToApplication.fill_InitialBalance(loanDetails.initialBalance);
		signInToApplication.click_GoButton();
		
//		signInToApplication.click_GetStartedButton();
//		signInToApplication.click_ContinueButton();
//		
	}

}
