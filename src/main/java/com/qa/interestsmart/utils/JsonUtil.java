package com.qa.interestsmart.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.qa.interestsmart.model.AllUserDetailsForLoanApplication;
import com.qa.interestsmart.model.PopUpDetails;
import com.qa.interestsmart.model.User;
import com.qa.interestsmart.model.UserDetailsUploadFile;
import com.qa.interestsmart.model.UserDetailsWithPendingCountNo;
import com.qa.interestsmart.model.UserDetailsWithUpdateDetails;

import config.DefineConstants;

public class JsonUtil {
	static ObjectMapper mapper = new ObjectMapper();
	public static User readUserFromFile(String filename) {
		User user1 = null;
		File fileReader  = new File(DefineConstants.TestDataJson_Folder + "/" + filename);
		try {
			InputStream inputStream1 = new FileInputStream(fileReader);
			user1 = mapper.readValue(inputStream1, User.class);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return user1;
	}
	
	
	
	public static AllUserDetailsForLoanApplication allUserDetailsForLoanApplication(String filename)
	{
		AllUserDetailsForLoanApplication user1 = null;
		File fileReader  = new File(DefineConstants.TestDataJson_Folder + "/" + filename);
		try {
			InputStream inputStream1 = new FileInputStream(fileReader);
			user1 = mapper.readValue(inputStream1, AllUserDetailsForLoanApplication.class);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return user1;
	}
	
	public static PopUpDetails popUpDetails(String filename)
	{
		PopUpDetails user1 = null;
		File fileReader  = new File(DefineConstants.TestDataJson_Folder + "/" + filename);
		try {
			InputStream inputStream1 = new FileInputStream(fileReader);
			user1 = mapper.readValue(inputStream1, PopUpDetails.class);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return user1;
	}
	
	public static UserDetailsWithUpdateDetails userDetailsWithUpdatedDetails(String filename)
	{
		UserDetailsWithUpdateDetails user1 = null;
		File fileReader  = new File(DefineConstants.TestDataJson_Folder + "/" + filename);
		try {
			InputStream inputStream1 = new FileInputStream(fileReader);
			user1 = mapper.readValue(inputStream1, UserDetailsWithUpdateDetails.class);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return user1;
	}
	
	public static UserDetailsUploadFile userDetailsUploadFile(String filename)
	{
		UserDetailsUploadFile user1 = null;
		File fileReader  = new File(DefineConstants.TestDataJson_Folder + "/" + filename);
		try {
			InputStream inputStream1 = new FileInputStream(fileReader);
			user1 = mapper.readValue(inputStream1,UserDetailsUploadFile.class);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return user1;
		
	}
	
	public static UserDetailsWithPendingCountNo userDetailsWithPendingCountNo(String filename)
	{
		UserDetailsWithPendingCountNo user1 = null;
		File fileReader  = new File(DefineConstants.TestDataJson_Folder + "/" + filename);
		try {
			InputStream inputStream1 = new FileInputStream(fileReader);
			user1 = mapper.readValue(inputStream1,UserDetailsWithPendingCountNo.class);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return user1;
		
	}
}
