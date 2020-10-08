package com.qa.interestsmart.utils;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.interestsmart.model.AddressDetails;
import com.qa.interestsmart.model.LoanDetails;
import com.qa.interestsmart.model.User;

public class JsonUtil {
	public static User readUserFromFile(String filename) {
		InputStream inputStream1 = JsonUtil.class.getClassLoader().getResourceAsStream(filename);

		ObjectMapper mapper = new ObjectMapper();

		User user1 = null;
		try {
			user1 = mapper.readValue(inputStream1, User.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user1;
	}
	
	public static AddressDetails readAddressfromFile(String filename)
	{
		InputStream inputStream1 = JsonUtil.class.getClassLoader().getResourceAsStream(filename);

		ObjectMapper mapper = new ObjectMapper();

		AddressDetails user1 = null;
		try {
			user1 = mapper.readValue(inputStream1, AddressDetails.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user1;
		
	}
	public static LoanDetails readLoanDetailsfromFile(String filename)
	{
		InputStream inputStream1 = JsonUtil.class.getClassLoader().getResourceAsStream(filename);

		ObjectMapper mapper = new ObjectMapper();

		LoanDetails user1 = null;
		try {
			user1 = mapper.readValue(inputStream1, LoanDetails.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user1;
	}
}
