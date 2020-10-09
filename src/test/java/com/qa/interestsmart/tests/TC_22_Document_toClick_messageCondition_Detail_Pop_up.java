package com.qa.interestsmart.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.qa.interestsmart.base.BaseTest;
import com.qa.interestsmart.model.PopUpDetails;
import com.qa.interestsmart.utils.JsonUtil;

public class TC_22_Document_toClick_messageCondition_Detail_Pop_up extends BaseTest {
	private static final Logger logger = LogManager.getLogger(TC_22_Document_toClick_messageCondition_Detail_Pop_up.class);
	@Test
	public void TC_22_document_toClick_messageCondition_details_Pop_Up()
	{
		PopUpDetails details=new PopUpDetails();
		details=JsonUtil.popUpDetails("TC_22_Document_toClick_messageCondition_Detail_Pop_up.json");
		
		signInToApplication.loginWithValidUsernameAndPassword(details.emailAddress,details.password);
		signInToApplication.document_toClick_messgaeConditiondetail_Pop_Up(details.address,details.category,details.status,details.condition);
		
	}

}
