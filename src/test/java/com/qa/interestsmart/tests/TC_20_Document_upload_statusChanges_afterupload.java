package com.qa.interestsmart.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.qa.interestsmart.base.BaseTest;

import com.qa.interestsmart.model.UserDetailsUploadFile;
import com.qa.interestsmart.utils.JsonUtil;

public class TC_20_Document_upload_statusChanges_afterupload extends BaseTest {
	private static final Logger logger = LogManager.getLogger(TC_20_Document_upload_statusChanges_afterupload.class);
	@Test
	public void TC_20_DocumentUploadStausChangeAfterUpload()
	{
		UserDetailsUploadFile loginDetails=new UserDetailsUploadFile();
		loginDetails=JsonUtil.userDetailsUploadFile("TC_20_documentuploadstatuschangesafterupload.json");

		signInToApplication.loginWithValidUsernameAndPassword(loginDetails.emailAddress,loginDetails.password);
		signInToApplication.documentUploadAndCheckStaus(loginDetails.address,loginDetails.conditionName,loginDetails.status,loginDetails.filename,loginDetails.updateStatus);
	}

}
