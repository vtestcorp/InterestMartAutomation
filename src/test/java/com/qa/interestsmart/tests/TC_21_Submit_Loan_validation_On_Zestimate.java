package com.qa.interestsmart.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.qa.interestsmart.base.BaseTest;

import com.qa.interestsmart.model.AllUserDetailsForLoanApplication;


import com.qa.interestsmart.pages.SignInToApplication;
import com.qa.interestsmart.utils.JsonUtil;

public class TC_21_Submit_Loan_validation_On_Zestimate extends BaseTest{
	private static final Logger logger = LogManager.getLogger(TC_21_Submit_Loan_validation_On_Zestimate.class);
	@Test
	public void TC_21_Submit_Loan_PDF_Documents()
	{
	AllUserDetailsForLoanApplication details=new AllUserDetailsForLoanApplication();		
	details=JsonUtil.allUserDetailsForLoanApplication("TC_21_Submit_Loan_validation_On_Zestimate.json");
	
    	
    	signInToApplication.loginWithValidUsernameAndPassword(details.emailAddress,details.password);
    	
    	signInToApplication.enterAddress(details.address);
    	signInToApplication.enterZipCode(details.pincode);
		signInToApplication.selectAddress();
		
		signInToApplication.fill_LoanDate(details.loanDate);
		signInToApplication.fill_LoanTerm(details.loanTerm);
		signInToApplication.fill_LoanType(details.loanType);
		signInToApplication.fill_InitialBalance(details.initialBalance);
		
		signInToApplication.fill_LoanType(details.loanType);
		signInToApplication.fill_LoanTerm(details.loanTerm);
		signInToApplication.click_GoButton();
		
		signInToApplication.validation_on_Zestimate(details.alertmessage);
		
	}

}
